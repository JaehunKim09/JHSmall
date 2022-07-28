package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.mtmVO;

public class mtmUpdate implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="ShopServlet?command=mypage_7";
		
		mtmVO mtmVo = new mtmVO();
	
		mtmVo.setmNum(Integer.parseInt(request.getParameter("mNum")));
		mtmVo.setTitle(request.getParameter("title"));
		mtmVo.setContent(request.getParameter("content"));
		mtmVo.setmKind(request.getParameter("mKind"));
		
		mtmDAO mtmDao = mtmDAO.getInstance();
		mtmDao.mtmUpdate(mtmVo);
		
		/*new MyPage6Action().execute(request, response);*/
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		

	}

}
