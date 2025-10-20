package com.medlink.portal.service;


import com.medlink.portal.domain.Client;
import com.medlink.portal.domain.ClientKit;
import com.medlink.portal.dto.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface DataService {

    public CompletableFuture<List<KeyValuePairModel>> getClientsListAsync(String clientType);

    public Client GetClientDetails(int clientId);

    public ClientKit GetSmartSheetClientKit(int clientId);

    public CompletableFuture<List<ClientNotificationDto>> getClientNotificationsAsync(int clientId);

    public CompletableFuture<List<KeyValuePairModel>> getSystemsListAsync();

    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticClassesListAsync();

    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticSubClassesListAsync(int classId);

    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticCategoriesAsync(int systemId);

    public CompletableFuture<List<KeyValuePairModel>> getClientKitsListAsync(int clientId);

    public CompletableFuture<List<KeyValuePairModel>> getKitPackListAsync(int kitId);

    public CompletableFuture<List<KitMedViewEx>> getAllKitProductsAsync(int kitId);

    public CompletableFuture<List<KitMedViewHeader>> getKitContentsByKitAsync(int kitId);

    public CompletableFuture<List<KitPackItem>> getKitPackItemsAsync(int kitId, int subPackId, int productId);

    public CompletableFuture<List<KitMedViewHeader>> getKitPriorityContentsAsync(int kitId);

    public CompletableFuture<List<KitMedViewHeader>> getKitProductsBySystemAsync(int kitId, int systemId, int classId);

    public CompletableFuture<List<KitContentsModel>> getKitDiagnosticsAsync(int kitId);

    public CompletableFuture<List<KitMedViewEx>> getKitProductsByClassAsync(int kitId, int classId);

    public CompletableFuture<List<KitMedViewEx>> getKitProductsBySubClassAsync(int kitId, int classId, int subClassId);

    public CompletableFuture<List<KitContentsModel>> getKitPackProductsAsync(int packId);

//    public CompletableFuture<List<KitMedSmartSheetView>> getSmartSheetKitDetailsAsync(int id);

}
