package com.dell.test.file;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "hangman")
public class Hangman {
	
	public Hangman() {}
	
	 @XmlElementWrapper(name="word_list")
	    @XmlElement(name="word")
    private List<String> words;

	 @XmlTransient
	public List<String> getWords() {
		// use unmodifiable List to avoid access
		return Collections.unmodifiableList(words);
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hangman other = (Hangman) obj;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
	}
	
}
