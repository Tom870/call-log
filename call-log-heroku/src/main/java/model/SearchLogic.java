package model;

import dao.SearchDAO;

public class SearchLogic {
	public Case execute(Search search) {
		SearchDAO dao = new SearchDAO();
		Case result = dao.SearchCase(search);
		return result;
	}
}
