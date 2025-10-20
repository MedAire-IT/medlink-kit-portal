package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ClientNotificationDto {

    @JsonProperty("clientId")
    public int clientId;

    @JsonProperty("notificationId")
    public int notificationId;

    @JsonProperty("notification")
    public String notificationText;
}
