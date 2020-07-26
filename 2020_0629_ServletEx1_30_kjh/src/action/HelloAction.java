package action;

import java.io.IOException;
import java.io.PrintWriter;

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

		String ip = request.getRemoteAddr();

//		 ��û�� URL = query ������ ���ؼ�  parameter�� ���޵�
//		 System.out.printf("--[%s] HelloAction : WebModule 3.x Call--\n", ip);
//       http://localhost:9090/2020_0629_ServletEx1_30/hello.do?nation=kor
//                                             		  /hello.do
//		                                              /hello.do?nation=

		String nation = request.getParameter("nation");

		// ���������� �Ķ���� ó��

		if (nation == null || nation.isEmpty()) {
			nation = "kor";

		}
		String greet_message = "";

		if (nation.equals("kor")) {
			greet_message = String.format("[�ѱ���(%s)] : �ȳ��ϼ���", nation);
		} else if (nation.equals("eng")) {
			greet_message = String.format("[����(%s)] : Hello", nation);
		} else if (nation.equals("jpn")) {
			greet_message = String.format("[�Ϻ���(%s)] : ���۳�", nation);
		} else if (nation.equals("chn")) {
			greet_message = String.format("[�߱���(%s)] : nihao", nation);
		} else if (nation.equals("ger")) {
			greet_message = String.format("[���Ͼ�(%s)] : gutnetak", nation);
		} else {
			greet_message = String.format("[����(%s)] : ?? ", nation);
		}

		// ���� ó��

		// ���� �ؾ��� ������ ���� ����
		response.setContentType("text/html; charset=utf-8;");

		// ����� �̿��� ���� ��Ʈ��
		PrintWriter out = response.getWriter();

		// ���� ������ html �� ����
		out.println("<html>");
		out.println("<head><title> Google </title></head>");
		out.println("<body>");

//		out.printf("[%s] IP�� �ȳ��ϼ��� <br>", ip);
//		out.println("���� �����Ͻ�  PC�� ����ڴ� ������ �Դϴ�. <br>");
//
//		out.println("url �ڿ� ?nation=kor,eng,chn,jpn ���� �Է��Ͻø�  <br>");
//		out.println("�� ���� �λ縻�� �����ֽ��ϴ�. <br>");
		out.println(greet_message);

		out.println("</body>");
		out.println("</html>");
	}

}
