package com.dell.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import javax.xml.bind.JAXBException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dell.test.file.Hangman;
import com.dell.test.file.XMLParser;

class XMLParserTests {
	
	private String xmlData;
	private Hangman hangmanExample;

	@BeforeEach
	void setUp() throws Exception {
		xmlData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><hangman><word_list><word>DELL</word></word_list></hangman>";
		
		hangmanExample = new Hangman();
		hangmanExample.setWords(Arrays.asList("DELL"));
	}

	@Test
	void xmlCastSuccessfull() {
		Hangman result = null;
		try {
			result = XMLParser.castXMLtoClass(xmlData);
		} catch (JAXBException e) {
			fail(e.getMessage());
		}
		
		assertEquals(hangmanExample, result);
		
	}

}
