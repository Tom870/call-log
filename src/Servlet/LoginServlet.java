package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Login;
import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");

		//ログインできるかどうか確認
		Login login = new Login(userid, pass);
		LoginLogic logic = new LoginLogic();
		if (logic.execute(login)) {
			//セッションスコープに保存
			request.getSession().setAttribute("userid", userid);

			//ログイン後、トップ画面にフォワード
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/Top.jsp").forward(request, response);
		} else {
			//ログイン失敗画面にフォワード
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/LoginNG.jsp").forward(request, response);
		}

	}

}
