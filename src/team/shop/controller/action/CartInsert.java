package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.cartDAO;
import team.shop.DTO.cartVO;
import team.shop.DTO.clientVO;

public class CartInsert implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "ShopServlet?command=cart_list";
		
		HttpSession session = request.getSession();
		
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		int cnt = Integer.parseInt(request.getParameter("cnt"));
		String id = cVo.getId();
		
		cartVO cartVo = new cartVO();
		
		cartVo.setId(id);
		cartVo.setpNum(pNum);
		cartVo.setCnt(cnt);
		
		System.out.println("pNum :"+pNum);
		System.out.println("cnt : "+cnt);
		System.out.println("id : "+id);
		
		cartDAO cartDao = cartDAO.getInstance();
		cartDao.cartInsert(cartVo);
		
		response.sendRedirect(url);

	}

}
