package com.bss.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bss.bean.Message;
import com.bss.service.MessageService;

import jakarta.annotation.PostConstruct;

@RestController
public class MessageRestController {
	
	@Autowired
	private MessageService  messageService;
	
	
	@GetMapping("/")
	public Message getSampleMessage() {
		return new Message(1, "Test Msg", "11-01-2024", "High", true);
	}
	
	
	@PostMapping("/send-message")
	public List<Message> sendMessages(@RequestBody List<Message> messages) throws InterruptedException{
//		System.out.println(messages);
		messageService.sendMessages(messages);
		return messages;
	}

}
