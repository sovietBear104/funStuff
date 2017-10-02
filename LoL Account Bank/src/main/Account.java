package main;

public class Account {

	private String user;
	private String pass;
	private String email;
	
	public Account(String user, String pass){
		this.user = user;
		this.pass = pass;
	}
	
	public String getUser() {
		return user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String toString() {
		return user + "|" + pass;
	}
	
}
