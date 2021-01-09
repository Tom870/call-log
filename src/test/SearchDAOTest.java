package test;

import dao.SearchDAO;
import model.Case;
import model.Search;

public class SearchDAOTest {

	public static void main(String[] args) {
		Search search = new Search(1, "080-1234-5678");
		SearchDAO dao = new SearchDAO();
		Case result = dao.SearchCase(search);
		if (result != null) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
	}

}
