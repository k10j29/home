/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.56
 * Generated at: 2020-07-13 14:15:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class member_005finsert_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap Library  -->\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 주소 검색 라이브러리 (자바스크립스) -->\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("#input_box {\r\n");
      out.write("\twidth: 600px;\r\n");
      out.write("\tmargin: auto;\r\n");
      out.write("\tmargin-top: 100px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t//ID 에 대한 정규식\r\n");
      out.write("\tvar regular_id = /^[a-zA-Z0-9]{4,8}$/;\r\n");
      out.write("\r\n");
      out.write("\t/* jQuery초기화 */\r\n");
      out.write("\t$(document).ready(function() {\r\n");
      out.write("\t\t/* 중복체크가 눌리면 */\r\n");
      out.write("\t\t$(\"#btn_check_id\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar m_id = $(\"#m_id\").val();\r\n");
      out.write("\t\t\t//ID체크\r\n");
      out.write("\t\t\tif (regular_id.test(m_id) == false) {\r\n");
      out.write("\t\t\t\talert('4~8자리 영문자(대,소)숫자조합으로 작성하세요');\r\n");
      out.write("\t\t\t\t$(\"#m_id\").val(\"\");//값비우기\r\n");
      out.write("\t\t\t\t$(\"#m_id\").focus();//포커스\r\n");
      out.write("\t\t\t\treturn;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t//Ajax을 이용한 id 체크\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"check_id.do\", //MemberCheckIdAction\r\n");
      out.write("\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\"m_id\" : m_id\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\tdataType : \"json\", //수신데이터 타입\r\n");
      out.write("\t\t\t\tsuccess : function(res_data) {\r\n");
      out.write("\t\t\t\t\t//res_data ={\"result\": true}\r\n");
      out.write("\t\t\t\t\tif (res_data.result == false) {\r\n");
      out.write("\t\t\t\t\t\talert('이미 사용중인 아이디 입니다');\r\n");
      out.write("\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\talert('사용가능한 아이디 입니다');\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t//1. 아이디 편집못하도록\r\n");
      out.write("\t\t\t\t\t// <input id=\"m_id\"\r\n");
      out.write("\t\t\t\t\t$(\"#m_id\").attr(\"readonly\", true);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t//2. 회원가입 버튼 활성화 (비활성화의 반대)\r\n");
      out.write("\t\t\t\t\t$(\"#btn_register\").attr(\"disabled\", false);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t}); //중복체크 클릭 끝나는 부분 \r\n");
      out.write("\r\n");
      out.write("\t\t//주소검색 클릭\r\n");
      out.write("\t\t$(\"#btn_find_addr\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tnew daum.Postcode({\r\n");
      out.write("\t\t\t\ttheme : {\r\n");
      out.write("\t\t\t\t\tbgColor : \"#FBEC4B\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\toncomplete : function(data) {\r\n");
      out.write("\t\t\t\t\t// data = {'zonecode':12345 ,'address':'서울시 관악구',...}\r\n");
      out.write("\t\t\t\t\t//alert('우편번호:' + data.zonecode);\r\n");
      out.write("\t\t\t\t\t//alert('주소:' + data.address);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t$(\"#m_zipcode\").val(data.zonecode);\r\n");
      out.write("\t\t\t\t\t$(\"#m_addr\").val(data.address);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}).open();\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t}); //document.ready 끝부분\r\n");
      out.write("\r\n");
      out.write("\tfunction send(f) {\r\n");
      out.write("\r\n");
      out.write("\t\tvar m_name = f.m_name.value.trim();\r\n");
      out.write("\t\tvar m_pwd = f.m_pwd.value.trim();\r\n");
      out.write("\t\tvar m_zipcode = f.m_zipcode.value.trim();\r\n");
      out.write("\t\tvar m_addr = f.m_addr.value.trim();\r\n");
      out.write("\r\n");
      out.write("\t\t//이름체크\r\n");
      out.write("\t\tif (m_name == '') {\r\n");
      out.write("\t\t\talert('이름을 입력하세요');\r\n");
      out.write("\t\t\tf.m_name.value = '';\r\n");
      out.write("\t\t\tf.m_name.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//비번체크\r\n");
      out.write("\t\tif (m_pwd == '') {\r\n");
      out.write("\t\t\talert('비밀번호를 입력하세요');\r\n");
      out.write("\t\t\tf.m_pwd.value = '';\r\n");
      out.write("\t\t\tf.m_pwd.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//우편번호 체크\r\n");
      out.write("\t\tif (m_zipcode == '') {\r\n");
      out.write("\t\t\talert('우편번호를 입력하세요');\r\n");
      out.write("\t\t\tf.m_zipcode.value = '';\r\n");
      out.write("\t\t\tf.m_zipcode.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//주소 체크\r\n");
      out.write("\t\tif (m_addr == '') {\r\n");
      out.write("\t\t\talert('주소를 입력하세요');\r\n");
      out.write("\t\t\tf.m_addr.value = '';\r\n");
      out.write("\t\t\tf.m_addr.focus();\r\n");
      out.write("\t\t\treturn;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t//전송\r\n");
      out.write("\t\tf.action = \"insert.do\"; //MemberInsertAction\r\n");
      out.write("\r\n");
      out.write("\t\tf.submit();\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"input_box\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"panel panel-danger\">\r\n");
      out.write("\t\t\t<div class=\"panel-heading\">회원가입</div>\r\n");
      out.write("\t\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t\t<form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- 회원 구분  -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"m_grade\" value=\"일반\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<table class=\"table table-striped\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>이름</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"m_name\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>아이디</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"m_id\" id=\"m_id\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"button\" value=\"중복체크\" id=\"btn_check_id\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>비밀번호</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"password\" name=\"m_pwd\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>우편번호</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"m_zipcode\" id=\"m_zipcode\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\ttype=\"button\" value=\"주소검색\" id=\"btn_find_addr\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>주소</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input name=\"m_addr\" id=\"m_addr\" size=\"50\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- 나중에 수정할때 넣어주면 사용하면됩니다 -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<!-- \t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<th>등급</th>\r\n");
      out.write("\t\t\t\t\t\t\t<td><input type=\"radio\" name=\"m_grade\" value=\"일반\"\r\n");
      out.write("\t\t\t\t\t\t\t\tchecked=\"checked\">일반 <input type=\"radio\" name=\"m_grade\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"관리자\">관리자\r\n");
      out.write("\t\t\t\t\t\t</tr> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" align=\"center\"><input id=\"btn_register\"\r\n");
      out.write("\t\t\t\t\t\t\t\tdisabled=\"disabled\" type=\"button\" value=\"회원가입\"\r\n");
      out.write("\t\t\t\t\t\t\t\tonclick=\"send(this.form);\"> <input type=\"button\"\r\n");
      out.write("\t\t\t\t\t\t\t\tvalue=\"목록보기\" onclick=\"location.href='list.do'\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}