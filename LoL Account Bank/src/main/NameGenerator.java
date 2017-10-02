package main;

import java.io.File;
import java.util.Random;

import file.DataFile;

public class NameGenerator {
	
	private DataFile nouns, adjectives;

	public NameGenerator() {
		nouns = new DataFile(new File("src/file/Nouns.dat"));
		adjectives = new DataFile(new File("src/file/Adjectives.dat"));
	}
	
	public String getRandName() {
		Random rand = new Random();
		int randInt = rand.nextInt(4);
		String output = "";
		switch(randInt) {
		case 0:
			output = output + nouns.getRandLine();
			break;
		case 1:
			output = output + adjectives.getRandLine() + nouns.getRandLine();
			break;
		case 2:
			output = output + nouns.getRandLine() + nouns.getRandLine();
			break;
		case 3:
			output = output + adjectives.getRandLine() + nouns.getRandLine() + nouns.getRandLine();
			break;
		default:
			System.err.println("Error generating name!");
		}
		if(rand.nextBoolean()) {
			output = output + rand.nextInt(100);
		}
		if(rand.nextBoolean()) {
			output = output.toLowerCase();
		}
		return output;
	}
	
}
