package team.shop.controller.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;
import team.shop.controller.action.Action;

public class admin_memberListselectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/admin_memberList.jsp";
		
		
		clientDAO cDao = clientDAO.getInstance();
		
		List<clientVO> client = cDao.selectAllclients();

		request.setAttribute("clientList", client);
		request.getRequestDispatcher(url).forward(request, response);

	}

}