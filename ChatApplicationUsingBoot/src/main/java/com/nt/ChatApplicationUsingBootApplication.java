/*
 * Boot Main Application for boostrap the application 
 */

package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplicationUsingBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplicationUsingBootApplication.class, args);
	}

}
