package com.m.e.company.pokeapi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.m.e.company.pokeapi.models.PokemonObject;

@RequestMapping("/api/v2")
@RestController
public class Controller {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	public Controller(RestTemplate rest) {
		this.restTemplate = rest;
	}
	
	
	private PokemonObject getPokemonObject(final String pokemon) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + pokemon;
		return restTemplate.getForObject(url, PokemonObject.class);
	}
	
	@GetMapping("/{pokemon}/abilities")
	public Object[] getAbilities(@PathVariable String pokemon){ return getPokemonObject(pokemon).getAbilities(); }

	
	@GetMapping("/{pokemon}/base-experiences")
	public HashMap<String, Object> getbaseEx(@PathVariable String pokemon){ 
		HashMap<String, Object> json = new HashMap<>();
		json.put("base_experiences", getPokemonObject(pokemon).getBase_experience()); 	
		return json;
	}

	@GetMapping("/{pokemon}/held-items")
	public Object[] getHeld_items(@PathVariable String pokemon) {
		return getPokemonObject(pokemon).getHeld_items();
}

	@GetMapping("/{pokemon}/name")
	public HashMap<String, Object> getName(@PathVariable String pokemon) {
		HashMap<String, Object> json = new HashMap<>();
		json.put("name", getPokemonObject(pokemon).getName());
		return json;
	}

	@GetMapping("/{pokemon}/id")
	public HashMap<String, Object> getId(@PathVariable String pokemon) {
		HashMap<String,Object> json = new HashMap<>();
		json.put("id", getPokemonObject(pokemon).getId());
		return json;
}
	@GetMapping("/{pokemon}/location-area-encounters")
	public HashMap<String, Object> getLocation_area_encounters(@PathVariable String pokemon) {
		HashMap<String, Object> json = new HashMap<>();
		json.put("location_area_encounters", getPokemonObject(pokemon).getLocation_area_encounters());
		return json;
	}	
	

}
