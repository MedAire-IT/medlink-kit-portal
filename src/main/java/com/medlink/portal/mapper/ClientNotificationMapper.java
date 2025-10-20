package com.medlink.portal.mapper;

import com.medlink.portal.domain.ClientNotification;
import com.medlink.portal.dto.ClientNotificationDto;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


public interface ClientNotificationMapper {


    ClientNotificationMapper INSTANCE = Mappers.getMapper(ClientNotificationMapper.class);

    @Mapping(source = "notification", target = "notificationText")
    ClientNotificationDto toDto(ClientNotification notification);

}
