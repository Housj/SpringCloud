package com.example.streamhello;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestParam;

@RunWith(SpringRunner.class)
public class TopicTest {

    @Autowired
    private TestListener.TestTopic testTopic;

    /**
     * 消息生产接口
     *
     * @param message
     * @return
     */
    @Test
    public String messageWithMQ(@RequestParam String message) {
        testTopic.output().send(MessageBuilder.withPayload(message).setHeader("version", "1.0").build());
        testTopic.output().send(MessageBuilder.withPayload(message).setHeader("version", "2.0").build());
        return "ok";
    }

}