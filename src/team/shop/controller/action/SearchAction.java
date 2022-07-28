package team.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.productDAO;
import team.shop.DTO.productVO;

public class SearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/categoryDetail.jsp";
		
		String pName =  request.getParameter("search");
		
		ArrayList<productVO> list = new ArrayList<productVO>();
		productDAO pDao = productDAO.getInstance();
		list = pDao.searchProduct(pName);
		
		request.setAttribute("CategoryList", list);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
