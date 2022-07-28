package team.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.mypage1DAO;
import team.shop.DTO.clientVO;
import team.shop.DTO.mypage1VO;

public class MyPage1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/member/mypage_1_purchaseList.jsp";
		
		HttpSession session = request.getSession();
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		String id = cVo.getId();
		//select로 내 주문내역 찾아와야 함(product_order table)
		
		mypage1DAO mDao = mypage1DAO.getInstance();
		List<mypage1VO> list = mDao.selectMyProducts(id);
		
		request.setAttribute("mylist", list);
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
