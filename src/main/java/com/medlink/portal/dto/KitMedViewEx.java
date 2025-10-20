package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KitMedViewEx extends KitMedView {

    @JsonProperty("alert")
    public String alert;

    @JsonProperty("qtyAlt")
    public String itemQtyAlt;

    @JsonProperty("unitVolume")
    public String unitVolume;

    @JsonProperty("unitQuantity")
    public String unitQuantity;

    @JsonProperty("therapeuticClassId")
    public int therapeuticClassId;

    @JsonProperty("therapeuticSubClassId")
    public int therapeuticSubClassId;

    @JsonProperty("therapeuticClass")
    public String therapeuticClass;

    @JsonProperty("therapeuticSubClass")
    public String therapeuticSubClass;

    public KitMedViewEx(int kitId, String packId, String packDescription, String alert, String productItemNumber,
                        int productId, String productName, String productSerialNumber, String genericName,
                        String brandName, String sizeOrStrength, int productTypeId, String productTypeDescription,
                        String formOrType, String quantityOnHand, String unitOfMeasure, String therapeuticSubClass, int therapeuticSubClassId) {

        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.alert = alert;
        this.productNumber = productItemNumber;
        this.productId = productId;
        this.productDescription = productName;
        this.productSerialNumber = productSerialNumber;
        this.genericName = genericName;
        this.brandName = brandName;
        this.sizeOrStrength = sizeOrStrength;
        this.productTypeId = productTypeId;
        this.productType = productTypeDescription;
        this.formOrType = formOrType;
        this.itemQtyAlt = quantityOnHand;
        this.unitVolume = unitOfMeasure;
        this.therapeuticSubClass = therapeuticSubClass;
        this.therapeuticSubClassId = therapeuticSubClassId;
    }

    public KitMedViewEx(int kitId, String packId, String packDescription, int subPackId, String subPackDescription,
                        String alert, String productItemNumber, int productId, String productName, String productSerialNumber,
                        String genericName, String brandName, String unitDose, int productTypeId, String productTypeDescription,
                        String formOrType, String unitVolume, String unitOfMeasure, String therapeuticSubClass, int therapeuticSubClassId) {

        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.subPackId = subPackId;
        this.subPackName = subPackDescription;
        this.alert = alert;
        this.productNumber = productItemNumber;
        this.productId = productId;
        this.productDescription = productName;
        this.productSerialNumber = productSerialNumber;
        this.genericName = genericName;
        this.brandName = brandName;
        this.sizeOrStrength = unitDose;
        this.productTypeId = productTypeId;
        this.productType = productTypeDescription;
        this.formOrType = formOrType;
        this.unitVolume = unitVolume;
        this.itemUnitOfMeasure = unitOfMeasure;
        this.therapeuticSubClass = therapeuticSubClass;
        this.therapeuticSubClassId = therapeuticSubClassId;
    }

    public KitMedViewEx(int kitId, String packId, String packDescription, int subPackId, String subPackDescription,
                        String productItemNumber, int productId, String productName, String productSerialNumber,
                        String genericName, int therapeuticClassId, String therapeuticClass, String therapeuticSubClass, int therapeuticSubClassId,
                        String brandName, String sizeOrStrength, int productTypeId, String typeDescription,
                        String formOrType, double quantityOnHand, String unitOfMeasure) {
        this.kitId = kitId;
        this.packId = packId;
        this.packName = packDescription;
        this.subPackId = subPackId;
        this.subPackName = subPackDescription;
        this.productNumber = productItemNumber;
        this.productId = productId;
        this.productDescription = productName;
        this.productSerialNumber = productSerialNumber;
        this.genericName = genericName;
        this.therapeuticClassId = therapeuticClassId;
        this.therapeuticClass = therapeuticClass;
        this.therapeuticSubClass = therapeuticSubClass;
        this.therapeuticSubClassId = therapeuticSubClassId;
        this.brandName = brandName;
        this.sizeOrStrength = sizeOrStrength;
        this.productTypeId = productTypeId;
        this.productType = typeDescription;
        this.formOrType = formOrType;
        this.itemQty = quantityOnHand;
        this.itemUnitOfMeasure = unitOfMeasure;

    }
}
