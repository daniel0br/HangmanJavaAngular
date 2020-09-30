package com.dell.test.rest;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dell.test.service.HangmanService;


@RestController
public class HangmanController {
	
	@Autowired
	private HangmanService hangmanService;
	

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getWordFromList")
	public Item getAWord() throws IOException, JAXBException {
		return hangmanService.getWordForHangman();
	}
}
