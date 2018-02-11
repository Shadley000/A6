package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>A6 Alarm Manager</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"styles.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"javascript/navcontrol.js\"> </script>\n");
      out.write("        <script src=\"javascript/pivot.js\"> </script>\n");
      out.write("        <script src=\"javascript/alarmHistory.js\"> </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div id=\"div_header\"><h1>A6 Alarm Manager</h1>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"div_nav\"><h2>Navigation</h2>\n");
      out.write("            <ul id=\"loggedout\">\n");
      out.write("                <li >User <input type='text' id ='user' value='guest' /></li>\n");
      out.write("                <li >Password<input type='password' id ='password' value='password' /></li>\n");
      out.write("                <li ><button id='button_login'>Login</button></li>\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("            <ul id=\"loggedin\" hidden>\n");
      out.write("                <li >Installation <SELECT name='installation' id='select_installation'></SELECT></li>\n");
      out.write("                <DIV id='reportButtons' hidden>\n");
      out.write("                <li ><button id='button_AlarmPivotPage' >Pivot Table</button></li>\n");
      out.write("                <li ><button id='button_AlarmHistoryPage' >Alarm History</button></li>\n");
      out.write("                </DIV>\n");
      out.write("                <li ><button id='button_logout' >Logout</button></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"div_report\"><h2>Report Section</h2></div>\n");
      out.write("        <div id=\"div_footer\"><P>footer</p></div>\n");
      out.write("        <div id=\"div_hidden\" hidden></div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
