/*
 * model class having decalaration about WebScoket content,sender,type
 */

package com.nt.websocket.model;

public class ChatMessage {

	private String content;
	private String sender;
	private MessageType type;

	//taking set of constants (a variable that does not change) using ennum
	public enum MessageType{
		CHAT,LEAVE,JOIN;
	}
	
	public ChatMessage() {
		System.out.println("ChatMessage.ChatMessage() ::  model chat class ----------------");
	}
	
	//setters & getters , here we can ues Lombok API also for getting setter & getters
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
}//class
