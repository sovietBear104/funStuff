package main;

import java.util.Random;

public class PasswordGenerator {
	
	public PasswordGenerator() {
		
	}
	
	public String getPassword() {
		Random rand = new Random();
		String output = "";
		int randInt = rand.nextInt(3);
		switch(randInt) {
		case 0:
			output = output + "pass" + rand.nextInt(1000) + rand.nextInt(1000);
			break;
		case 1:
			output = output + rand.nextInt(1000) + "pass" + rand.nextInt(1000);
			break;
		case 2:
			output = output + rand.nextInt(1000) + rand.nextInt(1000) + "pass";
			break;
		default:
			System.err.println("Error generating password");
		}
		return output;
	}
	
}
