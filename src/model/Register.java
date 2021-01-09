package model;

public class Register {
	private String name;
	private String phone;
	private String contents;
	private String charge;

	public Register(String name, String phone, String contents, String charge) {
		this.name = name;
		this.phone = phone;
		this.contents = contents;
		this.charge = charge;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getContents() {
		return contents;
	}

	public String getCharge() {
		return charge;
	}

}
