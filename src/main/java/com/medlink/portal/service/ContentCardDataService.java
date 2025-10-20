package com.medlink.portal.service;

import com.medlink.portal.dto.ApiVersionDto;
import com.medlink.portal.dto.ClientDetailsDto;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

import static com.medlink.portal.utils.Constants.API_BASE_URL;
import static com.medlink.portal.utils.Constants.CLIENTS_API;

@Service
@Transactional(rollbackOn = Throwable.class)
@Slf4j
public class ContentCardDataService {

    @Autowired
    private ApiDataService apiDataService;

    public CompletableFuture<ApiVersionDto> getApiVersionAsync() {

        String url = API_BASE_URL + "/content-card/info";
        return apiDataService.getDataAsync(url, ApiVersionDto.class);

    }

    public CompletableFuture<ClientDetailsDto> getClientsAsync(String clientType) {

        if (clientType == null) {
            throw new IllegalArgumentException("clientType cannot be null");
        }

        String url = CLIENTS_API + "/" + clientType;
        return apiDataService.getDataAsync(url, ClientDetailsDto.class);

    }
}
