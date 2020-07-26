package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDao;
import vo.DeptVo;

/**
 * Servlet implementation class DeptListAction
 */
@WebServlet("/dept_list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(
			HttpServletRequest  request, //��ûó����ü 
			HttpServletResponse response //����ó����ü
			) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�μ���� ��������
		List<DeptVo> list = DeptDao.getInstance().selectList();
		
		System.out.println(list.size());
		
		//����ó��...
		response.setContentType("text/html; charset=utf-8;");
		
		//HTML  ����
		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<head><title>�μ����</title></head>");
		html.append("<body>");
		html.append("<table border='1'>");
		
		/* table title */
		html.append("<tr>");
		html.append("<th>�μ���ȣ</th><th>�μ���</th><th>��ġ</th>");
		html.append("</tr>");
		
		/* table data */
		
		for(int i=0;i<list.size();i++) {
		   DeptVo vo = list.get(i);	

		//for(DeptVo vo: list) {
			html.append("<tr>");
				//1ĭ
				html.append("<td>");
				html.append(vo.getDeptno());
				html.append("</td>");
				
				//2ĭ
				html.append("<td>");
				html.append(vo.getDname());
				html.append("</td>");
				
				//3ĭ
				html.append("<td>");
				html.append(vo.getLoc());
				html.append("</td>");
			html.append("</tr>");
		}
		
		html.append("</table>");
		html.append("</body>");
		html.append("</html>");
		
		//����(����)
		response.getWriter().print(html.toString());
					
		
	}

}






