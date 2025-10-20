package com.medlink.portal.utils;

import com.medlink.portal.model.UserModel;

public class Helpers {

    public static UserModel getUserModel(String networkId) {
        UserModel retValue = new UserModel();
        retValue.setNetworkId(networkId != null ? networkId : "unknown");

        String userFullName = retValue.getNetworkId()
                .replace(".", " ")
                .replace("INTLSOS\\", "");

        retValue.setUserFullName(userFullName);

        return retValue;
    }
}
