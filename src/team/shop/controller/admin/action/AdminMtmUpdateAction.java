package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.mtmVO;
import team.shop.controller.action.Action;

public class AdminMtmUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="ShopServlet?command=admin_mtmList";
		
		mtmVO mtmVo = new mtmVO();
		
		String mNum = request.getParameter("mNum");
		String reply = request.getParameter("reply");
		
		mtmVo.setmNum(Integer.parseInt(mNum));
		mtmVo.setReply(reply);
	
		mtmDAO mtmDao = mtmDAO.getInstance();
		mtmDao.admtmUpdate(mtmVo);
		
		response.sendRedirect(url);

	}

}