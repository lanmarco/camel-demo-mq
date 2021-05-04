package com.egoo.camel.service;

import com.egoo.camel.vo.EventVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author mash
 * @date 2021/4/22
 */
@Service
@Slf4j
public class EventService {
    public void consumeEventMsg(EventVO vo) {
        log.info("received event: {}", vo.toString());
    }
}
