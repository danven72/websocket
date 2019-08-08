package org.springframework.websocket.streams;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface WebsocketStream {
	final String INPUT = "websocket-in";
	final String OUTPUT = "websocket-out";
    
    @Input(INPUT)
    public SubscribableChannel subscribe();
    
    @Output(OUTPUT)
    public MessageChannel notifyTo();
}
