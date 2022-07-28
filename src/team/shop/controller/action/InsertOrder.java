package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.p_orderDAO;
import team.shop.DTO.p_orderVO;

public class InsertOrder implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/order_Fail.jsp";
		
		int result = 0;
		
		String oAddress = request.getParameter("rec_address1")+" ";
		oAddress += request.getParameter("rec_address2");
		
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		int oPrice = Integer.parseInt(request.getParameter("oPrice"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));

		p_orderVO oVo = new p_orderVO();
		oVo.setpNum(pNum);
		oVo.setId(request.getParameter("id"));
		oVo.setoPrice(oPrice);
		oVo.setCnt(cnt);
		oVo.setoName(request.getParameter("rec_name"));
		oVo.setoAddress(oAddress);
		oVo.setoPhone(request.getParameter("rec_phone"));
		
		p_orderDAO oDao = p_orderDAO.getInstance();
		result = oDao.InsertOrder(oVo);
		
		if(result == 1) {
			url = "/product/order_Success.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
