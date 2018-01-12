/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(urlPatterns = {"/A6Servlet"})
public class A6Servlet extends HttpServlet {

    public static boolean debug = false;
    public static String KEY_SESSIONBEAN = "sessionbean";
    public static String KEY_AUTHENTICATED = "a6athentication";
    public static String KEY_USER = "user";
    public static String KEY_PASSWORD = "password";

    public static String KEY_REPORTNAME = "reportname";
    public static String KEY_STARTDATE = "startdate";
    public static String KEY_ENDDATE = "enddate";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        UserSessionBean userSessionBean = (UserSessionBean) session.getAttribute(KEY_SESSIONBEAN);

        if (userSessionBean == null) {
            userSessionBean = new UserSessionBean();
            request.getSession().setAttribute(KEY_SESSIONBEAN, userSessionBean);
        }
        JSONObject result = new JSONObject();
        
        if (!userSessionBean.isAuthenticated()) {

            String user = request.getParameter(KEY_USER);
            String password = request.getParameter(KEY_PASSWORD);
            userSessionBean.setUserName(user);
            userSessionBean.setPassword(password);

            if (user != null && password != null && user.equals("guest") && password.equals("password")) {
                userSessionBean.setAuthenticated(true);
            }
            result.put(KEY_USER, userSessionBean.getUserName());
            //result.put(KEY_PASSWORD, userSessionBean.getPassword());
            result.put(KEY_AUTHENTICATED, userSessionBean.isAuthenticated());

        } else {
            String reportName = request.getParameter(KEY_REPORTNAME);
            String startDate = request.getParameter(KEY_STARTDATE);
            String endDate = request.getParameter(KEY_ENDDATE);

            if(reportName.equals("logout"))
                userSessionBean.setAuthenticated(false);
            result.put(KEY_AUTHENTICATED, userSessionBean.isAuthenticated());
            result.put(KEY_REPORTNAME, reportName);
            result.put(KEY_STARTDATE, startDate);
            result.put(KEY_ENDDATE, endDate);

        }
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
             result.write(out);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
