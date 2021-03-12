/*
 * model class for taking user data(credential) from client
 */

package com.nt.websocket.model;

public class UserData {
	
	private String uname;
	private String upass;

	//setters & getters , here we can ues Lombok API also for getting setter & getters
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
}//class
