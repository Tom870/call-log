package model;

public class Search {
	int case_id;
	String phone;

	public Search(int case_id, String phone) {
		this.case_id = case_id;
		this.phone = phone;
	}

	public Search(int case_id) {
		this.case_id = case_id;
	}

	public Search(String phone) {
		this.phone = phone;
	}

	public int getCase_id() {
		return case_id;
	}

	public String getPhone() {
		return phone;
	}
}
