/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.MessageDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Message;

/**
 *
 * @author ThangCoi
 */
public class Contact extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param s
     * @param request servlet request
     * @param response servlet response
     * @return
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public boolean checkBlank(String s) {
        if (s.trim().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String page = "Contact";
            request.setAttribute("page", page);

            boolean status = true;
            String alert = "";

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String mess = request.getParameter("message");

            if (name == null || email == null || mess == null) {
                request.getRequestDispatcher("/html/contact.jsp").forward(request, response);
            } else {
                if (checkBlank(name) == true) {
                    status = false;
                }
                if (checkBlank(email) == true) {
                    status = false;
                }
                if (checkBlank(mess) == true) {
                    status = false;
                }

                if (status == true) {
                    MessageDAO mdb = new MessageDAO();
                    mdb.sentMessage(new Message(name, email, mess));
                    alert = "Thanks you your message!";
                }

                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("mess", mess);

                request.setAttribute("status", status);
                request.setAttribute("alert", alert);

                request.getRequestDispatcher("/html/contact.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("/html/error.jsp").forward(request, response);
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
