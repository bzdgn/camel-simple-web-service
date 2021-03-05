package com.bzdgn.camel.simplewebservice;

public class Constants {
    
    private static final String DIRECT                  = "direct:";
    
    public static final String PERSON_ROUTE_ID          = "person-route";
    public static final String PERSON_ROUTE             = DIRECT + PERSON_ROUTE_ID;
    
    // env
    public static final String ENDPOINT_HEALTH          = "ENDPOINT_HEALTH";
    public static final String ENDPOINT_HEALTH_DEFAULT  = "http://0.0.0.0:8081";
    
    // properties
    public static final String PERSON_ID_PROPERTY       = "person-id";
    
}
