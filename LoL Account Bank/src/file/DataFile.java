package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DataFile {

	private File file;
	private ArrayList<String> lines;

	public DataFile(File newFile) {
		file = newFile;
		readFile(file);
	}

	private void readFile(File newFile) {
		Scanner scan;
		lines = new ArrayList<String>();
		try {
			scan = new Scanner(newFile);
			while(scan.hasNextLine()) {
				lines.add(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Error reading file!");
		}
	}
	
	public int getNumLines() {
		return lines.size();
	}
	
	public String getRandLine() {
		Random rand = new Random();
		int randInt = rand.nextInt(lines.size());
		return lines.get(randInt);
	}
	
	public String getSpecificLine(int index) {
		return lines.get(index);
	}
	
	public File getFile() {
		return file;
	}

}
