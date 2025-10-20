package com.medlink.portal.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class BaseDto {

    public UUID modelId = UUID.randomUUID();
}
