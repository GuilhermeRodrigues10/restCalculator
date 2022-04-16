package com.personal.calculator.controller;

import java.math.BigDecimal;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personal.calculator.exception.BadRequestException;
import com.personal.calculator.operations.BasicOperations;
import com.personal.calculator.results.Result;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Calculator {
	
	private final BasicOperations oper = new BasicOperations();
	@Autowired
	private RabbitTemplate rabbitTemplate;
	private BigDecimal firstEntry = null;
	private BigDecimal secondEntry = null;
	
	@RequestMapping(value = "/sum", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> sum(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) throws BadRequestException 
	{
		checkEntries(a, b);	
		rabbitTemplate.send("myExchange", "", new Message("A Sum request will be sent.".getBytes()));
		return ResponseEntity.ok().body(this.oper.sum(firstEntry, secondEntry));
	}
	
	@RequestMapping(value = "/subtraction", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> subtraction(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) throws BadRequestException 
	{
		checkEntries(a, b);	
		rabbitTemplate.send("myExchange", "", new Message("A Subtraction request will be sent.".getBytes()));
		return ResponseEntity.ok().body(this.oper.subtration(firstEntry, secondEntry));
	}
	
	@RequestMapping(value = "/multiplication", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> multiplication(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) throws BadRequestException 
	{
		checkEntries(a, b);	
		rabbitTemplate.send("myExchange", "", new Message("A Multiplication request will be sent.".getBytes()));
		return ResponseEntity.ok().body(this.oper.multiplication(firstEntry, secondEntry));
	}
	
	@RequestMapping(value = "/division", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result> division(@RequestParam(value = "a") String a, @RequestParam(value = "b") String b) throws BadRequestException 
	{
		checkEntries(a, b);	
		rabbitTemplate.send("myExchange", "", new Message("A Division request will be sent.".getBytes()));
		return ResponseEntity.ok().body(this.oper.division(firstEntry, secondEntry));
	}

	private void checkEntries(String a, String b) throws BadRequestException {
		try {
			firstEntry = new BigDecimal(a);
			secondEntry = new BigDecimal(b);
		} catch (Exception e) {
			throw new BadRequestException();
		}
	}
}
