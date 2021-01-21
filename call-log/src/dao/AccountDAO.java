package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	public Account findByLogin(Login login) {
		Connection conn = null;
		Account account = null;
		try {
			//JDBCドライバを読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:\\Users\\81802\\Documents\\date\\CALLLOG", "tomo", "1733");

			//SELECT文の準備
			String sql = "SELECT USER_ID,PASS,NAME,CHARGE FROM ACCOUNT WHERE USER_ID=? AND PASS=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, login.getUserID());
			ps.setString(2, login.getPass());

			//結果表の取得
			ResultSet rs = ps.executeQuery();

			//一致したユーザーがいれば
			//そのユーザーのAccountインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				String userID = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String name = rs.getString("NAME");
				String charge = rs.getString("CHARGE");

				account = new Account(userID, pass, name, charge);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return account;
	}
}
