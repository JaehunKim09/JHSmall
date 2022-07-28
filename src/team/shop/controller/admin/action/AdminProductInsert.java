package team.shop.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.productDAO;
import team.shop.DTO.productVO;
import team.shop.controller.action.Action;

public class AdminProductInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url= "/admin/admin_main.jsp";
		
		String pName = request.getParameter("pName");
		int pPrice = Integer.parseInt(request.getParameter("pPrice"));
		String pImg = request.getParameter("pImg");
		String pShortInfo = request.getParameter("pShortInfo");
		String pDetailInfo = request.getParameter("pDetailInfo");
		String pCategory = request.getParameter("pCategory");
		
		productVO pVo = new productVO();
		
		pVo.setpName(pName);
		pVo.setpPrice(pPrice);
		pVo.setpImg(pImg);
		pVo.setpShortInfo(pShortInfo);
		pVo.setpDetailInfo(pDetailInfo);
		pVo.setpCategory(pCategory);
		
		productDAO pDao = productDAO.getInstance();
		pDao.productInsert(pVo);
		
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}

}
