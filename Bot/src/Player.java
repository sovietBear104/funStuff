import java.util.Random;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Player {

	private Pattern target;
	private Champion champ;
	private Screen s;
	boolean canQ, canW, canE, canR;

	public Player(Champion champ, Screen s) {
		this.champ = champ;
		this.s = s;
		canQ = canW = canE = canR = false;
	}

	public void update() {
		Random rand = new Random();
		try {
			Thread.sleep((long) (rand.nextInt(76) + 50));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(canQ) {
			
		}else if(canW) {
			
		}else if(canE) {
			
		}else if(canR) {
			
		}else {
			autoAttack();
		}
	}

	public void autoAttack() {
		try {
			s.rightClick(target);
		} catch (FindFailed e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
