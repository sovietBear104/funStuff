import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.sikuli.script.Pattern;

public class Champion {

	private String name;
	private Pattern image;
	private Skill q, w, e, r, d, f;
	private File settings;

	public Champion() {
		name = "khazix";
		image = new Pattern("src/champImages/khazix.png");
		settings = new File("src/championSettings/khazix.dat");
	}

	public Champion(String name) {
		this.name = name;
		image = new Pattern("src/champImages/" + name + ".png");
		settings = new File("src/championSettings/" + name + ".dat");
	}

	public Pattern getPattern() {
		return image;
	}

	private void loadSettings() {
		Scanner scan = null;
		char key;
		String type;
		try {
			scan = new Scanner(settings);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		key = scan.nextLine().toCharArray()[0];
		type = scan.nextLine();
		q = new Skill(key, type);
		key = scan.nextLine().toCharArray()[0];
		type = scan.nextLine();
		w = new Skill(key, type);
		key = scan.nextLine().toCharArray()[0];
		type = scan.nextLine();
		e = new Skill(key, type);
		key = scan.nextLine().toCharArray()[0];
		type = scan.nextLine();
		r = new Skill(key, type);
	}

}
