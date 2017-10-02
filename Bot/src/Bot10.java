import java.util.Random;

import org.sikuli.script.*;

public class Bot10 {

	final float NINETY = (float) 0.90;
	String username;
	String password;

	public Bot10() {
		username = "TestBot104";
		password = "testBot2";
	}

	public static void main(String[] args) {
		Screen s = new Screen();
		Bot10 bot = new Bot10();
		bot.startLeague(s);
		try {
			Thread.sleep(5000);
			bot.login(s);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (!bot.signedUp(s)) {
			bot.signUp(s);
		}
		bot.pressOK(s);
		bot.pressPlay(s);
		bot.startCustom(s);
		bot.selectChamp("khazix", s);
	}

	public void startLeague(Screen s) {
		Pattern win10start = new Pattern("src/win10images/windows10start.png");
		Pattern win10search = new Pattern("src/win10images/10startSearch.png");
		try {
			s.click(win10start.similar(NINETY));
			s.wait(win10search.similar(NINETY));
			s.click(win10search.similar(NINETY));
			s.type("league" + Key.ENTER);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public void signUp(Screen s) {
		Random rand = new Random();
		Pattern lolChooseName = new Pattern("src/win10images/lolChooseName.png");
		Pattern lolNameUnavailable = new Pattern("src/win10images/lolSignIn.png");
		Pattern lolYes = new Pattern("src/win10images/lolYes.png");
		Pattern lolSkip = new Pattern("src/win10images/lolSkip.png");
		Pattern lolRose = new Pattern("src/win10images/lolRose.png");

		try {
			s.wait(lolChooseName, 10000);
			s.click(lolChooseName);
			s.type(username + Key.ENTER);
			while (s.exists(lolNameUnavailable) != null) {
				s.type("" + rand.nextInt(100));
			}
			s.wait(lolYes);
			s.click(lolYes);
			s.wait(lolSkip);
			s.click(lolSkip);
			s.wait(lolSkip);
			s.click(lolSkip);
			s.wait(lolRose);
			s.click(lolRose);
		} catch (FindFailed e) {
			System.err.println("SIGNUP FAILED!");
		}
	}

	public void login(Screen s) {
		Pattern lolUser = new Pattern("src/win10images/lolUser.png");
		Pattern lolPass = new Pattern("src/win10images/lolPass.png");
		Pattern lolSignIn = new Pattern("src/win10images/lolSignIn.png");

		try {
			s.wait(lolUser.similar(NINETY), 100000);
			s.click(lolUser.similar(NINETY));
			bufferedType(username, s);
			s.click(lolPass.similar(NINETY));
			bufferedType(password, s);
			s.click(lolSignIn);
		} catch (FindFailed e) {
			System.err.println("LOGIN FAILED!");
		}
	}

	public boolean signedUp(Screen s) {
		Pattern lolChooseName = new Pattern("src/win10images/lolChooseName.png");
		if (s.exists(lolChooseName) != null) {
			return false;
		}
		return true;
	}

	public void bufferedType(String string, Screen s) {
		Random rand = new Random();
		char[] characters = string.toCharArray();
		for (int i = 0; i < characters.length; i++) {
			s.type("" + characters[i]);
			try {
				Thread.sleep((long) rand.nextInt(100) + 30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void pressOK(Screen s) {
		Pattern lolOK = new Pattern("src/win10images/lolOK.png");

		try {
			s.wait(lolOK, 5000);
		} catch (FindFailed e1) {
			System.err.println("OK NOT FOUND!");
		}
		if (s.exists(lolOK) != null) {
			try {
				s.click(lolOK.similar(1));
			} catch (FindFailed e) {
				System.err.println("OK NOT FOUND!");
			}
		}
	}

	public void pressPlay(Screen s) {
		Pattern lolPlay = new Pattern("src/win10images/lolPlay.png");

		try {
			s.click(lolPlay);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public void startCustom(Screen s) {
		Pattern lolConfirm = new Pattern("src/win10images/lolConfirm.png");
		Pattern lolCreateCustom = new Pattern("src/win10images/lolCreateCustom.png");
		Pattern lolStartGame = new Pattern("src/win10images/lolStartGame.png");
		Pattern lolYes = new Pattern("src/win10images/lolCustomYes.png");

		try {
			s.click(lolCreateCustom);
			s.click(lolConfirm);
			s.click(lolStartGame);
			s.click(lolYes.similar(NINETY));
		} catch (FindFailed e) {
			System.err.println("CREATE CUSTOM GAME FAILED!");
		}
	}

	public void selectChamp(String champion, Screen s) {
		Pattern lolChampSearch = new Pattern("src/champSelectImages/lolChampSearch.png");
		Pattern lolChampLockIn = new Pattern("src/champSelectImages/lolChampLockIn.png");
		Champion champ = new Champion(champion);

		try {
			s.click(lolChampSearch);
			s.type(champion);
			Thread.sleep(1000);
			s.click(champ.getPattern());
			s.click(lolChampLockIn);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
