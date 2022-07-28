package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.cartDAO;
import team.shop.DTO.cartVO;
import team.shop.DTO.clientVO;

public class CartDelete implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopServlet?command=cart_list";
		
		int cNum = Integer.parseInt(request.getParameter("cNum"));
		
		cartDAO cartDao = cartDAO.getInstance();
		cartDao.cartDelete(cNum);
		
		response.sendRedirect(url);

	}

}
