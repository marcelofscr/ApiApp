/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logicadenegocios.CategoriaConceptual;

/**
 *
 * @author Agus
 */
public class CategoriaDAO extends DAO implements iCategoriaDAO{

   
    /**
     *
     * @param nombre
     * @return CategoriaConceptual
     * @throws SQLException
     */
    @Override
    public CategoriaConceptual getCategoriaByName(String nombre) throws SQLException {
        CategoriaConceptual categoriaconceptual = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;  
        try {
            stmt = con.prepareStatement("SELECT * FROM categoriaConceptual WHERE codigoCategoria = ?");
            stmt.setString(1, nombre);
            rs = stmt.executeQuery();
            if (rs.next()) {
                categoriaconceptual = new CategoriaConceptual();
                categoriaconceptual.setNombre(rs.getString("nombre"));
                categoriaconceptual.setCodigoCategoria(rs.getInt("codigoCategoria"));
                categoriaconceptual.setDescripcion(rs.getString("descripcion"));
            }
        } finally {
            cerrarSQL(rs, stmt);
        }
        return categoriaconceptual;
    }

    @Override
    public ArrayList<CategoriaConceptual> getAllCategorias() throws SQLException {
        ArrayList<CategoriaConceptual> categorias = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM categoriaConceptual");
            while (rs.next()) {
                CategoriaConceptual categoriaconceptual = new CategoriaConceptual();
                categoriaconceptual.setNombre(rs.getString("nombre"));
                categoriaconceptual.setCodigoCategoria(rs.getInt("codigoCategoria"));
                categoriaconceptual.setDescripcion(rs.getString("descripcion"));
                categorias.add(categoriaconceptual);
            }
        } finally {
            cerrarSQL(rs, stmt);
        }
        return categorias;
    }

    /**
     *
     * @param categoriaconceptual
     * @throws SQLException
     */
    @Override
    public void addCategoria(CategoriaConceptual categoriaconceptual) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO categoriaConceptual (nombre, descripcion) VALUES (?, ?)");
            stmt.setString(1, categoriaconceptual.getNombre());
            stmt.setString(2, categoriaconceptual.getDescripcion());
            stmt.executeUpdate();
        } finally {
            cerrarSQL(null, stmt);
        }
    }

    @Override
    public void updateCategoria(CategoriaConceptual categoriaconceptual) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE categoriaConceptual SET nombre = ?, descripcion = ? WHERE codigoCategoria = ?");
            stmt.setString(1, categoriaconceptual.getNombre());
            stmt.setString(2, categoriaconceptual.getDescripcion());
            stmt.setInt(3, categoriaconceptual.getCodigoCategoria());
            stmt.executeUpdate();
        } finally {
            cerrarSQL(null, stmt);
        }
    }

    @Override
    public void deleteCategoria(String nombre) throws SQLException {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM categoriaConceptual WHERE id = ?");
            stmt.setString(1, nombre);
            stmt.executeUpdate();
        } finally {
            cerrarSQL(null, stmt);
        }
    }

    //Cerrar recursos de sql
    private void cerrarSQL(ResultSet rs, Statement stmt) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
        }
    }
}


