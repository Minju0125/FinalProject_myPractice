package com.springboard.pracitceApi;

import java.security.SecureRandom;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class test {
	public static void main(String[] args) {
		String tempPassword = generateRndPassword(); // 임시비밀번호 발급
		String sendText = String.format("[Web발신]\n[AllRounder] 임시비밀번호 %s 입니다.", tempPassword);

//	SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
		System.out.println(sendText);
	}

	private static String generateRndPassword() {
		int length = 8 + (int) (Math.random() * 5); // 8부터 12까지의 길이
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder code = new StringBuilder();
		SecureRandom random = new SecureRandom();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(characters.length());
			char randomChar = characters.charAt(randomIndex);
			code.append(randomChar);
		}

		log.info("임시비밀번호 : {}", code.toString());
		return code.toString();
	}
}
