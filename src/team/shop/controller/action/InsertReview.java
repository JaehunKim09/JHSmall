package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.reviewDAO;
import team.shop.DTO.reviewVO;

public class InsertReview implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/writeReview_Success.jsp";
		
		String id = request.getParameter("id");
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		String content = request.getParameter("content");
		
		reviewVO rVo = new reviewVO();
		
		rVo.setId(id);
		rVo.setpNum(pNum);
		rVo.setContent(content);
		
		reviewDAO rDao = reviewDAO.getInstance();
		rDao.insertReview(rVo);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
