<%-- 
    Document   : index
    Created on : 23/09/2015, 07:59:32
    Author     : 31338283
--%>

<%@page import="com.br.citacao.model.Autor"%>
<%@page import="java.util.List"%>
<%@page import="com.br.citacao.model.dao.AutorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citacao 4.0</title>
    </head>
    <body>
        <h1>CRUD para AUTORES</h1>
        <h2>CREATE</h2>
        <form action="Controller" method="POST">
            <input type="hidden" name="command" value="autor.inserir">
            <p>Nome: <input type="text" name="nome_autor" /></p>
            <p><input type="submit" value="INSERIR"/></p>
        </form>
        <hr>

        <h2>READ</h2>
        <%
            AutorDAO autorDAO = new AutorDAO();
            List<Autor> autores = autorDAO.read();
            for (Autor autor : autores) {
                out.print("<p>" + autor.getId_autor() + " - " + autor.getNome() + "</p>");
            }
        %>
        <hr>
        <h2>UPDATE</h2>
        <form action="Controller" method="POST">
            <select name="select_autor_update">
                <option value="0">Selecione...</option>
                <%
                    for (Autor autor : autores) {
                        out.print("<option value='" + autor.getId_autor() + "'>" + autor.getNome() + "</option>");
                    }
                %>
            </select>
            <input type="hidden" name="command" value="autor.atualizar">
            <p>Novo nome: <input type="text" name="nome_autor" /></p>
            <p><input type="submit" value="ATUALIZAR"/></p>
        </form>
        <hr>

        <h2>DELETE</h2>
        <form action="Controller" method="POST">
            <select name="select_autor_delete">
                <option value="0">Selecione...</option>
                <%
                    for (Autor autor : autores) {
                        out.print("<option value='" + autor.getId_autor() + "'>" + autor.getNome() + "</option>");
                    }
                %>
            </select>
            <input type="hidden" name="command" value="autor.deletar">
            <p><input type="submit" value="REMOVER"/></p>
        </form>
    </body>
</html>
