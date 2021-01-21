package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Case;
import model.Register;
import model.RegisterLogic;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String contents = request.getParameter("contents");
		String charge = request.getParameter("charge");

		//入力されたデータを登録
		Register register = new Register(name, phone, contents, charge);
		RegisterLogic logic = new RegisterLogic();
		Case result = logic.execute(register);

		//ケースIDをセッションスコープに保存
		request.getSession().setAttribute("case_id", result.getCase_id());
		request.getSession().setAttribute("phone", result.getPhone());
		request.getSession().setAttribute("name", result.getName());
		request.getSession().setAttribute("contents", result.getContents());
		request.getSession().setAttribute("charge", result.getCharge());
		//フォワード
		request.getRequestDispatcher("/WEB-INF/jsp/RegisterOK.jsp").forward(request, response);
	}

}
