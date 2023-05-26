package com.shopitems.shopitemsmanagement.message;

import com.shopitems.shopitemsmanagement.AppsConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class ItemsLogTraceProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info(String.format("Message sent -> %s", message));
        kafkaTemplate.send(AppsConstants.ITEMS_TOPIC_NAME, message);
    }
}
