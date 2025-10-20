package com.medlink.portal.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.medlink.portal.config.Config;
import com.medlink.portal.dto.ProcessingResults;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional(rollbackOn = Throwable.class)
@Slf4j
public class ApiDataService{

    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private ProcessingResults processingResults;

    public ApiDataService() {
        this.client = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    public <T> CompletableFuture<T> getDataAsync(String url, Class<T> responseType) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization-Token", Config.getApiToken())
                // Add other headers here if needed
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == HttpStatus.OK.value()) {
                        try {
                            return objectMapper.readValue(response.body(), responseType);
                        } catch (Exception e) {
                            processingResults.getProcessingErrors().add(e.getMessage() + " / getDataAsync");
                        }
                    } else {
                        processingResults.getProcessingErrors().add(response.statusCode() + " / getDataAsync");
                    }
                    return null;
                });
    }


    private <T> CompletableFuture<List<T>> getDataListAsync(String url, TypeReference<List<T>> typeRef) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .header("Accept", "application/json")
                .header("Authorization-Token", Config.getApiToken())
                .build();

        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(response -> {
                    if (response.statusCode() == 200) {
                        try {
                            List<T> result = objectMapper.readValue(response.body(), typeRef);
                            return result != null ? result : List.of();
                        } catch (Exception e) {
                            processingResults.getProcessingErrors().add(e.getMessage() + " / getDataListAsync - " + url);
                        }
                    } else {
                        processingResults.getProcessingErrors().add(response.statusCode() + " / getDataListAsync - " + url);
                    }
                    return List.of(); // return empty list on error
                });
    }

}
