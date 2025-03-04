package pojo;

public class User {
	private String username;
	private String email;
	private String passoword;
	private int supercoins;
	public User(String username, String email, String passoword, int supercoins) {
		super();
		this.username = username;
		this.email = email;
		this.passoword = passoword;
		this.supercoins = supercoins;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassoword() {
		return passoword;
	}
	public void setPassoword(String passoword) {
		this.passoword = passoword;
	}
	public int getSupercoins() {
		return supercoins;
	}
	public void setSupercoins(int supercoins) {
		this.supercoins = supercoins;
	}
}
