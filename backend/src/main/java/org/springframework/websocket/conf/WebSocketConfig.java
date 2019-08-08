package org.springframework.websocket.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker //enables WebSocket message handling, backed by a message broker.
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.enableSimpleBroker("/topic"); //trasporta i messaggi verso il client sulla destinazione /topic
		config.setApplicationDestinationPrefixes("/app"); //imposta il prefisso /app per tutti i messaggi legati ad un @MessageMapping (vedi controller)
	}

	/*
	 * method registers the "/gs-guide-websocket" endpoint, enabling SockJS fallback options so that alternate 
	 * transports may be used if WebSocket is not available.
	 * The SockJS client will attempt to connect to "/gs-guide-websocket" and use the best transport available (websocket, xhr-streaming, xhr-polling, etc).
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/gs-guide-websocket")
		        .setAllowedOrigins("http://localhost:4200")
		        .withSockJS();
	}
}
