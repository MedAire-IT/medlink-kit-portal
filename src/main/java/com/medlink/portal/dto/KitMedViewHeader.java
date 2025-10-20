package com.medlink.portal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class KitMedViewHeader {
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

    @JsonProperty("alert")
    public String alert;

    @JsonProperty("productId")
    public int productId;

    @JsonProperty("productCount")
    public int productCount;

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

    @JsonProperty("productType")
    public String productType;

    @JsonProperty("formOrType")
    public String formOrType;

    @JsonProperty("unitOfMeasure")
    public String unitOfMeasure;

    @JsonProperty("unitQuantity")
    public String unitQuantity;

    @JsonProperty("therapeuticSystemId")
    public int therapeuticSystemId;

    @JsonProperty("therapeuticSystem")
    public String therapeuticSystem;

    @JsonProperty("therapeuticClassId")
    public int therapeuticClassId;

    @JsonProperty("therapeuticCategory")
    public String therapeuticCategory;

    @JsonProperty("tags")
    public String tags;

    public KitMedViewHeader(int kitId, String packId, String packDescription, int subPackId, String subPackDescription,
                            int productId, String genericName, String concentration, String brandName,
                            String productTypeDescription, String formOrType, String unitDose, String unitVolume,
                            String unitQuantity, int therapeuticSystemId, int therapeuticClassId, String therapeuticSystem,
                            String therapeuticCategory, String tags) {
        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.subPackId = subPackId;
        this.subPackName = subPackDescription;
        this.productId = productId;
        this.genericName = genericName;
        this.concentration = concentration;
        this.brandName = brandName;
        this.productType = productTypeDescription;
        this.formOrType = formOrType;
        this.unitDose = unitDose;
        this.unitVolume = unitVolume;
        this.unitQuantity = unitQuantity;
        this.therapeuticSystemId = therapeuticSystemId;
        this.therapeuticClassId = therapeuticClassId;
        this.therapeuticSystem = therapeuticSystem;
        this.therapeuticCategory = therapeuticCategory;
        this.tags = tags;


    }

    public KitMedViewHeader(int kitId, int productId, String genericName,
                            String concentration, String brandName, String formOrType, String unitDose, String unitVolume,
                            int therapeuticSystemId, int therapeuticClassId, String therapeuticSystem, String therapeuticCategory, String tags) {

        this.kitId = kitId;
        this.productId = productId;
        this.genericName = genericName;
        this.concentration = concentration;
        this.brandName = brandName;
        this.formOrType = formOrType;
        this.unitDose = unitDose;
        this.unitVolume = unitVolume;
//        this.unitQuantity = unitQuantity;
        this.therapeuticSystemId = therapeuticSystemId;
        this.therapeuticClassId = therapeuticClassId;
        this.therapeuticSystem = therapeuticSystem;
        this.therapeuticCategory = therapeuticCategory;
        this.tags = tags;
    }
}
