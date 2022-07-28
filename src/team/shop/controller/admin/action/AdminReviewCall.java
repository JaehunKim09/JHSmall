package team.shop.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.reviewDAO;
import team.shop.DTO.reviewVO;
import team.shop.controller.action.Action;

public class AdminReviewCall implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/admin_review_call.jsp";
		
		reviewDAO rDao = reviewDAO.getInstance();
		
		ArrayList<reviewVO>	reviewVo = rDao.reviewList();
		
		request.setAttribute("review", reviewVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}