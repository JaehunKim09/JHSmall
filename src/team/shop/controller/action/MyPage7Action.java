package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.mtmVO;

public class MyPage7Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/mypage_7_myQnaDetail.jsp";
		
		String mNum = request.getParameter("mNum");
		
		mtmDAO mtmDao = mtmDAO.getInstance();
		mtmVO mtmVo = mtmDao.selectOneMtm(mNum); 
		
		request.setAttribute("mtm", mtmVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
