package com.springboard.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webSocket")
public class WebSocketController {
	@GetMapping("chat1")
	public String getWebsocket1() {
		return "websocket/websocketTest1";
	}
	@GetMapping("chat2")
	public String getWebsocket2() {
		return "websocket/websocketTest2";
	}
}
