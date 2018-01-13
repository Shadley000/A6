/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shadley000.a6.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 *
 * @author shadl
 */
@WebServlet(name = "RestServlet", urlPatterns = {"/RestServlet"})
public class RestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(200);//ok
        //response.setStatus(201);//created
        //response.setStatus(204);//no content
        //response.setStatus(300);//redirection
        //response.setStatus(304);//not modified
        //  response.setStatus(400);//Bad request
        //   response.setStatus(401);//unauthorized
        // response.setStatus(403);//forbidden
        // response.setStatus(404);// not found
        // response.setStatus(415);// unsupported media type
        // response.setStatus(500);//internal server error
        
        
         JSONObject result = new JSONObject();
        result.put("servlettest", "dummyvalue");
        for(Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();)
        {   String parameterName = e.nextElement();
            String value = request.getParameter(parameterName);
            result.put(parameterName, value);
        }
        
        result.put("getMethod", request.getMethod());
        result.put("getPathInfo", request.getPathInfo() );
        
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
           
            result.write(out);
           // response.flushBuffer();
        }
        
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         response.setStatus(200);//ok
       // response.setStatus(400);//Bad request
       // response.setStatus(415);// unsupported media type
       // response.setStatus(500);//internal server error
        
        processRequest(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setStatus(204);//no content
        // response.setStatus(404);// not found
        // response.setStatus(500);//internal server error
      processRequest(request, response);
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //response.setStatus(200);//ok
        // response.setStatus(404);// not found
        // response.setStatus(500);//internal server error
        
        
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       // response.setStatus(201);//ok created
       // response.setStatus(400);//Bad request
       // response.setStatus(415);// unsupported media type
       // response.setStatus(500);//internal server error
       
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "REST Testing";
    }// </editor-fold>

}
