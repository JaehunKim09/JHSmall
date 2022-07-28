package team.shop.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.clientDAO;
import team.shop.DAO.mtmDAO;
import team.shop.DTO.mtmVO;
import team.shop.controller.action.Action;

public class Admin_mtmList_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/AdminMtmList.jsp";
		
		String id =  request.getParameter("search2");
		
		ArrayList<mtmVO> mtmSearch = new ArrayList<mtmVO>();
		mtmDAO cDao = mtmDAO.getInstance();
		mtmSearch = cDao.searchMtm(id);
		
		request.setAttribute("mtm", mtmSearch);
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
