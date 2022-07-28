package team.shop.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.shop.DAO.mtmDAO;
import team.shop.DTO.clientVO;
import team.shop.DTO.mtmVO;

public class mtmDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/member/mypage_6_myQna.jsp";
		
		String mNum = request.getParameter("mNum");
		System.out.println("mtmDelete들어옴..."+mNum);
		mtmDAO mtmDao = mtmDAO.getInstance();
		mtmDao.mtmDelete(mNum);
		
		HttpSession session = request.getSession();
		clientVO cVo = (clientVO)session.getAttribute("loginUser");
		String id = cVo.getId();
		
		mtmDao = mtmDAO.getInstance();
		List<mtmVO> mtmVO = mtmDao.selectMtm(id);
		
		request.setAttribute("mtmVO", mtmVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
