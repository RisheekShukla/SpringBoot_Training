package pojo;

public class User {
	private String username;
	private String email;
	private String passw;
	private int sup_coins;
	public User(String string, String string2, String string3, int i) {
		username = string;
		email = string2;
		passw = string3;
		sup_coins=i;
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
	public String getPassw() {
		return passw;
	}
	public void setPassw(String passw) {
		this.passw = passw;
	}
	public int getSup_coins() {
		return sup_coins;
	}
	public void setSup_coins(int sup_coins) {
		this.sup_coins = sup_coins;
	}
	
	@Override
    public String toString() {
        return "User [Username: " + username + ", Email: " + email + ", SuperCoins: " + sup_coins + "]";
    }
}
