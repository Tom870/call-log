package model;

public class Case {
	int case_id;
	private String name;
	private String phone;
	private String contents;
	private String charge;

	public Case(int case_id, String name, String phone, String contents, String charge) {
		this.case_id = case_id;
		this.name = name;
		this.phone = phone;
		this.contents = contents;
		this.charge = charge;
	}

	public int getCase_id() {
		return case_id;
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
