/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.citacao.controller;

import com.br.citacao.model.Autor;
import com.br.citacao.model.dao.AutorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 31338283
 */
public class Controller extends HttpServlet {

    private String command;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controller</title>");
            out.println("</head>");
            out.println("<body>");

            if (command.startsWith("autor")) {
                //AUTOR
                AutorDAO autorDAO = new AutorDAO();
                if (command.endsWith("inserir")) {
                    //Inserção
                    String nome = request.getParameter("nome_autor");
                    //out.print(nome)
                    Autor autor = new Autor();
                    autor.setNome(nome);
                    if (autorDAO.insert(autor)) {
                        out.print("Autor inserido com sucesso");
                    } else {
                        out.print("<p>Erro ao inserir Autor</p>");
                    }
                    out.print("<p><a href='index.jsp'>VOLTAR</a></p>");
                } else if (command.endsWith("atualizar")) {
                    //Update
                    int id = Integer.parseInt(request.getParameter("select_autor_update"));
                    String novoNome = request.getParameter("nome_autor");

                    Autor autor = new Autor(id, novoNome);

                    if (autorDAO.update(autor)) {
                        out.print("Autor atualizado com sucesso");
                    } else {
                        out.print("<p>Erro ao atualizar Autor</p>");
                    }
                    out.print("<p><a href='index.jsp'>VOLTAR</a></p>");
                } else if (command.endsWith("deletar")) {
                    //Delete
                    int id = Integer.parseInt(request.getParameter("select_autor_delete"));

                    Autor autor = new Autor();
                    autor.setId_autor(id);

                    if (autorDAO.delete(autor)) {
                        out.print("Autor Deletado com sucesso");
                    } else {
                        out.print("<p>Erro ao deletar Autor</p>");
                    }
                    out.print("<p><a href='index.jsp'>VOLTAR</a></p>");
                }
            }

            out.println("</body>");
            out.println("</html>");
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

        command = request.getParameter("command");
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
