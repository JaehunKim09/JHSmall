package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.adminDAO;
import team.shop.DTO.adminVO;
import team.shop.controller.action.Action;

public class AdminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/admin/admin_login_fail.jsp";

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HttpSession session = request.getSession();
		
		
		adminDAO adminDao = adminDAO.getInstance();
		adminVO adminVo = adminDao.getUser(id);
		
		if(adminVo != null){
			if(adminVo.getPw().equals(pw)){    
				
				session.setAttribute("loginAdmin", adminVo);
				url="ShopServlet?command=admin_main";
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}