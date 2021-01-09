package test;

import model.Register;
import model.RegisterLogic;

public class RegisterTest {
	public static void main(String args[]) {
		Register register = new Register("後藤雄太", "080-7858-4738", "店舗で使用しているエアコンが壊れた", "エアコン");
		RegisterLogic logic = new RegisterLogic();

	}
}
