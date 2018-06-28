package br.com.oficina.oficina.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oficina")
public class OficinaController {

	@RequestMapping("/index")
	public String index() {
		
		return "Essa é a index";
	}
}
