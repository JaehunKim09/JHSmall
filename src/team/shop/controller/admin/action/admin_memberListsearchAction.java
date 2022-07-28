package team.shop.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;
import team.shop.controller.action.Action;

public class admin_memberListsearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/admin_memberList.jsp";
		
		String id =  request.getParameter("search");
		
		ArrayList<clientVO> client = new ArrayList<clientVO>();
		clientDAO cDao = clientDAO.getInstance();
		client = cDao.searchClient(id);
		
		request.setAttribute("clientList", client);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}