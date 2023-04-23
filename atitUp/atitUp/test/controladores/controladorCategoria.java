/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import DAO.CategoriaDAO;
import DAO.iCategoriaDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.resource.spi.ConnectionManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Daniella
 */
@WebServlet("/categorias/*")
public class controladorCategoria extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private iCategoriaDAO icategoriaDAO;

    @Override
    public void init() {
        // Initialize the CategoriaDAO object
        //icategoriaDAO = new CategoriaDAO(ConnectionManager.establecerConexion);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            try {
                // Lista categorias
                ArrayList<CategoriaConceptual> categorias = icategoriaDAO.getAllCategorias();
                request.setAttribute("categorias", categorias);
                request.getRequestDispatcher("/ingresarPromptAdmin.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(controladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                // If the path is not null, extract the user ID from the path
                String nombreCategoria = pathInfo.substring(1);

                // Get the user from the database
                CategoriaConceptual categoriaconceptual;
                categoriaconceptual = icategoriaDAO.getCategoriaByName(nombreCategoria);
                if (categoriaconceptual == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }

                // Show the user details
                request.setAttribute("categociaConceptual", categoriaconceptual);
                request.getRequestDispatcher("/ingresarPromptAdmin.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(controladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        // Extract the action from the path
        String action = pathInfo.substring(1);

        if (action.equals("add")) {
            // Get the input values from the form
            String nombre = request.getParameter("nombre");
            String descripcion = request.getParameter("descripcion");

            // Create a new categoriaconceptual object
            CategoriaConceptual categoriaconceptual = new CategoriaConceptual();
            categoriaconceptual.setNombre(nombre);
            categoriaconceptual.setDescripcion(descripcion);

            // Use the UserDAO to insert the user into the database
            try {
                icategoriaDAO.addCategoria(categoriaconceptual);
                response.sendRedirect("/categorias");
            } catch (SQLException e) {
                response.sendError(500, "Failed to add categoria to database.");
            }
        } else if (action.equals("edit")) {
            try {
                // Get the user ID from the request
                String nombre = request.getParameter("codigoCategoria");

                // Get the user from the database
                CategoriaConceptual categoriaconceptual = icategoriaDAO.getCategoriaByName(nombre);
                if (categoriaconceptual == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    return;
                }

                // Update
                nombre = request.getParameter("nombre");
                String descripcion = request.getParameter("descripcion");
                categoriaconceptual.setNombre(nombre);
                categoriaconceptual.setDescripcion(descripcion);

                // Use the UserDAO to update the user in the database
                try {
                    icategoriaDAO.updateCategoria(categoriaconceptual);
                    response.sendRedirect("/categorias/" + nombre);
                } catch (SQLException e) {
                    response.sendError(500, "Failed to update categoria in database.");
                }
            } catch (SQLException ex) {
                Logger.getLogger(controladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (action.equals("delete")) {
            try {
                // Get the categoria ID from the request
                String nombre = request.getParameter("nombre");

                // Get the categoria from the database
                CategoriaConceptual categoriaconceptual = icategoriaDAO.getCategoriaByName(nombre);
                if (categoriaconceptual == null) {
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            } catch (SQLException ex) {
                Logger.getLogger(controladorCategoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
