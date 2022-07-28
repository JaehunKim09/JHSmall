package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;
import team.shop.controller.action.Action;

public class admin_memberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "ShopServlet?command=admin_memberList";
		
		String id = request.getParameter("id");

		
		clientDAO cDao = clientDAO.getInstance();
		
		cDao.DeleteUser(id);
		
		response.sendRedirect(url);
	}
}