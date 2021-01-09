package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Register;

public class RegisterDAO {

	public int RegisterUser(Register register) {
		Connection conn = null;
		int case_id = 0;
		try {
			//JDBCドライバを読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:\\Users\\81802\\Documents\\date\\CALLLOG", "tomo", "1733");

			//INSERT文の準備
			String sql = "INSERT INTO CUSTOMER(NAME,PHONE,CONTENTS,CHARGE) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, register.getName());
			ps.setString(2, register.getPhone());
			ps.setString(3, register.getContents());
			ps.setString(4, register.getCharge());

			//INSERT文を実行
			ps.executeUpdate();

			//SELECT文の準備
			String CaseSql = "SELECT CASE_ID FROM CUSTOMER WHERE CASE_ID=(SELECT MAX(CASE_ID) FROM CUSTOMER)";
			PreparedStatement CasePs = conn.prepareStatement(CaseSql);

			ResultSet rs = CasePs.executeQuery();

			//結果表からケースIDを取得
			rs.next();
			case_id = rs.getInt("CASE_ID");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return case_id;
	}
}
