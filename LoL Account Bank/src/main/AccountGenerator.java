package main;

public class AccountGenerator {

	private PasswordGenerator passGen = new PasswordGenerator();
	private NameGenerator userGen = new NameGenerator();
		
	public AccountGenerator() {
		
	}
	
	public Account generateAccount() {
		String user = userGen.getRandName();
		String pass = passGen.getPassword();
		Account output = new Account(user, pass);
		return output;
	}
	
}
