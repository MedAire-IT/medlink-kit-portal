package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class KitContentsModel {

    // Pack/Subpack Details
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

    // Item Details
    @JsonProperty("itemNumber")
    public String itemNumber;

    @JsonProperty("productId")
    public int productId;

    @JsonProperty("productName")
    public String productName;

    @JsonProperty("genericName")
    public String genericName;

    @JsonProperty("brandName")
    public String brandName;

    @JsonProperty("concentration")
    public String concentration;

    @JsonProperty("unitDose")
    public String unitDose;

    @JsonProperty("unitVolume")
    public String unitVolume;

    @JsonProperty("unitQuantity")
    public String unitQuantity;

    @JsonProperty("formOrType")
    public String formOrType;

    @JsonProperty("productType")
    public String productType;

    @JsonProperty("expirationDate")
    public LocalDateTime productExpirationDate;

    // Classification
    @JsonProperty("therapeuticSystemId")
    public int therapeuticSystemId;

    @JsonProperty("therapeuticClassId")
    public int therapeuticClassId;

    @JsonProperty("therapeuticSystem")
    public String therapeuticSystem;

    @JsonProperty("therapeuticCategory")
    public String therapeuticCategory;

    public KitContentsModel(int kitId, String packId, String packDescription, int subPackId, String subPackDescription,
                            int productId, String productName, String genericName,
                            String concentration, String itemNumber, LocalDateTime productExpirationDate,
                            String brandName, String productType, String formOrType,
                            String unitDose, String unitVolume,
                            int therapeuticSystemId, int therapeuticClassId,
                            String therapeuticSystem, String therapeuticCategory) {
        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.subPackId = subPackId;
        this.subPackName = subPackDescription;
        this.productId = productId;
        this.productName = productName;
        this.genericName = genericName;
        this.concentration = concentration;
        this.itemNumber = itemNumber;
        this.productExpirationDate = productExpirationDate;
        this.brandName = brandName;
        this.productType = productType;
        this.formOrType = formOrType;
        this.unitDose = unitDose;
        this.unitVolume = unitVolume;
        this.therapeuticSystemId = therapeuticSystemId;
        this.therapeuticClassId = therapeuticClassId;
        this.therapeuticSystem = therapeuticSystem;
        this.therapeuticCategory = therapeuticCategory;
    }


    public KitContentsModel(int kitId, String packId, String packDescription, int subPackId, String subPackDescription,
                            int productId, String productName, String genericName, LocalDateTime productExpirationDate,
                            String concentration, String itemNumber,
                            String brandName, String productType, String formOrType,
                            String unitDose, String unitVolume,
                            String unitQuantity) {
        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.subPackId = subPackId;
        this.subPackName = subPackDescription;
        this.productId = productId;
        this.productName = productName;
        this.genericName = genericName;
        this.productExpirationDate = productExpirationDate;
        this.concentration = concentration;
        this.itemNumber = itemNumber;
        this.brandName = brandName;
        this.productType = productType;
        this.formOrType = formOrType;
        this.unitDose = unitDose;
        this.unitVolume = unitVolume;
        this.unitQuantity = unitQuantity;
    }

}
