package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.controller.action.Action;

public class AdminLoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/admin_loginForm.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
