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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request,  //��ûó����ü
			HttpServletResponse response  //����ó����ü
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ip = request.getRemoteAddr();
		//System.out.printf("--[%s] HelloAction : WebModule 3.x Call--\n",ip);
		
		// ��û URL => query������ ���ؼ� parameter�� ����
		// http://192.168.7.206:9090/2020_0629_ServletEx1_30
		//                          /hello.do?nation=kor
		//                          /hello.do          <= null   
		//                          /hello.do?nation=  <= ""
		
		
		//                                  parameter��  
		String nation = request.getParameter("nation");
		//���������� �Ķ���� ó��
		if(nation==null || nation.isEmpty()) {
			nation="kor";
		}
		
		
		
		String greet_message = "";
		
		//nation=kor  nation=eng  nation=jpn nation=chn nation=ger
		if(nation.equals("kor")) {
			greet_message = String.format("[�ѱ���(%s)] : �ȳ��ϼ���", nation);
		}else if(nation.equals("eng")) {
			greet_message = String.format("[����(%s)] : Hi~~", nation);
		}else if(nation.equals("jpn")) {
			greet_message = String.format("[�Ϻ���(%s)] : ���۳�������", nation);
		}else if(nation.equals("chn")) {
			greet_message = String.format("[�߱���(%s)] : ���Ͽ�", nation);
		}else if(nation.equals("ger")) {
			greet_message = String.format("[���Ͼ�(%s)] : ����Ź", nation);
		}else {
			greet_message = String.format("[����(%s)] : ����?", nation);
		}
				
		
		//����ó��
		//�����ؾߵ� ���뿡 ���� ���� ����
		response.setContentType("text/html; charset=utf-8;");
		
		//����� �̿��� ���ڽ�Ʈ��
		PrintWriter out = response.getWriter();
		//���������� HTML�� ���� 
		out.println("<html>");
		out.println("<head><title>ȯ���մϴ�</title></head>");
		out.println("<body>");
		
		out.printf("[%s]�� ȯ���մϴ�<br>",ip);
		//out.println("���� ���ְ� �弼��...");
		out.println(greet_message);
		
		
		
		out.println("</body>");
		out.println("</html>");
		
	}

}





