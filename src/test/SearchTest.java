package test;

import model.Case;
import model.Search;
import model.SearchLogic;

public class SearchTest {

	public static void main(String[] args) {
		Search search = new Search(1, "080-1234-5678");
		SearchLogic logic = new SearchLogic();
		Case result = logic.execute(search);
		if (result != null) {
			System.out.println("成功");
		} else {
			System.out.println("失敗");
		}
	}

}
