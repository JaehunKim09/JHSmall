package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;
import team.shop.controller.action.Action;

public class admin_memberDetailViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/admin/admin_memberDetail.jsp";
		
		String id = request.getParameter("id");
		
		clientDAO cDao = clientDAO.getInstance();
		clientVO cVO = cDao.selectOneclient(id);
		
		request.setAttribute("client", cVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}