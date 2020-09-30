package com.dell.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.junit.jupiter.api.Test;

import com.dell.test.file.FileReaderService;


public class FileReaderServiceTests {

	String unexistingFile = "example.xml";
	String existingFile = "src/main/resources/example.txt";
	
	@Test
	public void fileNotFound() {
		
		Exception exception = assertThrows(NoSuchFileException.class, () -> {
			FileReaderService.getFileContent(unexistingFile);			
        });

        assertEquals(exception.getMessage(), unexistingFile);
	}
	
	@Test
	public void fileReaderSuccess() {
		
		String result = null;
		
		try {
			result = FileReaderService.getFileContent(existingFile);
		} catch (IOException e) {
			fail(e.getMessage());
		}			

        assertEquals("text example", result);
	}

}
