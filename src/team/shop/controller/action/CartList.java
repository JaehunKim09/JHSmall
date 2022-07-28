package team.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.cartDAO;
import team.shop.DTO.cartVO;
import team.shop.DTO.clientVO;

public class CartList implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/cartList.jsp";
		HttpSession session = request.getSession();
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		String id = cVo.getId();
		
		if (id == null) {
			url = "ShopServlet?command=login_form";
		} else {
			cartDAO cartDao = cartDAO.getInstance();
			ArrayList<cartVO> cartList = cartDao.cartList(id);

			int totalPrice = 0;
			for (cartVO cartVO : cartList) {
				totalPrice += cartVO.getpPrice() * cartVO.getCnt();
			}
			
			request.setAttribute("cartList", cartList);
			request.setAttribute("totalPrice", totalPrice);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
