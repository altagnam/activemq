package br.mg.gnam.activemq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

	@Autowired
	private JmsTemplate jmsTemplate;

	@GetMapping("/message/{texto}")
	public void sendMessage (@PathVariable  String texto ) {
		for (int i = 0; i < 150; i++) {
			jmsTemplate.convertAndSend("message", String.valueOf(i) + " " + texto);
		}
		
	}
}
