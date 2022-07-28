package team.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.reviewDAO;
import team.shop.DTO.clientVO;
import team.shop.DTO.reviewVO;

public class MyPage5Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/mypage_5_myReview.jsp";
		
		HttpSession session = request.getSession();
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		String id = cVo.getId();
		
		ArrayList<reviewVO> list = new ArrayList<reviewVO>();
		
		reviewDAO rDao = reviewDAO.getInstance();
		list = rDao.listMyreview(id);
		
		request.setAttribute("rList", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
