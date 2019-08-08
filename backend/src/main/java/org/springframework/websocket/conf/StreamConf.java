package org.springframework.websocket.conf;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.websocket.streams.WebsocketStream;

@EnableBinding({WebsocketStream.class})
public class StreamConf {

}
