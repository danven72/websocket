package org.springframework.websocket.listeners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.websocket.dto.HelloMessage;
import org.springframework.websocket.service.WebSocketPublisherService;
import org.springframework.websocket.streams.WebsocketStream;


@Component
public class WebsocketListener {
	
	@Autowired
	private WebSocketPublisherService wsPublisher;
	
	@StreamListener(WebsocketStream.INPUT)
	public void onNewsPublished(@Payload HelloMessage helloMessage) {
		
		System.out.println("---> Message recieved from KAFKA: "+helloMessage.getName());
		wsPublisher.publishToWebSocket(helloMessage);
		System.out.println("---> Message publisjed to Websocket");
	}
}
