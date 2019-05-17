package br.mg.gnam.activemq.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {
	
	@JmsListener(destination = "message")
	public void listener (String message) {	
		System.out.println("INI " + message +  " " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:sss").format(new Date())); 
		
		Thread t = new Thread(() -> {
			wait(message);
			System.out.println( message );
			System.out.println("=>>>>>> Thread " + message +  " "  + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:sss").format(new Date())); 
			System.out.println("###################################################################");
		});		
		t.start();
		
		System.out.println("FIM " + message +  " "  + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:sss").format(new Date())); 
		
		
	}
	
	
	private void wait (String message) {
		try {
			
			Thread.sleep(new Random().nextInt(100) * 30);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
