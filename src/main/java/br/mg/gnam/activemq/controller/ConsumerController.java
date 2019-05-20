package br.mg.gnam.activemq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {
	
	@JmsListener(destination = "message")
	public void listener (String message) {		
		System.out.println(message); 		
		
	}
	
	
}
