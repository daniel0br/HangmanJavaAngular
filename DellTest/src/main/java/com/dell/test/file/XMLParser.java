package com.dell.test.file;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Class created to cast the XML received to a list of words
 * 
 * @author daniel
 *
 */
public class XMLParser {

	/**
	 * Cast string in XML format to Hangman object
	 * @param xmlData
	 * @return
	 * @throws JAXBException
	 */
	public static Hangman castXMLtoClass(String xmlData) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Hangman.class);
		
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		return (Hangman) jaxbUnmarshaller.unmarshal(new StringReader(xmlData));
	}
	
	public static void main(String[] args) {
		//castXMLtoClass()
	}

}
