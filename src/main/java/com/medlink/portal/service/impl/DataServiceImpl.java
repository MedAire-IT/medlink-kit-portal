package com.medlink.portal.service.impl;

import com.medlink.portal.domain.*;
import com.medlink.portal.dto.*;
import com.medlink.portal.mapper.ClientNotificationMapper;
import com.medlink.portal.repository.*;
import com.medlink.portal.service.DataService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackOn = Throwable.class)
@RequiredArgsConstructor
@Slf4j
public class DataServiceImpl implements DataService {

    private final VwClientRepository vwClientRepository;
    private final ClientRepository clientRepository;
    private final ClientKitRepository clientKitRepository;
    private final ClientNotificationRepository clientNotificationRepository;
    private final TherapeuticSystemRepository therapeuticSystemRepository;
    private final ProductClassRepository productClassRepository;
    private final ProductSubClassRepository productSubClassRepository;
    private final TherapeuticCategoryRepository therapeuticCategoryRepository;
    private final KitPackRepository kitPackRepository;
    private final SmartSheetKitBuildRepository SmartSheetKitBuildRepository;
    private final VwYachtingKitBuildRepository vwYachtingKitBuildRepository;
    private final VwKitBuildHeadersRepository vwKitBuildHeadersRepository;
    private final KitPackProductRepository kitPackProductRepository;
    private final KitBuildWithClassificationRepository kitBuildWithClassificationRepository;
    private final VwKitBuildRepository vwKitBuildRepository;
    private final VwKitBuildPackRepository vwKitBuildPackRepository;

    //TODO - Ashveemy - to remove impl of Aviation
    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getClientsListAsync(String clientType) {
        String industry = switch (clientType) {
            case "1" -> "Aviation";
            case "2" -> "Luxury Yachting";
            default -> "all";
        };

        return CompletableFuture.supplyAsync(() -> {
            List<VwClients> clients;

            if ("all".equals(industry)) {
                clients = vwClientRepository.findAll();
            } else {
                clients = vwClientRepository.findByClientIndustry(industry);
            }

            return clients.stream()
                    .map(c -> new KeyValuePairModel(String.valueOf(c.getClientId()), c.getClientName()))
                    .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                    .collect(Collectors.toList());
        });
    }

    @Override
    public Client GetClientDetails(int clientId) {
        Optional<Client> client = clientRepository.findById(clientId);
        return client.orElse(null);
    }

    @Override
    public ClientKit GetSmartSheetClientKit(int clientId) {

        Optional<ClientKit> clientKit = clientKitRepository.findByClientId(clientId);
        return clientKit.orElse(null);

    }

