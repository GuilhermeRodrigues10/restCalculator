package com.personal.calculator.producer;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ConfigRabbitAdminProducer {
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Bean @Primary
	public RabbitAdmin adminProducer() {
		return new RabbitAdmin(connectionFactory);
	}
		
}
