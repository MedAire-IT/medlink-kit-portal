package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientDetailsDto {

    @JsonProperty("clientId")
    public int clientId;

    @JsonProperty("clientName")
    public String clientName;

    @JsonProperty("clientType")
    public String clientType;

    @JsonProperty("clientTypeCode")
    public String clientTypeCode;

    @JsonProperty("clientCode")
    public String clientCode;

    @JsonProperty("callSign")
    public String callSign;

    @JsonProperty("activeClient")
    public boolean activeClient;

    @JsonProperty("numberOfKits")
    public int numberOfKits;

    @JsonProperty("clientLogoUrl")
    public String clientLogo;
}
