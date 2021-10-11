package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;
import model.MemberVO;

/**
 * Servlet implementation class FindMemberByIdServlet
 */
@WebServlet("/FindMemberByIdServlet")
public class FindMemberByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 컨트롤러 로직
		 * 	1. 클라이언트가 전달한 아이디를 받아온다 
		 * 	2. Model( MemberDAO ) 과 연동해서 결과(MemberVO)를 반환받는다
		 * 	3. 반환받은 MemberVO 가 null 이면 
		 * 	   - findMemberById-fail.jsp 로 이동시킨다 ( forward ) 
		 * 	4. 반환받은 MemberVO 가 null 이 아니면
		 * 	   - request 에 MemberVO를 할당한다
		 * 		 findMemberById-ok.jsp로 이동시킨다 ( forward ) 
		 */
		
		//form에서 전달한 name과 동일하도록 유의할 것 
		//사용자가 입력한 memberId의 value값을 가져오는 코드
		
		/**
		 * FindMemberByidServlet에서 vo객체의 존재여부(= id일치여부)에 따라
		 * findMemberById-fail.jsp | findMemberById-ok.jsp 로 이동되는데 
		 * forward의 경우 서버상에서 (클라이언트에게 노출되지 않고)이동되기 때문에 
		 * 내부적으로 요청 페이지가 이동되더라도 
		 * 웹페이지의 url은 변경되지 않고 FindMemberByIdServlet으로 그대로 유지된다
		 */
		String id = request.getParameter("memberId");
		try {
			MemberDAO dao = new MemberDAO();
			MemberVO vo = dao.findMemberById(id);
			//request.setAttribute("vo", vo);
			//forward 각각 넣어도 됨
			String path = null;
			//사용자가 입력한 id가(memberId의 value 값) findMemberById(id)를 통해 존재하거나 존재하지 않는다면
			if(vo == null) {//아이디에 대한 회원 정보가 존재하지 않으면
				//request.setAttribute("memberVO", vo);
				path = "findMemberById-fail.jsp";
			}	
			else {//존재하면
				//존재하는 경우만 객체 받아오기
				request.setAttribute("memberVO", vo);
				path = "findMemberById-ok.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















