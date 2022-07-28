package team.shop.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.reviewDAO;
import team.shop.DTO.reviewVO;

public class ReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/product/review.jsp";
		
		String pNum = request.getParameter("pNum");
		
		reviewDAO rDao = reviewDAO.getInstance();
		
		List<reviewVO> list = rDao.listreview(pNum);
		
		//bDao의 selectOneBoardByNum() 메서드에서 리턴받은 bVo를 request에 세팅하는 것
		//boardDetailView.jsp에서 값 가져올 때 ${oneboard.name}처럼 사용할 것!
		request.setAttribute("list", list); 
		
		//set 완료된 request객체를 해당 url로 뿌려주기 위해 forward() 메서드 이용
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
