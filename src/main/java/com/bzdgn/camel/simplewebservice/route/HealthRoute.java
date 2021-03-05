package com.bzdgn.camel.simplewebservice.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class HealthRoute extends RouteBuilder {
    
    @Override
    public void configure() {

        // Route to support readiness and live probes from Openshift
        from("jetty:{{ENDPOINT_HEALTH}}?matchOnUriPrefix=true&httpMethodRestrict=GET")
                .routeId("health-route")
                .startupOrder(1)
                .log(LoggingLevel.TRACE, "Health requested") // not very interesting but fills the entire log file now, so set to TRACE level
                .removeHeaders("*");
    }
    
}
