/* 
 * this is controller class having WebSocket related handler methods
 *  
 */

package com.nt.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.websocket.model.ChatMessage;

@Controller
public class ChatController {

	public ChatController() {
		System.out.println("ChatController.ChatController() :: main websocket controller ---------------- ");
	}

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	public ChatMessage register(@Payload ChatMessage chatMessage,SimpMessageHeaderAccessor headerAccessor) {

		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}
}
