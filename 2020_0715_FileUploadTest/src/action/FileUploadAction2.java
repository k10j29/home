package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class FileUploadAction
 */
@WebServlet("/upload2.do")
public class FileUploadAction2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// /upload.do?title=19TED&photo=a.jpg
		// mulitpartRequest �� �̿��ؼ� parameter ������ �ؾ��� (����ֳĸ� lib cos package �� ����)
		// �غ����
		// 1// upload (����� ���) ���� c:\\upload folder drive

		// String path = "c:\\upload";

		String web_path = "/upload2/";

		// Web ��� (�����) => ������ �ٲܼ� �ִ±��
		// ���� �� request �� ����ϰ��ִ� ���긴 ���ؽ�Ʈ ���ϱ�

		ServletContext application = request.getServletContext();
		String path = application.getRealPath(web_path);

		System.out.println(path);

		// 2// �ִ� ���� ũ�� ����
		int max_size = 1024 * 1024 * 100; // 100MB

		// request ����
		// path ���� ��ġ
		// max_size �ִ�ũ��
		// utf-8 ���� ���ڵ�
		// new DefaultFileRenamePolicy() (�����x) ���� �̸� �ߺ��� �̸�����

		// ������������������������ ��ü ������ ���ÿ� ==> ���Ͼ��ε� �Ϸ� (���Ͼ��ε� �����ؾ�)
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		// ������������������������ ���� ���ε�� �������� ���ϱ� ���ε�� �����ؾ��� (photo �� ���¾� (parameter �̸�����))

		// mr.getOriginalFileName("photo"); //ó���� �ø� �����̸� �ٵ� �ٲ��? �Ʒ� ����

		String filename = "no file";
		String filename2 = "no file";
		String filename3 = "no file";

		File f = mr.getFile("photo");
		if (f != null) { // if f�� null �� �ƴϸ�
			filename = f.getName(); // �������� ����� ���� �̸��� ���Ѵ�. �������� �����̸��� �ƴ϶� new DefaultFileRenamePolicy()); �Ǿ �����
									// �̸��� ����
		}

		File f2 = mr.getFile("photo2");
		if (f2 != null) { // if f�� null �� �ƴϸ�
			filename2 = f2.getName(); // �������� ����� ���� �̸��� ���Ѵ�. �������� �����̸��� �ƴ϶� new DefaultFileRenamePolicy()); �Ǿ �����
										// �̸��� ����
		}

		File f3 = mr.getFile("photo3");
		if (f3 != null) { // if f�� null �� �ƴϸ�
			filename3 = f3.getName(); // �������� ����� ���� �̸��� ���Ѵ�. �������� �����̸��� �ƴ϶� new DefaultFileRenamePolicy()); �Ǿ �����
										// �̸��� ����
		}

		// Title �޾��ֱ�

		// String title = request.getParameter("title");

		// requset �� �̹� photo ���� �����߱⶧���� �����������
		// �׷��� mr ���� �޾������

		String title = mr.getParameter("title");

		// IP �޾��ֱ�
		// IP �� �Ķ��Ÿ�� �ƴϱ⶧���� request ��밡��

		String ip = request.getRemoteAddr();

		// request binding
		request.setAttribute("title", title);
		request.setAttribute("filename", filename); // image file
		request.setAttribute("filename2", filename2); // image file
		request.setAttribute("filename3", filename3); // image file
		request.setAttribute("ip", ip);

		// Dispatcher (forward)
		String forward_page = "result2.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

	}

}
