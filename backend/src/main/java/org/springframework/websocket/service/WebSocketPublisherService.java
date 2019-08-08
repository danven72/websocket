package org.springframework.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.websocket.dto.Greeting;
import org.springframework.websocket.dto.HelloMessage;

@Service
public class WebSocketPublisherService {

	@Autowired
	
	private SimpMessagingTemplate template;

	public void publishToWebSocket(HelloMessage messageFromKafka) {
		template.convertAndSend("/topic/greetings", new Greeting("Message From KAFKA: "+messageFromKafka.getName()));
	}
}
