package com.DemoLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    Connection connexion = null;
    String user = null;
    String pass = null;
    
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/
    
    public void init(){
        System.out.println("------------------------------------");
        System.out.println("init method has been called and servlet is initilaized");
        System.out.println("------------------------------------");
        String url = "jdbc:mysql://127.0.0.1:3306/bd";
        String name = "root";
        String pwd = "";
        String driver = "com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            connexion = DriverManager.getConnection(url, name, pwd);
            
        }catch(Exception e){
            System.out.println("Error while loadingthe database..");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = request.getParameter("msg");
        response.setContentType("text/html; charset=UTF-8");
                try (PrintWriter out = response.getWriter()){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println(msg);
                    out.println("</body>");
                    out.println("</html>");
                }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            user = request.getParameter("name");
            pass = request.getParameter("pass");
            String q = "select * from user where username = '" + user + "'";
            Statement commande = connexion.createStatement();
            ResultSet rs = commande.executeQuery(q);
            String username = "null";
            String password = "null";
            while(rs.next()){
                username = rs.getString(2);
                password = rs.getString(3);
            }
            if(username.equals(user) && password.equals(pass)){
                System.out.println("Login Successful!");             
                response.setContentType("text/html; charset=UTF-8");
                try (PrintWriter out = response.getWriter()){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Login Successful: <b>" + user + "</b> is now connected");
                    out.println("</body>");
                    out.println("</html>");
                    
                    // RequestDispatcher rd2 = request.getRequestDispatcher("/Welcome");
                    // rd2.forward(request, response);
                }
            }else{
                System.out.println("Login Failure..");
                response.setContentType("text/html; charset=UTF-8");
                try (PrintWriter out = response.getWriter()){
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet LoginServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("Login Failed: ");
                    out.println("<b>" +user + "</b> is not registred in the DataBase or the password is not correct.");
                    out.println("</body>");
                    out.println("</html>");  
                }
                rs.close();
                commande.close();
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
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

    public void destroy(){
        try{
            connexion.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Connection closed.");
    }
    
}
