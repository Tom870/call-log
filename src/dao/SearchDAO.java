package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Case;
import model.Search;

public class SearchDAO {

	public Case SearchCase(Search search) {
		Connection conn = null;
		Case case1 = null;
		try {
			//JDBCドライバを読み込み
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection(
					"jdbc:h2:file:C:\\Users\\81802\\Documents\\date\\CALLLOG", "tomo", "1733");

			//SELECT文の準備
			String sql = "SELECT CASE_ID,NAME,PHONE,CONTENTS,CHARGE FROM CUSTOMER WHERE CASE_ID=? OR PHONE=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, search.getCase_id());
			ps.setString(2, search.getPhone());

			//結果表の取得
			ResultSet rs = ps.executeQuery();

			//一致したユーザーがいれば
			//そのユーザーのCaseインスタンスを生成
			if (rs.next()) {
				//結果表からデータを取得
				int case_id = rs.getInt("CASE_ID");
				String name = rs.getString("NAME");
				String phone = rs.getString("PHONE");
				String contents = rs.getString("CONTENTS");
				String charge = rs.getString("CHARGE");

				case1 = new Case(case_id, name, phone, contents, charge);
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
		return case1;
	}
}
