/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-06-28 04:28:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write(" <head>\r\n");
      out.write(" <title>myJSP</title>\r\n");
      out.write(" </head>\r\n");
      out.write(" <body>\r\n");
      out.write("\t<form action=\"/api/user/register\" method=\"post\">\r\n");
      out.write("\t\t<h1>注册</h1>\r\n");
      out.write("\t\t手机号码<input type=\"text\" name=\"phone\"/>\r\n");
      out.write("\t\t密码<input type=\"text\" name=\"password\"/>\r\n");
      out.write("\t\t验证码<input type=\"text\" name=\"code\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/user/getVerifyCode\" method=\"post\">\r\n");
      out.write("\t\t<h1>获取验证码</h1>\r\n");
      out.write("\t\t手机号码<input type=\"text\" name=\"phone\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/user/noteLogin\" method=\"post\">\r\n");
      out.write("\t \t<h1>短信登录</h1>\r\n");
      out.write("\t\t手机号码<input type=\"text\" name=\"phone\"/>\r\n");
      out.write("\t\t验证码<input type=\"text\" name=\"code\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/user/pwdLogin\" method=\"post\">\r\n");
      out.write("\t\t<h1>密码登录</h1>\r\n");
      out.write("\t\t手机号码<input type=\"text\" name=\"phone\"/>\r\n");
      out.write("\t\t密码<input type=\"text\" name=\"password\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/user/forgetPwd\" method=\"post\">\r\n");
      out.write("\t \t<h1>忘记密码</h1>\r\n");
      out.write("\t\t手机号码<input type=\"text\" name=\"phone\"/>\r\n");
      out.write("\t\t验证码<input type=\"text\" name=\"code\"/>\r\n");
      out.write("\t\t密码<input type=\"text\" name=\"password\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/user/reLogin\" method=\"post\">\r\n");
      out.write("\t \t<h1>退出登录</h1>\r\n");
      out.write("\t\t<input type=\"text\" name=\"token\"/>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/item/queryItemSearch\" method=\"post\">\r\n");
      out.write("\t \t<h1>查询商品</h1>\r\n");
      out.write("\t\t一级分类<input type=\"text\" name=\"oneClassify\"/><br>\r\n");
      out.write("\t\t二级分类<input type=\"text\" name=\"twoClassify\"/><br>\r\n");
      out.write("\t\t三级分类<input type=\"text\" name=\"threeClassify\"/><br>\r\n");
      out.write("\t\t商品品牌名称<input type=\"text\" name=\"itemBrandName\"/><br>\r\n");
      out.write("\t\t查询规则<input type=\"text\" name=\"rule\"/><br>\r\n");
      out.write("\t\t当前页<input type=\"text\" name=\"currentPage\"/><br>\r\n");
      out.write("\t\t每页记录条数<input type=\"text\" name=\"numberPerPage\"/><br>\r\n");
      out.write("\t\t<input type=\"submit\" value=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/item/itemSearch\" method=\"post\">\r\n");
      out.write("\t    <h1>首页查询</h1>\r\n");
      out.write("\t\t<input type=\"text\" name=\"keyWord\"/>\r\n");
      out.write("\t\t<input type=\"text\" name=\"currentPage\"/>\r\n");
      out.write("\t\t<input type=\"text\" name=\"numberPerPage\"/>\r\n");
      out.write("\t\t<input type=\"submit\" name=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<form action=\"/api/item/brandItemList\" method=\"post\">\r\n");
      out.write("\t    <h1>品牌查询</h1>\r\n");
      out.write("\t\t<input type=\"text\" name=\"itemBrandId\"/>\r\n");
      out.write("\t\t<input type=\"text\" name=\"rule\"/>\r\n");
      out.write("\t\t<input type=\"text\" name=\"currentPage\"/>\r\n");
      out.write("\t\t<input type=\"text\" name=\"numberPerPage\"/>\r\n");
      out.write("\t\t<input type=\"submit\" name=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t文件上传\r\n");
      out.write("<form method=\"post\" action=\"/api/file/qiniuUploadTest\" enctype=\"multipart/form-data\">\r\n");
      out.write("    <input name=\"file\" type=\"file\" />\r\n");
      out.write("\t<input value=\"提交\" type=\"submit\" />\r\n");
      out.write("</form>\r\n");
      out.write("<form method=\"post\" action=\"/api/item/itemDetailDes\" enctype=\"multipart/form-data\">\r\n");
      out.write("    <input name=\"itemId\" type=\"text\" />\r\n");
      out.write("    <input name=\"token\" type=\"text\" />\r\n");
      out.write("\t<input value=\"提交\" type=\"submit\" />\r\n");
      out.write("</form>\r\n");
      out.write("<!-- 查询商品列表 -->\r\n");
      out.write("<form action=\"/api/item/itemInfoList\" method=\"post\">\r\n");
      out.write("\t    <h1>商品查询</h1>\r\n");
      out.write("\t\t商品id<input type=\"text\" name=\"itemId\"/>\r\n");
      out.write("\t\t商品名称<input type=\"text\" name=\"itemName\"/>\r\n");
      out.write("\t\t商品分类<input type=\"text\" name=\"itemClassify\"/>\r\n");
      out.write("\t\t商品品牌名字<input type=\"text\" name=\"itemBrandName\"/>\r\n");
      out.write("\t\t状态<input type=\"text\" name=\"state\"/>\r\n");
      out.write("\t\t<input type=\"submit\" name=\"提交\"/>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write(" </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