    @Override
    @Async
    public CompletableFuture<List<ClientNotificationDto>> getClientNotificationsAsync(int clientId) {

        List<ClientNotificationDto> clientNotifications = new ArrayList<>();
        Optional<ClientNotification> notifications = clientNotificationRepository
                .findClientNotificationsByClientId(clientId)
                .filter(notification -> Objects.isNull(notification.getExpirationDate()) || !notification.getExpirationDate().isBefore(LocalDateTime.now()));

        notifications.ifPresent(notification -> {
            clientNotifications.add(ClientNotificationMapper.INSTANCE.toDto(notification));
        });
        return CompletableFuture.completedFuture(clientNotifications);

    }

    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getSystemsListAsync() {
        return CompletableFuture.supplyAsync(() -> therapeuticSystemRepository.findAll().stream()
                .map(c -> new KeyValuePairModel(String.valueOf(c.getSystemId()), c.getSystemName()))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));
    }

    // 0 references
    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticClassesListAsync() {
//        @Query("SELECT new com.medlink.portal.dto.KeyValuePairModel(" +
//               "CAST(p.productClassId AS string), p.classDescription) " +
//               "FROM ProductClass p ORDER BY p.classDescription")
        return CompletableFuture.supplyAsync(() -> productClassRepository.findAll().stream()
                .map(c -> new KeyValuePairModel(String.valueOf(c.getProductClassId()), c.getClassDescription()))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));

    }

    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticSubClassesListAsync(int classId) {
        return CompletableFuture.supplyAsync(() -> productSubClassRepository.findAll().stream()
                .map(c -> new KeyValuePairModel(String.valueOf(c.getProductSubClassId()), c.getClassDescription()))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));
    }

    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getTherapeuticCategoriesAsync(int systemId) {
        return CompletableFuture.supplyAsync(() -> therapeuticCategoryRepository.findAll().stream()
                .filter(t -> t.getSystemId() == systemId && t.isVisibleCategory())
                .map(c -> new KeyValuePairModel(String.valueOf(c.getCategoryId()), c.getCategoryName()))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));
    }

    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getClientKitsListAsync(int clientId) {
        return CompletableFuture.supplyAsync(() -> clientKitRepository.findByClientId(clientId)
                .stream()
                .map(c -> new KeyValuePairModel(String.valueOf(c.getClientId()), Objects.nonNull(c.getKitSerialNumber()) ? c.getKitSerialNumber().concat(" - ").concat(c.getKitDescription())
                        : " - ".concat(c.getKitDescription())))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));
    }

    @Override
    @Async
    public CompletableFuture<List<KeyValuePairModel>> getKitPackListAsync(int kitId) {
        return CompletableFuture.supplyAsync(() -> kitPackRepository.findAll().stream()
                .map(c -> new KeyValuePairModel(String.valueOf(c.getKitPackId()), c.getPackDescription()))
                .sorted((a, b) -> a.getValue().compareToIgnoreCase(b.getValue()))
                .collect(Collectors.toList()));
    }

    // 0 references
    @Override
    @Async
    public CompletableFuture<List<KitMedViewEx>> getAllKitProductsAsync(int kitId) {

        return clientKitRepository.findAllByKitId(kitId)
                .thenApplyAsync(clientKit -> {
                    if (clientKit != null && clientKit.getKitSource().equalsIgnoreCase("SmartSheet")) {
                        return SmartSheetKitBuildRepository.findByKitId(kitId).stream()
                                .map(s -> new KitMedViewEx(
                                        s.getKitId(),
                                        s.getPackId(),
                                        s.getPackDescription(),
                                        s.getAlert(),
                                        s.getProductItemNumber(),
                                        s.getProductId(),
                                        s.getProductName(),
                                        s.getProductSerialNumber(),
                                        s.getGenericName(),
                                        s.getBrandName(),
                                        s.getSizeOrStrength(),
                                        s.getProductTypeId(),
                                        s.getProductTypeDescription(),
                                        s.getFormOrType(),
                                        s.getQuantityOnHand(),
                                        s.getUnitOfMeasure(),
                                        s.getTherapeuticSubClass(),
                                        s.getTherapeuticSubClassId() != null ? s.getTherapeuticSubClassId() : 0
                                ))
                                .toList();
                    } else {
                        return vwYachtingKitBuildRepository.findAllByKitId(kitId).stream()
                                .map(s -> new KitMedViewEx(
                                        s.getKitId(),
                                        s.getPackId(),
                                        s.getPackDescription(),
                                        s.getSubPackId(),
                                        s.getSubPackDescription(),
                                        s.getAlert(),
                                        s.getProductItemNumber(),
                                        s.getProductId(),
                                        s.getProductName(),
                                        s.getProductSerialNumber(),
                                        s.getGenericName(),
                                        s.getBrandName(),
                                        s.getUnitDose(),
                                        0,
                                        s.getProductTypeDescription(),
                                        s.getFormOrType(),
                                        s.getUnitVolume(),
                                        s.getUnitOfMeasure(),
                                        s.getTherapeuticSubClass(),
                                        0
                                ))
                                .toList();
                    }
                });
    }

    @Override
    @Async
    public CompletableFuture<List<KitMedViewHeader>> getKitContentsByKitAsync(int kitId) {

        List<VwKitBuildHeader> entities = vwKitBuildHeadersRepository.findByKitId(kitId);

        List<KitMedViewHeader> productsList = entities.stream().map(s -> new KitMedViewHeader(
                s.getKitId(),
                s.getProductId(),
                s.getGenericName(),
                s.getConcentration(),
                s.getBrandName(),
                s.getFormOrType(),
                s.getUnitDose(),
                s.getUnitVolume(),
                s.getTherapeuticSystemId() != null ? s.getTherapeuticSystemId() : 0,
                s.getTherapeuticClassId() != null ? s.getTherapeuticClassId() : 0,
                s.getTherapeuticSystem(),
                s.getTherapeuticCategory(),
                s.getTags()
        )).toList();

        return CompletableFuture.completedFuture(productsList);
    }


    @Override
    @Async
    public CompletableFuture<List<KitPackItem>> getKitPackItemsAsync(int kitId, int subPackId, int productId) {
        List<KitPackItem> items = vwKitBuildPackRepository.findKitPackItems(kitId, productId).stream()
                .map(kitPackItem -> new KitPackItem(kitPackItem.getPackDescription(),
                        kitPackItem.getSubPackDescription(),
                        kitPackItem.getProductSerialNumber(),
                        kitPackItem.getExpirationDate(),
                        kitPackItem.getQuantityOnHand()))
                .toList();

        return CompletableFuture.completedFuture(items);

    }

    @Override
    @Async
    public CompletableFuture<List<KitMedViewHeader>> getKitPriorityContentsAsync(int kitId) {
        List<KitMedViewHeader> productsList = vwKitBuildHeadersRepository.findKitPriorityContents(kitId);

        return CompletableFuture.completedFuture(productsList);

    }

    @Override
    @Async
    public CompletableFuture<List<KitMedViewHeader>> getKitProductsBySystemAsync(int kitId, int systemId, int classId) {
        List<KitMedViewHeader> productsList;
        if (classId > 0) {
            productsList = vwKitBuildHeadersRepository.findKitPriorityContentsAsync(kitId, systemId, classId);
        }
        else {
            productsList = vwKitBuildHeadersRepository.findKitPriorityContentsAsync(kitId, systemId);
        }
        return CompletableFuture.completedFuture(productsList);
    }


    @Override
    @Async
    public CompletableFuture<List<KitContentsModel>> getKitDiagnosticsAsync(int kitId) {
        List<KitContentsModel> productsList = vwKitBuildPackRepository.findByKitIdAndProductType(kitId);
        return CompletableFuture.completedFuture(productsList);
    }

    // 0 references
    @Override
    @Async
    public CompletableFuture<List<KitMedViewEx>> getKitProductsByClassAsync(int kitId, int classId) {
        List<KitBuildWithClassification> builds = kitBuildWithClassificationRepository
                .findByKitIdAndTherapeuticClassId(kitId, classId);

        return getListCompletableFuture(builds);
    }

    // 0 references
    @Override
    @Async
    public CompletableFuture<List<KitMedViewEx>> getKitProductsBySubClassAsync(int kitId, int classId, int subClassId) {

        List<KitBuildWithClassification> builds = kitBuildWithClassificationRepository
                .findByKitIdAndTherapeuticClassIdAndTherapeuticSubClassId(kitId, classId, subClassId);

        return getListCompletableFuture(builds);

    }

    private CompletableFuture<List<KitMedViewEx>> getListCompletableFuture(List<KitBuildWithClassification> builds) {
        List<KitMedViewEx> productsList = builds.stream().map(s -> new KitMedViewEx(
                s.getKitId(),
                String.valueOf(s.getPackId()),
                s.getPackDescription(),
                s.getSubPackId(),
                s.getSubPackDescription(),
                s.getProductItemNumber(),
                s.getProductId(),
                s.getProductName(),
                s.getProductSerialNumber(),
                s.getGenericName(),
                s.getTherapeuticClassId() != null ? s.getTherapeuticClassId() : 0,
                s.getTherapeuticClass(),
                s.getTherapeuticSubClass(),
                s.getTherapeuticSubClassId() != null ? s.getTherapeuticSubClassId() : 0,
                s.getBrandName(),
                s.getSizeOrStrength(),
                s.getProductTypeId(),
                s.getTypeDescription(),
                s.getFormOrType(),
                s.getQuantityOnHand(),
                s.getUnitOfMeasure()
        )).toList();

        return CompletableFuture.completedFuture(productsList);
    }

    @Override
    @Async
    public CompletableFuture<List<KitContentsModel>> getKitPackProductsAsync(int packId) {
        List<KitContentsModel> productsList = vwKitBuildPackRepository.findByPackId(String.valueOf(packId));
        return CompletableFuture.completedFuture(productsList);

    }
}
