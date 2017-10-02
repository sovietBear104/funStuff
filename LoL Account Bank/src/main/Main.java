package main;

public class Main {

	public static void main(String[] args) {
		AccountGenerator accGen = new AccountGenerator();
		
		int numAccounts = 2;
		
		for (int i = 0; i < numAccounts; i++) {
			System.out.println(accGen.generateAccount());
		}
	}

}
