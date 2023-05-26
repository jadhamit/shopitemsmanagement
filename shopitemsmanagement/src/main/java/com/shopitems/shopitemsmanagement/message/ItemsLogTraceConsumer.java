package com.shopitems.shopitemsmanagement.message;

import com.shopitems.shopitemsmanagement.AppsConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class ItemsLogTraceConsumer {
    @KafkaListener(topics = AppsConstants.ITEMS_TOPIC_NAME,
            groupId = AppsConstants.GROUP_ID)
    public void consume(String message){
        log.info(String.format("Message received -> %s", message));
    }
}
