package com.personal.calculator.consumer;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ConfigRabbitAdminConsumer {
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Bean 
	public RabbitAdmin admin() {
		return new RabbitAdmin(connectionFactory);
	}
}
