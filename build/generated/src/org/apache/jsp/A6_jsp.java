package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class A6_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>A5</title>\n");
      out.write("         <script src=\"displayReport.js\"></script>\n");
      out.write("         <script src=\"login.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1>A5</h1>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"nav\">\n");
      out.write("            <UL>\n");
      out.write("                <li>User <input id=\"user\" name=\"User\" type=\"text\"> </li>\n");
      out.write("                <li>Password <input id=\"password\" name=\"Password\" type=\"password\"></li>\n");
      out.write("                <li><button type=\"button\" onclick=\"login()\">Login</button> </li>\n");
      out.write("                <li>navigation</ii>\n");
      out.write("                <li><button type=\"button\" onclick=\"loadReport()\">Report</button> </li>\n");
      out.write("                \n");
      out.write("                <li>\n");
      out.write("                    <form name=\"inputform\" action=\"somewhere\" method=\"post\">\n");
      out.write("    <input type=\"hidden\" value=\"person\" name=\"user\">\n");
      out.write("    <input type=\"hidden\" value=\"password\" name=\"pwd\">\n");
      out.write("    <input type=\"hidden\" value=\"place\" name=\"organization\">\n");
      out.write("    <input type=\"hidden\" value=\"key\" name=\"requiredkey\">\n");
      out.write("</form>\n");
      out.write("                </li>\n");
      out.write("            </UL>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"report\">\n");
      out.write("                <h1>reports</h1>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
