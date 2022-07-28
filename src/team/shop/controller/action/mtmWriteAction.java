package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.clientVO;
import team.shop.DTO.mtmVO;

public class mtmWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "ShopServlet?command=mypage_6";
		
		HttpSession session = request.getSession();
		
		clientVO loginUser = (clientVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			url = "ShopServlet?command=login_form";
		}else {
			mtmVO mtmVo = new mtmVO();
			
			mtmVo.setId(request.getParameter("id"));
			mtmVo.setTitle(request.getParameter("title"));
			mtmVo.setContent(request.getParameter("content"));
			mtmVo.setmKind(request.getParameter("mKind"));
			
			mtmDAO mtmDao = mtmDAO.getInstance();
			mtmDAO.insertmtm(mtmVo,	loginUser.getId());
		}
		RequestDispatcher dispaatcher = request.getRequestDispatcher(url);
		dispaatcher.forward(request, response);
	}

}
