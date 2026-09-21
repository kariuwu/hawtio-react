package io.hawt.tests.springboot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SampleRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:hello?period=5000")
            .routeId("hello-route")
            .setBody(constant("Hello !"))
            .log("Timer fired: ${body}");

        from("direct:greet")
            .routeId("greet-route")
            .log("Greeting request: ${body}")
            .transform(simple("Hello, ${body}!"));
    }
}
