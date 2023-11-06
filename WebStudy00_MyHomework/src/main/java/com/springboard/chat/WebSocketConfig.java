package com.springboard.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import lombok.RequiredArgsConstructor;

@Configuration // 이 클래스를 설정파일로 bean으로 등록
@EnableWebSocket // 웹소켓 통신에 대한 설정 파일임을 명시한다. (웹소켓 관련 설정을 자동으로 해주는 어노테이션
@RequiredArgsConstructor // 생성자 주입
public class WebSocketConfig implements WebSocketConfigurer { // 01.WebSecketConfigurer 를 상속 받은 클래스에서 사용할 hanlder 클래스와
																// 경로를 설정해주어야한다.
	private final WebSocketHandler webSocketHandler;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(webSocketHandler, "/basic/chat").setAllowedOrigins("*");
	}

}
