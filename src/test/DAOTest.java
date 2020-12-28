package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class DAOTest {

	public static void main(String[] args) {
		TestfindByLogin1();
		TestfindByLogin2();
	}

	public static void TestfindByLogin1() {
		Login login = new Login("tom88", "0808");
		AccountDAO ac = new AccountDAO();
		Account result = ac.findByLogin(login);
		//ユーザーの該当がある時
		if (result != null &&
				result.getUserId().equals("tom88") &&
				result.getPass().equals("0808") &&
				result.getName().equals("足立智哉") &&
				result.getCharge().equals("エアコン")) {
			System.out.println("TestfindByLogin1成功");
		} else {
			System.out.println("TestfindByLogin1失敗");
		}
	}

	public static void TestfindByLogin2() {
		//該当のユーザーがいなかった場合
		AccountDAO ac = new AccountDAO();
		Login login = new Login("tarou", "0454");
		Account result = ac.findByLogin(login);
		if (result == null) {
			System.out.println("TestfindByLogin2成功");
		} else {
			System.out.println("TestfindByLogin2失敗");
		}
	}

}
