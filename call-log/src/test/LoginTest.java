package test;

import model.Login;
import model.LoginLogic;

public class LoginTest {

	public static void main(String[] args) {
		Login login = new Login("tom88", "0808");
		LoginLogic logic = new LoginLogic();
		boolean result = logic.execute(login);
		if (result) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}

	}

}
