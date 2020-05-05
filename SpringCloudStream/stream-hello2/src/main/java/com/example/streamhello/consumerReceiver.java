package com.example.streamhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

/*
消费者
 */
@EnableBinding(consumerReceiver.consumer.class)
public class consumerReceiver {

    public interface consumer{
        String Name = "example-topic";

        @Input(Name)
        SubscribableChannel input();
    }

    private static Logger logger = LoggerFactory.getLogger(consumerReceiver.class);

    @StreamListener(consumer.Name)
    public void receiver(String receiver){
        logger.info("Received: "+receiver);
    }
}
