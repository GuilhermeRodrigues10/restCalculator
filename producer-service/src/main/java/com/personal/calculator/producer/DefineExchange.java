package com.personal.calculator.producer;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefineExchange {
	@Autowired
	private RabbitAdmin rabbitAdmin;
	
	@PostConstruct
	public void createExchange() {
		rabbitAdmin.declareExchange(ExchangeBuilder.directExchange("myExchange").build());	
	}	
}
