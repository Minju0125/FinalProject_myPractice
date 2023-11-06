package com.springboard.board.webSocketTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/websocketTest")
public class chatController {
	@GetMapping("chatList")
	public String getChatList() {
		return "chat/selectChat";
	}
	@GetMapping("template")
	public String getTemplateChatList() {
		return "chat/template_chatList";
	}
}
