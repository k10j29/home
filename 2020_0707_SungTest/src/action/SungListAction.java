package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SungTBDao;
import vo.SungVo;

/**
 * Servlet implementation class SungListActioOn
 */
@WebServlet("/sung/list.do")
public class SungListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 2. ���� ��� �������� (��ġ�߿�)
		List<SungVo> list = SungTBDao.getInstance().selectList();

		// 3. Request binding (������� �ϰ� ����� 404����)
		request.setAttribute("list", list);

		// 1. Dispatcher (forward) Templet
		String forward_page = "sung_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

		// 4. sung ���� ���� JSP ������ֱ�

		// 5. Data �� ������� (JSP)

		// 6. Data �� �ִ°�� (JSP)

		// 7. �������� ��ư �ֱ�

		// 8. ���� ����ϱ� (����)

		// 9. �Է��� ����� (sung_insert_form.jsp)

	}

}