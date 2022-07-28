package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DTO.p_orderVO;

public class Payment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/payment.jsp";
		
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		int oPrice = Integer.parseInt(request.getParameter("pPrice")) * cnt;
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		p_orderVO oVo = new p_orderVO();
		oVo.setoPrice(oPrice);
		oVo.setCnt(cnt);
		oVo.setpNum(pNum);
		
		request.setAttribute("order", oVo);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
