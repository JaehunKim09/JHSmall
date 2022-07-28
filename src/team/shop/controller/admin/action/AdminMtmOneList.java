package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.mtmVO;
import team.shop.controller.action.Action;

public class AdminMtmOneList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/admin/AdminMtmOneList.jsp";
		
		String mNum = request.getParameter("mNum");
		
		mtmDAO mtmDao = mtmDAO.getInstance();
		mtmVO mtmVo = mtmDao.adGetMtm(mNum); 
		
		request.setAttribute("admtm", mtmVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}

}