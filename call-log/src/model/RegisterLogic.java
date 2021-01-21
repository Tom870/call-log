package model;

import dao.RegisterDAO;

public class RegisterLogic {
	public Case execute(Register register) {
		RegisterDAO dao = new RegisterDAO();
		Case result = dao.RegisterUser(register);
		return result;
	}

	public Case EditExecute(Case case1) {
		RegisterDAO dao = new RegisterDAO();
		Case result = dao.EditUser(case1);
		return result;
	}
}
