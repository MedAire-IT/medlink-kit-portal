package com.medlink.portal.config;

import lombok.Getter;

@Getter
public final class Config {

    @Getter
    private static final String apiToken = System.getenv("API_TOKEN");

}
