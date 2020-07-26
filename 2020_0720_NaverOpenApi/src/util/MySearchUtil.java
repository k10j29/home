package util;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import vo.BookVo;

public class MySearchUtil {

	public static List<BookVo> search_book(String book_name, int start, int display) {
		List<BookVo> list = new ArrayList<BookVo>();

		String clientId = "MF3Z91EEmV3wFAyXcUUP";
		String clientSecret = "as3HKQFO7L";

		try {
			book_name = URLEncoder.encode(book_name, "utf-8");
			String urlStr = String.format("https://openapi.naver.com/v1/search/book.xml?query=%s&start=%d&display=%d",
					book_name, start, display);

			URL url = new URL(urlStr);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			// �߱޹��� ID
			connection.setRequestProperty("X-Naver-Client-Id", clientId);
			// �߱޹��� PW
			connection.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			// ������ûŸ��
			connection.setRequestProperty("Content-Type", "application/xml");
			connection.connect();

			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(connection.getInputStream());

			Element root = doc.getRootElement();// rss
			List<Element> element_list = (List<Element>) root.getChild("channel").getChildren("item");

			for (Element item : element_list) {

				String title = item.getChildText("title");
				String link = item.getChildText("link");
				String image = item.getChildText("image");
				String author = item.getChildText("author");

				int price = 0;
				int discount = 0;

				try {
					price = Integer.parseInt(item.getChildText("price"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				try {
					discount = Integer.parseInt(item.getChildText("discount"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				String publisher = item.getChildText("publisher");
				String pubdate = item.getChildText("pubdate");
				String description = item.getChildText("description");

				BookVo vo = new BookVo(title, link, image, author, price, discount, publisher, pubdate, description);
				// ArrayList�� �ֱ�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
