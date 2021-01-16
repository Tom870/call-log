package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Case;
import model.Register;

public class RegisterDAO {

	public Case RegisterUser(Register register) {
		Connection conn = null;
		Case case1 = null;
		try {
			//JDBCドライバを読み込み
			Class.forName("org.postgresql.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:postgresql://ec2-52-3-4-232.compute-1.amazonaws.com:5432/d2i9an088topq8?password=03289067bac32a2792885646f2be59c57852ceb3b02f7ba1abca49cc130f725c&sslmode=require&user=hainyvytbazvrv");

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
			String CaseSql = "SELECT * FROM CUSTOMER WHERE CASE_ID IN (SELECT MAX(CASE_ID) FROM CUSTOMER)";
			PreparedStatement CasePs = conn.prepareStatement(CaseSql);

			ResultSet rs = CasePs.executeQuery();

			//結果表からケースを取得
			if (rs.next()) {
				int case_id = rs.getInt("CASE_ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String contents = rs.getString("CONTENTS");
				String charge = rs.getString("CHARGE");

				case1 = new Case(case_id, name, phone, contents, charge);
			}

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
		return case1;

	}

	public Case EditUser(Case case1) {
		Connection conn = null;
		Case CaseReturn = null;
		try {
			//JDBCドライバを読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:\\Users\\81802\\Documents\\date\\CALLLOG", "tomo", "1733");

			//UPDATE文の準備
			String sql = "UPDATE CUSTOMER SET NAME=?, PHONE=?,CONTENTS=?, CHARGE =? WHERE CASE_ID =?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, case1.getName());
			ps.setString(2, case1.getPhone());
			ps.setString(3, case1.getContents());
			ps.setString(4, case1.getCharge());
			ps.setInt(5, case1.getCase_id());

			//UPDATE文を実行
			ps.executeUpdate();

			//SELECT文の準備
			String CaseSql = "SELECT CASE_ID,NAME,PHONE,CONTENTS,CHARGE FROM CUSTOMER WHERE CASE_ID=?";
			PreparedStatement CasePs = conn.prepareStatement(CaseSql);
			CasePs.setInt(1, case1.getCase_id());

			ResultSet rs = CasePs.executeQuery();

			//結果表からケースを取得
			if (rs.next()) {
				int case_id = rs.getInt("CASE_ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String contents = rs.getString("CONTENTS");
				String charge = rs.getString("CHARGE");

				CaseReturn = new Case(case_id, name, phone, contents, charge);
			}

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
		return CaseReturn;

	}
}
