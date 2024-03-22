package com.guilherme.strconsumer.listeners;

import com.guilherme.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

//   @KafkaListener(groupId = "group-1",
//            topicPartitions = {
//                    @TopicPartition(topic = "str-topic", partitions = {"0"})
//           }, containerFactory = "strContainerFactory")
//jeito arcaico de definir o topic/containerFactory/groupId

    @StrConsumerCustomListener(groupId = "group-1")
    @SneakyThrows
    public void create(String message) {
        log.info("CREATE ::: Receive message {}", message);
        throw new IllegalAccessException("EXEPTION...");
    }

    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", topics =  "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {
        log.info("HISTORY ::: Receive message {}", message);
    }

}