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
@WebServlet("/calc.do")
public class HelloAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ip = request.getRemoteAddr();

		int su1 = Integer.parseInt(request.getParameter("su1"));
		int su2 = Integer.parseInt(request.getParameter("su2"));
		int plus_res = su1 + su2;
		int minus_res = su1 - su2;
		int multi_res = su1 * su2;
		int mini_res = su1 / su2;

		// 전송 해야할 내용의 정보 설정
		response.setContentType("text/html; charset=utf-8;");
		// 응답시 이용할 문자 스트림
		PrintWriter out = response.getWriter();

		// 응답 정보는 html 로 전송
		out.println("<html>");
		out.println("<head><title>계산기</title></head>");
		out.println("<body><center>");
		out.println("<h2> || 계산결과 || </h2>");
		out.println("<hr>");
		out.printf("%d+%d=[%d]<br>", su1, su2, plus_res);
		out.printf("%d-%d=[%d]<br>", su1, su2, minus_res);
		out.printf("%d*%d=[%d]<br>", su1, su2, multi_res);
		out.printf("%d/%d=[%d]<br>", su1, su2, mini_res);
		out.println("<a href='calc.html'>다시하기</a>");
		out.println("</body></html>");

	}
}
