package com.egoo.camel.controller;

import com.egoo.camel.route.MqConstant;
import com.egoo.camel.vo.EventVO;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mash
 * @date 2021/4/22
 */
@RestController
public class DemoMqController {
    @Produce(MqConstant.MESSAGE_SENDER_URI)
    private ProducerTemplate producerTemplate;

    @PostMapping("/emit")
    public String emmit(@RequestBody EventVO eventVO) {
//        producerTemplate.sendBody(producerTemplate.getDefaultEndpoint(), eventVO);
        producerTemplate.sendBodyAndHeader(producerTemplate.getDefaultEndpoint(), eventVO, "engine", eventVO.getEngine());
        return "message emitted to " + eventVO.getEngine();
    }
}
