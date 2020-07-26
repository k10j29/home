package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSessionAction
 */

//JSP �� �ִ� ��� ����

@WebServlet("/session_test/test_session.do")
public class TestSessionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, // session �� ���� Ŭ���̾�Ʈ�������ϱ� request �� ���� session�� ������ ����
			HttpServletResponse response) throws ServletException, IOException {

		
		
		// �����Ǿ��ִ� ���� ���� ������
		HttpSession session = request.getSession();

		// ���� ID �� �˰�ʹ� ?
		String session_id = session.getId();

		
		//�������� �ݴ¼��� session �� �������.
		// ���� ��ȿ�Ⱓ 60�� 1�е��ȸ� ��ȿ�ϴ�. ������ �����ʰ� �ϴ¹����ִ�. (1���� ����ϱ����� ���ΰ�ħ �ϸ��)
		session.setMaxInactiveInterval(60);
		
		// Session �� ����� ���߿��� �̸��� msg1 ���� ����� �� �о����
		String msg1 = (String) session.getAttribute("msg1");
		
		System.out.println(session_id);

		// ���� binding �ϱ�
		// a.jsp �� TestSessionAction �����̶� ���� ���� (������ ����) �׷��� ���ǿ� ������ �ֱ�
		session.setAttribute("msg", "Hi, session!");

		// �״����� ���� ó���ϱ�
		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		// jsp �� �ִ� ID�� �����ؾ���
		out.print("���� ����ID :" + session_id + "<br>");
		out.print("JSP�� msg1 : " + msg1 + "<br>");
		out.print("<a href='a.jsp'>a.jsp</a>");

	}

}
