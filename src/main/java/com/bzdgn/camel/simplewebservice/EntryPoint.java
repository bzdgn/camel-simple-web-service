package com.bzdgn.camel.simplewebservice;

import static com.bzdgn.camel.simplewebservice.Constants.ENDPOINT_HEALTH;
import static com.bzdgn.camel.simplewebservice.Constants.ENDPOINT_HEALTH_DEFAULT;
import static com.bzdgn.camel.simplewebservice.util.GenUtil.getEnv;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.apache.camel.component.properties.PropertiesComponent;
import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bzdgn.camel.simplewebservice.route.HealthRoute;
import com.bzdgn.camel.simplewebservice.route.PersonRoute;
import com.bzdgn.camel.simplewebservice.route.RestEndpointRoute;

public class EntryPoint {
    
    public static final Logger LOGGER = LoggerFactory.getLogger(EntryPoint.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("camel-simple-web-service v0.1 started");
        
        Main main = new Main();
        
        Properties props = new Properties();
        main.bind("properties", createProperties(props));
        
        main.addRouteBuilder(new HealthRoute());
        main.addRouteBuilder(new PersonRoute());
        main.addRouteBuilder(new RestEndpointRoute());
        
        logProperties(props);
        
        main.run();
    }
    
    public static PropertiesComponent createProperties(Properties source) {
        PropertiesComponent pc = new PropertiesComponent();
        
        source.put(ENDPOINT_HEALTH, getEnv(ENDPOINT_HEALTH, ENDPOINT_HEALTH_DEFAULT));
        
        pc.setInitialProperties(source);
        
        return pc;
    }
    
    private static void logProperties(Properties source) {
        Set<Object> keys = new HashSet<>(source.keySet());
        
        LOGGER.info("Printing Environmental Variables");
        LOGGER.info("********************************");
        for (Object key: keys) {
            LOGGER.info("{}={}", key, source.get(key));
        }
        LOGGER.info("********************************");
    }

}
