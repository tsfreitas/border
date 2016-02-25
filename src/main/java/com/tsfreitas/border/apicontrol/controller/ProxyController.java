package com.tsfreitas.border.apicontrol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsfreitas.border.apicontrol.service.SomewhereService;

@RestController
public class ProxyController {

	private SomewhereService service;

	@Autowired
	public ProxyController(SomewhereService service) {
		this.service = service;
	}

	@RequestMapping("/resource/somewhere")
	public List<String> getResourcesFromSomewhere() {

		return service.getResponseFromSomewhere();
	}

	
	@RequestMapping("/resource/timeout")
	public List<String> getResourcesFromTiemout() {

		return service.getTimeOut();
	}
	
}
