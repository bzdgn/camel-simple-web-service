package com.bzdgn.camel.simplewebservice.process;

import static com.bzdgn.camel.simplewebservice.Constants.PERSON_ID_PROPERTY;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.bzdgn.camel.simplewebservice.dto.Person;

public class PersonProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        String personId = exchange.getProperty(PERSON_ID_PROPERTY, String.class);
        
        Person person = new Person(personId, "John Doe");
        
        exchange.getIn().setBody(person, String.class);
    }

}
