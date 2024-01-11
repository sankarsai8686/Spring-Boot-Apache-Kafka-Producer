package com.bss.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bss.bean.Message;

@Service
public class MessageService {
	
	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	
	
	public void sendMessages(List<Message> messages) throws InterruptedException {
		
//		System.out.println(messages);
		for(Message message : messages) {
			kafkaTemplate.send("topicDemo", message);
			Thread.sleep(1000);
		}
		
		
	}

}
