package WEB.classes.controladores;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import WEB.classes.DAO.CategoriaDAO;
import WEB.classes.logicadenegocios.CategoriaConceptual;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fagares */
@WebServlet(urlPatterns = {"/controladorCategoria"})
public class controladorCategoria extends HttpServlet {
    
    String listar = "vistas/ingresarPromptAdmin.jsp";
    String add = "";
    
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<CategoriaConceptual> categorias = categoriaDAO.listar();
        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("ingresarPromptAdmin.jsp").forward(request, response);
    }
    
    
   

}
