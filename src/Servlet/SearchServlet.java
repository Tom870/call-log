package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Case;
import model.Search;
import model.SearchLogic;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/Search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		int case_id = Integer.parseInt(request.getParameter("case_id"));
		String phone = request.getParameter("phone");

		//入力されたデータで検索
		Search search = new Search(case_id, phone);
		SearchLogic logic = new SearchLogic();
		Case result = logic.execute(search);

		//セッションスコープに保存
		request.getSession().setAttribute("case_id", result.getCase_id());
		request.getSession().setAttribute("phone", result.getPhone());
		request.getSession().setAttribute("name", result.getName());
		request.getSession().setAttribute("contents", result.getContents());
		request.getSession().setAttribute("charge", result.getCharge());

		//フォワード
		request.getRequestDispatcher("/WEB-INF/jsp/SearchResult.jsp").forward(request, response);
	}

	private void checkCase(String phone) {

	}

}
