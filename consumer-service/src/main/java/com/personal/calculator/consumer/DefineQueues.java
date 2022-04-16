package com.personal.calculator.consumer;

import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor
@Slf4j
public class DefineQueues {
	@Autowired
	private RabbitAdmin rabbitAdmin;
	
	@PostConstruct
	public void createQueue() {
		String myQ1 = rabbitAdmin.declareQueue(new Queue("MyQ1"));
		rabbitAdmin.declareBinding(new Binding(myQ1, Binding.DestinationType.QUEUE, "myExchange", "", new HashMap<>()));
	}
}
