/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JOptionPane;

/**
 *
 * @author Agus
 */
public class ValoracionEjemploDAO extends DAO{
    
    public int agregarValoracionEjemplo(int pIdValoracion, int pIdEjemplo)
    {
        String consulta = "insert into valoracion_Ejemplo (idValoracion, idEjemplo) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdValoracion);
            ps.setInt(2,pIdEjemplo);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
