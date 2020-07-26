package action.photo;

import java.io.File;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.PhotoDao;
import vo.MemberVo;
import vo.PhotoVo;

/**
 * Servlet implementation class PhotoInsertAction
 */
@WebServlet("/photo/insert.do")
public class PhotoInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// /photo/insert.do?p_title=aaa&p_content=bbb&p_photo=a.jpg

		// ���ε�� ȭ���� ������ġ
		String web_path = "/upload/";// �����
		// �����->������ ��ȯ
		ServletContext application = request.getServletContext();
		String abs_path = application.getRealPath(web_path);

		// ���ε�� ȭ���� ũ������(����: byte)
		int max_size = 1024 * 1024 * 100; // 100MB

		// ��ü���� -> ���ε尡 �Ϸ�
		MultipartRequest mr = new MultipartRequest(request, abs_path, // ������ġ
				max_size, // ����(�ִ�)ũ��
				"utf-8", // �������ڵ�
				new DefaultFileRenamePolicy());
		// ���ε�� ȭ���̸� ������
		String p_filename = "no_file";
		File f = mr.getFile("p_photo");// form parame : <input type="file" name="p_photo">
		if (f != null) {
			p_filename = f.getName();
		}

		// �Ϲ� parameter�ޱ�
		String p_title = mr.getParameter("p_title");
		String p_content = mr.getParameter("p_content");

		// p_content = "A\r\nB\rnC" => "A\r<br>B\r<br>C"

		p_content = p_content.replaceAll("\r\n", "<br>");

		// IP���ϱ�
		String p_ip = request.getRemoteAddr();

		// �α��� ����� ���� ���ϱ�
		HttpSession session = request.getSession();
		// ���ǿ� ����� �������� ���ϱ�
		MemberVo user = (MemberVo) session.getAttribute("user");

		int m_idx = user.getM_idx();

		// ������ ����
		PhotoVo vo = new PhotoVo(p_title, p_content, p_filename, p_ip, m_idx);

		// DB Insert
		int res = PhotoDao.getInstance().insert(vo);

		// ��Ϻ���
		response.sendRedirect("list.do");

	}

}
