package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myutil.Jumin;

/**
 * Servlet implementation class JuminAction
 */
@WebServlet("/jumin.do")
public class JuminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		String jumin_no = request.getParameter("jumin_no");

		// �ֹι�ȣ -> �����Ǻΰ����� ����
		Jumin jumin = new Jumin();
		jumin.setJumin_no(jumin_no);

		// ���������� -> �������� ��ü�� �� Ȱ������....
		int year = jumin.getYear();
		int age = jumin.getAge();
		String tti = jumin.getTti();
		String gender = jumin.getGender();
		String season = jumin.getSeason();
		String location = jumin.getLocal();

		response.setContentType("text/html; charset=utf-8;");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head><title>���</title>");
		out.println("<style type='text/css'> table { width: 300px; border: 1px solid black; border-collapse: collapse;}"
				+ "th { text-align: center; border: 1px solid black; }"
				+ "td { text-align: left; border: 1px solid black; }</style>");
		out.println(
				"  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n"
						+ "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n"
						+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div style='width: 300px;'>");
		out.println("<table class='table table-striped'>");

		out.println("<tr>");
		out.println("<th>");
		out.println("�ֹι�ȣ");
		out.println("</th>");
		out.println("<td>");
		out.println(jumin_no);
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("����⵵");
		out.println("</th>");
		out.println("<td>");
		out.println(year + "��");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("����");
		out.println("</th>");
		out.println("<td>");
		out.println(age + "��");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("����");
		out.println("</th>");
		out.println("<td>");
		out.println(gender);
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("��");
		out.println("</th>");
		out.println("<td>");
		out.println(tti + "��");
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("�������");
		out.println("</th>");
		out.println("<td>");
		out.println(season);
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th>");
		out.println("�������");
		out.println("</th>");
		out.println("<td>");
		out.println(location);
		out.println("</td>");
		out.println("</tr>");

		out.println("<tr>");
		out.println("<th colspan='2'>");
		out.println("<a href='jumin.html'>�ٽ��ϱ�</a>");
		out.println("</th>");
		out.println("</tr>");

		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

}