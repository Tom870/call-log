package model;

import dao.RegisterDAO;

public class RegisterLogic {
	public int execute(Register register) {
		RegisterDAO dao = new RegisterDAO();
		int case_id = dao.RegisterUser(register);
		return case_id;
	}
}
