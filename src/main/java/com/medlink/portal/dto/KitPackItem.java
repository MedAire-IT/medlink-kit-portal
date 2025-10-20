package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class KitPackItem {

    @JsonProperty("pack")
    public String packDescription;

    @JsonProperty("subPack")
    public String subPackDescription;

    @JsonProperty("itemNumber")
    public String productSerialNumber;

    @JsonProperty("expiration")
    public LocalDateTime expirationDate;

    @JsonProperty("qtyOnHand")
    public double quantityOnHand;
}

