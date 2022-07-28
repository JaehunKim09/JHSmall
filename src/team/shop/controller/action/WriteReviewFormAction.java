package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.p_orderDAO;
import team.shop.DAO.productDAO;
import team.shop.DTO.productVO;

public class WriteReviewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/mypage_2_writeReview.jsp";
		
		productVO pVo = new productVO();
		
		productDAO pDao = productDAO.getInstance();
		pVo = pDao.selectOneProductBypNum(request.getParameter("pNum"));	
		
		request.setAttribute("product", pVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
