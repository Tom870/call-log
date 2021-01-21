package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Case;
import model.RegisterLogic;
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
		//フォワード先
		String forwardPath = null;

		//リクエストパラメータを取得
		String action = request.getParameter("action");

		//トップから検索を押された時の処理
		if (action == null) {
			forwardPath = "/WEB-INF/jsp/Search.jsp";
		}

		//検索結果画面から編集を押された時の処理
		else if (action.equals("done")) {
			//フォワード先を指定
			forwardPath = "/WEB-INF/jsp/Edit.jsp";
		}
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String edit = request.getParameter("edit");
		//登録処理
		if (edit == null) {
			//リクエストパラメータを取得
			//空文字じゃなければ、キャストする
			request.setCharacterEncoding("UTF-8");
			int id = 0;
			String case_id = (request.getParameter("case_id"));
			if (!case_id.equals("")) {
				id = Integer.parseInt(case_id);
			}
			String phone = request.getParameter("phone");

			//入力されたデータで検索
			//nullチェック
			Search search = new Search(id, phone);
			SearchLogic logic = new SearchLogic();
			Case result = logic.execute(search);
			if (result == null) {
				request.getRequestDispatcher("/WEB-INF/jsp/SearchNG.jsp").forward(request, response);
			} else {
				//セッションスコープに保存
				request.getSession().setAttribute("case_id", result.getCase_id());
				request.getSession().setAttribute("phone", result.getPhone());
				request.getSession().setAttribute("name", result.getName());
				request.getSession().setAttribute("contents", result.getContents());
				request.getSession().setAttribute("charge", result.getCharge());

				//フォワード
				request.getRequestDispatcher("/WEB-INF/jsp/SearchResult.jsp").forward(request, response);
			}

		} else if (edit.equals("done")) {
			//編集時処理
			//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			int case_id = Integer.parseInt(request.getParameter("editcase_id"));
			String editname = request.getParameter("editname");
			String editphone = request.getParameter("editphone");
			String editcontents = request.getParameter("editcontents");
			String editcharge = request.getParameter("editcharge");

			//編集処理を実行
			Case case1 = new Case(case_id, editname, editphone, editcontents, editcharge);
			RegisterLogic logic = new RegisterLogic();
			Case result = logic.EditExecute(case1);

			//セッションスコープに保存
			request.getSession().setAttribute("case_id", result.getCase_id());
			request.getSession().setAttribute("phone", result.getPhone());
			request.getSession().setAttribute("name", result.getName());
			request.getSession().setAttribute("contents", result.getContents());
			request.getSession().setAttribute("charge", result.getCharge());

			//フォワード
			request.getRequestDispatcher("/WEB-INF/jsp/EditOK.jsp").forward(request, response);

		}
	}
}
