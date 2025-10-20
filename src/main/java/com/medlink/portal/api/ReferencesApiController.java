package com.medlink.portal.api;

import com.medlink.portal.dto.ClientNotificationDto;
import com.medlink.portal.dto.KeyValuePairModel;
import com.medlink.portal.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ReferencesApiController {

    private final DataService dataService;

    //TODO - Check where it is being used as it has 0 references
//    // OPTIONS endpoint
//    <Void> options() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    // GET: client-list/{lobId}
    @GetMapping("/client-list/{lobId}")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getClientsAsync(@PathVariable String lobId) {
        return dataService.getClientsListAsync(lobId).thenApply(clientList -> {
            clientList.addFirst(new KeyValuePairModel("0", "-- SELECT CLIENT --"));
            return ResponseEntity.ok(clientList);
        });
    }

    // GET: notification/{clientId}
    @GetMapping("/notification/{clientId}")
    public CompletableFuture<ResponseEntity<List<ClientNotificationDto>>> getClientNotifications(@PathVariable int clientId) {
        return dataService.getClientNotificationsAsync(clientId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/pack-list/{id}
    @GetMapping("/kit/pack-list/{id}")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getKitPacksAsync(@PathVariable int id) {
        return dataService.getKitPackListAsync(id).thenApply(packList -> {
            if (packList.size() > 1) {
                packList.addFirst(new KeyValuePairModel("0", "-- SELECT PACK --"));
            }
            return ResponseEntity.ok(packList);
        });
    }

    // GET: systems-list
    @GetMapping("/systems-list")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getSystemsListAsync() {
        return dataService.getSystemsListAsync().thenApply(systemList -> {
            systemList.addFirst(new KeyValuePairModel("0", "-- SELECT SYSTEM --"));
            return ResponseEntity.ok(systemList);
        });
    }

    // GET: products/therapeutic-categories/{systemId}
    @GetMapping("/products/therapeutic-categories/{systemId}")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getTherapeuticCategoriesAsync(@PathVariable int systemId) {
        return dataService.getTherapeuticCategoriesAsync(systemId).thenApply(subClassesList -> {
            if (subClassesList.size() > 1) {
                subClassesList.addFirst(new KeyValuePairModel("0", "-- ALL CATEGORIES --"));
            }
            return ResponseEntity.ok(subClassesList);
        });
    }

    // GET: products/therapeutic-subclasses/{id}
    @GetMapping("/products/therapeutic-subclasses/{id}")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getTherapeuticSubCategoriesAsync(@PathVariable int id) {
        return dataService.getTherapeuticSubClassesListAsync(id).thenApply(subClassesList -> {
            subClassesList.addFirst(new KeyValuePairModel("0", "-- SELECT THERAPEUTIC SUB CLASS --"));
            return ResponseEntity.ok(subClassesList);
        });
    }
}
