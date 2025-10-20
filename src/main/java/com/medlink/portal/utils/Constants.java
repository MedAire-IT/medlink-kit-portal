package com.medlink.portal.utils;

public class Constants {

    //  The API endpoint for the app.
    //TODO - Ashveemy - Introduce Properties.Settings.Default.APIUrl
    public static String API_BASE_URL = "";

    /// <summary>
    /// Clients API
    /// </summary>
    public static String CLIENTS_API = API_BASE_URL + "clients";
    public static String CLIENTS_KIT_API  = CLIENTS_API + "/client/kits/";
    public static String CLIENTS_TYPE_API = CLIENTS_API + "/types";
}
