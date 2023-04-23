/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Daniella
 */
public interface iCategoriaDAO {
    CategoriaConceptual getCategoriaByName(String nombre) throws SQLException;
    ArrayList<CategoriaConceptual> getAllCategorias() throws SQLException;
    void addCategoria(CategoriaConceptual categoriaconceptual) throws SQLException;
    void updateCategoria(CategoriaConceptual categoriaconceptual) throws SQLException;
    void deleteCategoria(String nombre) throws SQLException;
}


