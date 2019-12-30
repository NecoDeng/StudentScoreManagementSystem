package ssms.entity;

public class User {
	
	private String account;
	private String password;
	private String userName;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public User(String account, String password, String userName) {
		super();
		this.account = account;
		this.password = password;
		this.userName = userName;
	}
	
}
