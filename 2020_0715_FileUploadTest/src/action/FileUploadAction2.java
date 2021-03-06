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
		// mulitpartRequest 研 戚遂背辞 parameter 呪重聖 背醤敗 (嬢巨赤劃檎 lib cos package 拭 赤製)
		// 層搾紫牌
		// 1// upload (煽舌吃 井稽) 竺舛 c:\\upload folder drive

		// String path = "c:\\upload";

		String web_path = "/upload2/";

		// Web 井稽 (雌企井稽) => 箭企井稽 郊蝦呪 赤澗奄管
		// 薄仙 戚 request 亜 紫遂馬壱赤澗 辞崎鹸 珍努什闘 姥馬奄

		ServletContext application = request.getServletContext();
		String path = application.getRealPath(web_path);

		System.out.println(path);

		// 2// 置企 煽舌 滴奄 竺舛
		int max_size = 1024 * 1024 * 100; // 100MB

		// request 閤製
		// path 煽舌 是帖
		// max_size 置企滴奄
		// utf-8 呪重 昔坪漁
		// new DefaultFileRenamePolicy() (気嬢床奄x) 督析 戚硯 掻差獣 戚硯痕井

		// けけけけけけけけけけけけ 梓端 持失引 疑獣拭 ==> 督析穣稽球 刃戟 (督析穣稽球 獣佃層蕉)
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		// けけけけけけけけけけけけ 叔薦 穣稽球吉 督析舛左 姥馬奄 穣稽球櫛 疑析背醤敗 (photo 稽 級嬢紳蕉 (parameter 戚硯生稽))

		// mr.getOriginalFileName("photo"); //坦製拭 臣鍵 置段戚硯 悦汽 郊餓檎? 焼掘 遭楳

		String filename = "no file";
		String filename2 = "no file";
		String filename3 = "no file";

		File f = mr.getFile("photo");
		if (f != null) { // if f亜 null 戚 焼艦檎
			filename = f.getName(); // 置曽生稽 痕井吉 督析 戚硯聖 姥廃陥. 神軒走確 督析戚硯戚 焼艦虞 new DefaultFileRenamePolicy()); 鞠嬢辞 痕井吉
									// 戚硯税 督析
		}

		File f2 = mr.getFile("photo2");
		if (f2 != null) { // if f亜 null 戚 焼艦檎
			filename2 = f2.getName(); // 置曽生稽 痕井吉 督析 戚硯聖 姥廃陥. 神軒走確 督析戚硯戚 焼艦虞 new DefaultFileRenamePolicy()); 鞠嬢辞 痕井吉
										// 戚硯税 督析
		}

		File f3 = mr.getFile("photo3");
		if (f3 != null) { // if f亜 null 戚 焼艦檎
			filename3 = f3.getName(); // 置曽生稽 痕井吉 督析 戚硯聖 姥廃陥. 神軒走確 督析戚硯戚 焼艦虞 new DefaultFileRenamePolicy()); 鞠嬢辞 痕井吉
										// 戚硯税 督析
		}

		// Title 閤焼爽奄

		// String title = request.getParameter("title");

		// requset 澗 戚耕 photo 拭辞 是績梅奄凶庚拭 紫遂馬走省製
		// 益掘辞 mr 拭辞 閤焼操醤敗

		String title = mr.getParameter("title");

		// IP 閤焼爽奄
		// IP 澗 督虞五展亜 焼艦奄凶庚拭 request 紫遂亜管

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
