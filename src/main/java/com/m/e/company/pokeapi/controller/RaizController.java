package com.m.e.company.pokeapi.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RaizController {

	@GetMapping("/")
	public HashMap<String, Object> main(){
		HashMap<String, Object> json = new HashMap<>();
		json.put("hello", "HelloWorld!");
		return json;
	}
	
}
