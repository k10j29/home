package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/dept/list.do")
public class DeptListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, // ��ûó����ü
			HttpServletResponse response // ����ó����ü
	) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// �μ���� ��������
		List<DeptVo> list = DeptDao.getInstance().selectList();

		// request binding
		request.setAttribute("list", list);

		// /dept/list.do <=���� ����� : /dept/
		// Dispatcher(forward)
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");
		disp.forward(request, response);

	}

}
