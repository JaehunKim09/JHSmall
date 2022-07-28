package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.reviewDAO;
import team.shop.controller.action.Action;

public class AdminReviwReplyUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopServlet?command=admin_review_call";
		
		int rNum = Integer.parseInt(request.getParameter("rNum"));
		String rReply = request.getParameter("rReply");
		
		reviewDAO reviewDao = reviewDAO.getInstance();
		reviewDao.reviewReplyUpdate(rNum,rReply);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
