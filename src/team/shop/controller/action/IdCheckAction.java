package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.clientDAO;

public class IdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/dbCheckId.jsp";
		
		String id = request.getParameter("id");
		System.out.println("id : "+id);
		
		clientDAO cDao = clientDAO.getInstance();
		//ID 존재 시 1리턴, 없으면 0리턴
		int result = cDao.getUserIdCheck(id);
		
		request.setAttribute("userId", id);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
