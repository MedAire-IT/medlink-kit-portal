package com.medlink.portal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ApiVersionDto extends BaseDto {

    @JsonProperty("apiVersion")
    public String apiVersion = "0.0.0";

    @JsonProperty("apiDataModuleVersion")
    public String apiDataModuleVersion = "0.0.0";
}
