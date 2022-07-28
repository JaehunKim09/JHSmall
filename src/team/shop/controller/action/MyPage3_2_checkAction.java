package team.shop.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.clientDAO;
import team.shop.DTO.clientVO;

public class MyPage3_2_checkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/check_fail.jsp";

		String id2 = request.getParameter("id");
		String pw2 = request.getParameter("pw");
		
		
		clientDAO cDao = clientDAO.getInstance();
		clientVO cVo = cDao.getUser(id2);
		
		if(cVo != null){
			if(cVo.getPw().equals(pw2)){    
				request.setAttribute("client", cVo);
				url="/member/mypage_4_updateInfo.jsp";//4번으로이동하는 커맨드 생성
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
