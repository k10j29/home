package action.photo;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PhotoDao;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/delete.do")
public class PhotoDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int p_idx = Integer.parseInt(request.getParameter("p_idx"));

		// p_idx�� �ش�Ǵ� �Խù� 1��
		// ��? : ������ ȭ�ϸ� �˾Ƴ��� ����
		PhotoVo vo = PhotoDao.getInstance().selectOne(p_idx);

		// ���ε�� ȭ���� ������ġ
		String web_path = "/upload/";// �����
		// �����->������ ��ȯ
		ServletContext application = request.getServletContext();
		String abs_path = application.getRealPath(web_path);

		// ������ ȭ������ ���ϱ�
		File f = new File(abs_path, vo.getP_filename());
		f.delete();

		// DB delete
		int res = PhotoDao.getInstance().delete(p_idx);

		// ��Ϻ���
		response.sendRedirect("list.do");

	}

}
