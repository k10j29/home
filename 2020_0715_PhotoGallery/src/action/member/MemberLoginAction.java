package action.member;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.MemberVo;

/**
 * Servlet implementation class MemberLoginAction
 */
@WebServlet("/member/login.do")
public class MemberLoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /member/login.do?m_id=hong&m_pwd=1234

		// 1.�������ڵ�
		request.setCharacterEncoding("utf-8");

		// 2.parameter�ޱ�
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");

		// 3.m_id�� �ش�Ǵ� ��ü 1�� ������
		MemberVo user = MemberDao.getInstance().selectOne(m_id);

		String result = "";

		if (user == null) {
			result = "fail_id";
		} else {
			// ���üũ
			if (user.getM_pwd().equals(m_pwd) == false) {
				result = "fail_pwd";
			} else {
				// �α��� ����
				result = "success";
				// �α��� ������ ���ǿ� �ִ´�
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
			}
		}

		// �������(JSON)
		String json = String.format("{\"result\":\"%s\"}", result);

		// ��û��->��� ����
		response.setContentType("text/json; charset=utf-8;");
		response.getWriter().print(json);

	}

}