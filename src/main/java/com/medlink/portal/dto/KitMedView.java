package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KitMedView {
    @JsonProperty("kitId")
    public int kitId;

    @JsonProperty("packId")
    public String packId;

    @JsonProperty("packName")
    public String packName;

    @JsonProperty("subPackId")
    public int subPackId;

    @JsonProperty("subPackName")
    public String subPackName;

    @JsonProperty("productNumber")
    public String productNumber;

    @JsonProperty("productId")
    public int productId;

    @JsonProperty("serialNumber")
    public String productSerialNumber;

    @JsonProperty("productName")
    public String productDescription;

    @JsonProperty("genericName")
    public String genericName;

    @JsonProperty("brandName")
    public String brandName;

    @JsonProperty("sizeOrStrength")
    public String sizeOrStrength;

    @JsonProperty("formOrType")
    public String formOrType;

    @JsonProperty("qty")
    public double itemQty;

    @JsonProperty("prodTypeId")
    public int productTypeId;

    @JsonProperty("productType")
    public String productType;

    @JsonProperty("unitOfMeasure")
    public String itemUnitOfMeasure;
}
