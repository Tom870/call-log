package model;

public class Account {
	private String userId;
	private String pass;
	private String name;
	private String charge;

	public Account() {
	};

	public Account(String userId, String pass, String name, String charge) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.charge = charge;
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

	public String getName() {
		return name;
	}

	public String getCharge() {
		return charge;
	}

}
