package team.shop.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.cartDAO;
import team.shop.DAO.p_orderDAO;
import team.shop.DTO.cartVO;
import team.shop.DTO.clientVO;
import team.shop.DTO.p_orderVO;

public class CartPayment implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/product/order_Success.jsp";
		
		p_orderDAO oDao = p_orderDAO.getInstance();
		HttpSession session = request.getSession();
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		String id = cVo.getId();

		cartDAO cartDao = cartDAO.getInstance();
		ArrayList<cartVO> cartVo = cartDao.cartList(id); //cart_view에서 장바구니 내 상품정보 select
		
		
		//oName test
		System.out.println("oName : "+request.getParameter("rec_name"));
		//테이블 주소 2개로 나누기(일반/상세)
		String oAddress = request.getParameter("rec_address1")+" ";
		oAddress += request.getParameter("rec_address2");
		//select로 cart_view에서 정보 가져오기(List type) ct.cNum, ct.id, ct.pNum, ct.cnt, p.pImg, p.pName, p.pPrice
		
		p_orderVO oVo = new p_orderVO();
		//product_order table insert 항목 : pNum id oNum oPrice cnt  oName oAddress oPhone 

		for (cartVO cartVO : cartVo) {
			
		oVo.setpNum(cartVO.getpNum());
		oVo.setId(cartVO.getId());
		oVo.setoPrice(cartVO.getpPrice() * cartVO.getCnt());
		oVo.setCnt(cartVO.getCnt());
		//고정 배송지 정보 3개
		oVo.setoName(request.getParameter("rec_name"));
		oVo.setoAddress(oAddress);
		oVo.setoPhone(request.getParameter("rec_phone"));
		
		//insert 상품별로 반복 필요
		oDao.InsertOrder(oVo);
		}
		//결제완료 후 카트테이블 
		cartDao.cartDeleteAfterPayment(id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
