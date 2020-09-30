package com.dell.test.service;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

import com.dell.test.file.FileReaderService;
import com.dell.test.file.Hangman;
import com.dell.test.file.XMLParser;
import com.dell.test.rest.Item;

@Service
public class HangmanService {
	public Item getWordForHangman() throws IOException, JAXBException {

		// the file url could be parametirized from a property file, but I put the
		// direct URL to make the solution simple
		String fileContent = FileReaderService.getFileContent("src/main/resources/HangmanWords.xml");
		Item item = null;
		if(fileContent != null) {
			Hangman hangman = XMLParser.castXMLtoClass(fileContent);
			item = getRandomWordFromList(hangman);
		}
		
		return item;
		
	}

	private Item getRandomWordFromList(Hangman hangman) {
		List<String> words = hangman.getWords();
		int randomIndex = ThreadLocalRandom.current().nextInt(0, words.size());		
		return new Item(words.get(randomIndex));
	}

}
