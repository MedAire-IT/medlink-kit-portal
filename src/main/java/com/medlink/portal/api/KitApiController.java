package com.medlink.portal.api;

import com.medlink.portal.dto.KeyValuePairModel;
import com.medlink.portal.dto.KitContentsModel;
import com.medlink.portal.dto.KitMedViewHeader;
import com.medlink.portal.dto.KitPackItem;
import com.medlink.portal.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/kits")
@AllArgsConstructor
public class KitApiController {

    private final DataService dataService;



    // OPTIONS endpoint
    //TODO - Check where it is being used as it has 0 references
//    @RequestMapping(method = RequestMethod.OPTIONS)
//    options() {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

    // GET: kit/contents/{kitId}
    @GetMapping("/kit/contents/{kitId}")
    public CompletableFuture<ResponseEntity<List<KitMedViewHeader>>> getKitContentsByKitAsync(@PathVariable int kitId) {
        return dataService.getKitContentsByKitAsync(kitId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/contents/item/{kitId}/{subPackId}/{productId}
    @GetMapping("/kit/contents/item/{kitId}/{subPackId}/{productId}")
    public CompletableFuture<ResponseEntity<List<KitPackItem>>> getKitPackItemsAsync(
            @PathVariable int kitId,
            @PathVariable int subPackId,
            @PathVariable int productId) {
        return dataService.getKitPackItemsAsync(kitId, subPackId, productId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: client/kit-list/{id}
    @GetMapping("/client/kit-list/{id}")
    public CompletableFuture<ResponseEntity<List<KeyValuePairModel>>> getClientKitsAsync(@PathVariable int id) {
        return dataService.getClientKitsListAsync(id).thenApply(clientKitList -> {
            if (clientKitList.size() > 1) {
                clientKitList.add(0, new KeyValuePairModel("0", "-- SELECT KIT --"));
            }
            return ResponseEntity.ok(clientKitList);
        });
    }

    // GET: kit/diagnostics/{id}
    @GetMapping("/kit/diagnostics/{id}")
    public CompletableFuture<ResponseEntity<List<KitContentsModel>>> getKitDiagnosticsAsync(@PathVariable int id) {
        return dataService.getKitDiagnosticsAsync(id)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/priority/{kitId}
    @GetMapping("/kit/priority/{kitId}")
    public CompletableFuture<ResponseEntity<List<KitMedViewHeader>>> getKitPriorityContentsAsync(@PathVariable int kitId) {
        return dataService.getKitPriorityContentsAsync(kitId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/system/{kitId}/{systemId}/{classId}
    @GetMapping("/kit/system/{kitId}/{systemId}/{classId}")
    public CompletableFuture<ResponseEntity<List<KitMedViewHeader>>> getKitProductsBySystemAsync(
            @PathVariable int kitId,
            @PathVariable int systemId,
            @PathVariable int classId) {
        return dataService.getKitProductsBySystemAsync(kitId, systemId, classId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/pack/{packId}
    @GetMapping("/kit/pack/{packId}")
    public CompletableFuture<ResponseEntity<List<KitContentsModel>>> getKitPackProductsAsync(@PathVariable int packId) {
        return dataService.getKitPackProductsAsync(packId)
                .thenApply(ResponseEntity::ok);
    }

    // GET: kit/details/smart-sheet/{id}
    //TODO - Ashveemy - To check this impl is for SmartSheet only
//    @GetMapping("/kit/details/smart-sheet/{id}")
//    public CompletableFuture<ResponseEntity<List<KitMedSmartSheetView>>> getSmartSheetKitDetailsAsync(@PathVariable int id) {
//        return dataService.getSmartSheetKitDetailsAsync(id)
//                .thenApply(ResponseEntity::ok);
//    }

}

