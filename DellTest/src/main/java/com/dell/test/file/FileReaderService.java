package com.dell.test.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderService {
	
	public static String getFileContent(String url) throws IOException {
		return new String(Files.readAllBytes(Paths.get(url)));
	}

}
