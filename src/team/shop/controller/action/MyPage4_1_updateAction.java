package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;

public class MyPage4_1_updateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="/member/myInfoUpdate_success.jsp";
		
		String id = request.getParameter("id");
		
		clientVO cVo2 = new clientVO();
	
		cVo2.setPw(request.getParameter("password"));
		cVo2.setEmail(request.getParameter("email"));
		cVo2.setAddress1(request.getParameter("address1"));
		cVo2.setAddress2(request.getParameter("address2"));
		cVo2.setPhone(request.getParameter("phone"));
		
		
		clientDAO cDao2 = clientDAO.getInstance();
		cDao2.updateClient(id,cVo2);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}