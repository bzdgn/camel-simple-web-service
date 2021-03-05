package com.bzdgn.camel.simplewebservice.route;

import static com.bzdgn.camel.simplewebservice.Constants.PERSON_ROUTE;
import org.apache.camel.builder.RouteBuilder;

public class RestEndpointRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        rest("/person/{personId}")
            .get()
            .produces("application/json")
            .to(PERSON_ROUTE);
    
        restConfiguration()
            .component("jetty")
            .scheme("http")
            .host("localhost")
            .port("8080");     
    }

}
