package team.shop.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.productDAO;
import team.shop.DTO.productVO;
import team.shop.controller.action.Action;

public class AdminSearch implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/admin_categoryDetail.jsp";

		String pName =  request.getParameter("search");

		ArrayList<productVO> list = new ArrayList<productVO>();
		productDAO pDao = productDAO.getInstance();
		list = pDao.searchProduct(pName);

		request.setAttribute("CategoryList", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
