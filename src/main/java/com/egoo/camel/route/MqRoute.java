package com.egoo.camel.route;

import com.egoo.camel.vo.EventVO;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

/**
 * @author mash
 * @date 2021/4/22
 */
@Component
public class MqRoute extends RouteBuilder {
    private final String aggregateRoute = "direct:aggregateRoute";

    @Override
    public void configure() {
        // @formatter:off
        // 生产者
        JacksonDataFormat jsonDataFormat = new JacksonDataFormat(EventVO.class);
        from(MqConstant.MESSAGE_SENDER_URI)
            .id("producer_event")
            .marshal(jsonDataFormat)
            .log("sending ${body}")
            .choice()
                .when(simple("${header.engine} == 'rabbit'"))
                    .to("{{egoo.producer.uri.event.rabbit}}")
                .otherwise()
                    .to("{{egoo.producer.uri.event.rocket}}")
            .end();

        // 消费者
        from("{{egoo.consumer.uri.event.rabbit}}")
            .to(aggregateRoute);
        from("{{egoo.consumer.uri.event.rocket}}")
            .to(aggregateRoute);
        from(aggregateRoute)
            .id("consumer_event")
            .log("receiving: ${body}")
            .unmarshal(jsonDataFormat)
            .to("bean:eventService?method=consumeEventMsg");
        //@formatter:on
    }
}
