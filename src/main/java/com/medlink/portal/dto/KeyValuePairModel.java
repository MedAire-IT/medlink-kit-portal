package com.medlink.portal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyValuePairModel {

    @JsonProperty("key")
    public String key;

    @JsonProperty("label")
    public String value;
}
