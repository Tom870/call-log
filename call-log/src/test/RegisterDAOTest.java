package test;

import dao.RegisterDAO;
import model.Register;

public class RegisterDAOTest {

	public static void main(String[] args) {
		Register reg = new Register("佐藤太郎", "060-2754-3843", "E04のエラー内容は？", "エアコン");
		RegisterDAO dao = new RegisterDAO();
		dao.RegisterUser(reg);
	}

}
