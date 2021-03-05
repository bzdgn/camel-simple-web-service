package com.bzdgn.camel.simplewebservice.route;

import static com.bzdgn.camel.simplewebservice.Constants.PERSON_ROUTE;
import static com.bzdgn.camel.simplewebservice.Constants.PERSON_ROUTE_ID;
import static com.bzdgn.camel.simplewebservice.Constants.PERSON_ID_PROPERTY;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.bzdgn.camel.simplewebservice.process.PersonProcessor;

public class PersonRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from(PERSON_ROUTE)
            .routeId(PERSON_ROUTE_ID)
            .log("Received request for id: ${in.header.personId}")
            .setProperty(PERSON_ID_PROPERTY, simple("${in.header.personId}"))
            .removeHeader(PERSON_ID_PROPERTY)
            .process(new PersonProcessor())
            .marshal().json(JsonLibrary.Gson)
            .convertBodyTo(String.class)
            .log("Body produced: ${body}")
            ;
    }

}
