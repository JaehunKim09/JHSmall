package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.productDAO;
import team.shop.DTO.productVO;
import team.shop.controller.action.Action;

public class AdminUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="ShopServlet?command=admin_main";
		
		String pNum = request.getParameter("pNum");
		
		productVO pVo = new productVO();
	
		pVo.setpName(request.getParameter("pName"));
		pVo.setpPrice(Integer.parseInt(request.getParameter("pPrice")));
		pVo.setpDetailInfo(request.getParameter("pDetailInfo"));

		
		productDAO pDao = productDAO.getInstance();
		pDao.productUpdate(pVo,pNum);
		
		response.sendRedirect(url);
		
	}

}
