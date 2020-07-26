package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAction
 */
@WebServlet("/hello.do")
public class HelloAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// hello.do
		// hello.do?nation=
		// hello.do?nation=kor

		// 1.parameter ����
		String nation = request.getParameter("nation");
		if (nation == null || nation.isEmpty())
			nation = "kor";

		String message = "";

		switch (nation) {
		case "kor":
			message = String.format("[�ѱ���:%s] �ȳ��ϼ���", nation);
			break;
		case "eng":
			message = String.format("[����:%s] Hi~~", nation);
			break;
		case "jpn":
			message = String.format("[�Ϻ���:%s] ���۳�~~", nation);
			break;
		default:
			message = String.format("[%s] �� ����?", nation);
		}

		// ������ Business Logic �� ó��

		// �����ϱ����� request�� �ִ´�
		// request binding(����)
		request.setAttribute("message", message);

		// ����� : /hello.do
		// / <= WebContext���
		// / <= �������� WebContent

		// Dispatcher(forward): ���缭���� hello.jsp call
		RequestDispatcher disp = request.getRequestDispatcher("hello.jsp");
		disp.forward(request, response);

	}

}
