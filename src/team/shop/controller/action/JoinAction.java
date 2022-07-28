package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/login.jsp";
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		
		String email = request.getParameter("emailId");
		email += "@";
		email += request.getParameter("emailDomain");
		
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		String phone = request.getParameter("phone");
		
		clientVO cVo = new clientVO();
		
		cVo.setId(id);
		cVo.setPw(pw);
		cVo.setName(name);
		cVo.setEmail(email);
		cVo.setAddress1(address1);
		cVo.setAddress2(address2);
		cVo.setPhone(phone);
		
		clientDAO cDao = clientDAO.getInstance();
		cDao.insertClient(cVo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
