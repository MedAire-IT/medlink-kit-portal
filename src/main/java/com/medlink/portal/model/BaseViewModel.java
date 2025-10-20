package com.medlink.portal.model;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseViewModel {

    @Getter
    @Setter
    private String pageBase;

    public String getBaseUrl(HttpServletRequest request) {
        String appUrl = request.getRequestURL().toString();
        String authority = request.getServerName();

        String baseUrl = authority.contains("localhost") ? "" : "/";

        return appUrl + baseUrl;
    }

    public String getParams(HttpServletRequest request) {
        return request.getServletPath(); // Similar to CurrentExecutionFilePath
    }
}

