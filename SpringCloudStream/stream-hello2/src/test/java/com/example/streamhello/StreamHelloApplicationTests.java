package com.example.streamhello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@EnableBinding(value={StreamHelloApplicationTests.SinkSender.class})
public class StreamHelloApplicationTests {

	@Autowired
	private SinkSender sinkSender;


	@Test
	public void contextLoads() {
		sinkSender.output().send(MessageBuilder.withPayload("produce a message ：123123").build());
	}

	public interface SinkSender {

		String INPUT = "input";

		@Output(SinkSender.INPUT)
		MessageChannel output();

	}

}

