package org.springframework.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import org.springframework.websocket.dto.Greeting;
import org.springframework.websocket.dto.HelloMessage;

@Controller
public class GreetingController {
	
	@MessageMapping("/hello") //Se il messaggio è inviato a /hello il metodo si attiva "/app/hello" sarà l'endPoint per questo metodo (vedi WebSocketConfig)
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		
		//publish();
		Thread.sleep(3000); // simulated delay
		//the name from the input message is sanitized since in this case it will be echoed back and re-rendered in the browser DOM on the client side.
		return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
	}


}
