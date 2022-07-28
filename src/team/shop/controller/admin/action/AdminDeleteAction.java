package team.shop.controller.admin.action;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.productDAO;
import team.shop.controller.action.Action;

public class AdminDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopServlet?command=admin_main";
		
		String pNum = request.getParameter("pNum");
		
		productDAO pDao = productDAO.getInstance();
		pDao.productDelete(pNum);
		
		response.sendRedirect(url);

	}

}
