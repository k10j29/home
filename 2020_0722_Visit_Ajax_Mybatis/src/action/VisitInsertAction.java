package action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VisitDao;
import vo.VisitVo;

/**
 * Servlet implementation class VisitInsertAction
 */
@WebServlet("/visit/insert.do")
public class VisitInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.���� ���ڵ�
		request.setCharacterEncoding("utf-8");
		
		///visit/insert.do?name=ȫ�浿&content=ddd&pwd=1234
		
		//2.parameter���� & IP
		String name 	= request.getParameter("name");
		String content 	= request.getParameter("content");
		String pwd 		= request.getParameter("pwd");
		//��û��(Ŭ���̾�Ʈ)�� ip
		String ip		= request.getRemoteAddr();
		
		//\n -> <br>
		//content="1\n2\n3\n4\n5"=>"1<br>2<br>3<br>4<br>5"
		content = content.replaceAll("\n", "<br>");
		
		
		//3.����
		VisitVo  vo = new VisitVo(name, content, pwd, ip);
		
		//4.DB Insert
		int res = VisitDao.getInstance().insert(vo);
		
		//5.����Ʈ�̵�
		response.sendRedirect("list.do");		
		
		
		
		
	}

}




