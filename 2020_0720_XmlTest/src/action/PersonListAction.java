package action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import vo.PersonVo;

/**
 * Servlet implementation class PersonListAction
 */
@WebServlet("/person/list.do")
public class PersonListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 1 XML Parser
		SAXBuilder builder = new SAXBuilder();

		// ������ ����
		String path = request.getServletContext().getRealPath("/");

		File f = new File(path, "person.xml");

		// �� ����Ʈ ������ֱ�
		List<PersonVo> list = new ArrayList<PersonVo>();

		// 2 jdom ���ִ� ��ü Document ����
		// XML �� Document ���Ѱ�
		try {
			Document doc = builder.build(f);

			// Root Element ���ϱ�
			Element root = doc.getRootElement();

			// Root �� �ڽ� ��� ��� ������
			List<Element> element_list = root.getChildren("person");

			// ���� for ��

			for (Element person : element_list) {
				// String name = person.getChildText("name");
				Element name_elElement = person.getChild("name");

				String name = name_elElement.getText();
				// �Ӽ� �о����
				String nickname = name_elElement.getAttributeValue("nickname");
				int age = Integer.parseInt(person.getChildText("age"));
				String tel = person.getChildText("tel");
				String hometel = person.getChild("tel").getAttributeValue("hometel");
				
				
				//Vo �����ϱ�
				PersonVo p = new PersonVo(name, nickname, age, tel, hometel);
				//Arraylist ���߰��ϱ�
				list.add(p);
			}

		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("list", list);

		// Dispatcher (forward)
		String forward_page = "person_list.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);

	}

}
