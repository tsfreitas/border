package com.tsfreitas.border.apicontrol.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SomewhereService {
	
	private boolean hasError = false;

	@HystrixCommand(fallbackMethod="fallbackResponse")
	public List<String> getResponseFromSomewhere() {
		
		if (hasError) {
			hasError = false;
			throw new RuntimeException();
		}
		
		hasError = true;
		
		
		return Arrays.asList("First", "Second", "Third");
	}
	
	@HystrixCommand(fallbackMethod="fallbackResponse")
	public List<String> getTimeOut() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		
		return Arrays.asList("should", "not", "see", "this");
	}
	
	
	public List<String> fallbackResponse() {
		return new ArrayList<>();
	}

	
	
}
