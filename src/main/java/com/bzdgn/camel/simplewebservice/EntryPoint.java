package com.bzdgn.camel.simplewebservice;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bzdgn.camel.simplewebservice.route.PersonRoute;
import com.bzdgn.camel.simplewebservice.route.RestEndpointRoute;

public class EntryPoint {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("camel-simple-web-service v0.1 started");
        
        Main main = new Main();
        
        main.addRouteBuilder(new PersonRoute());
        main.addRouteBuilder(new RestEndpointRoute());
        
        main.run();
    }

}
