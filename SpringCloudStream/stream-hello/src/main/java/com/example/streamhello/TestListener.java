package com.example.streamhello;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class TestListener {

    @StreamListener(value = TestTopic.Input, condition = "headers['version']=='1.0'")
    public void receiveV1(String payload, @Header("version") String version) {
        System.out.println("Received v1 : " + payload + ", " + version);
    }

    @StreamListener(value = TestTopic.Input, condition = "headers['version']=='2.0'")
    public void receiveV2(String payload, @Header("version") String version) {
        System.out.println("Received v2 : " + payload + ", " + version);
    }

    interface TestTopic {
        String Output = "example-topic-output";
        String Input = "example-topic-input";

        @org.springframework.cloud.stream.annotation.Output(Output)
        MessageChannel output();

        @org.springframework.cloud.stream.annotation.Input(Input)
        MessageChannel input();
    }
}

