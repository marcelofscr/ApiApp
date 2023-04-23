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
public class ValoracionRespuestaDAO extends DAO {
    
     public int agregarValoracionEjemplo(int pIdValoracion, int pIdRespuesta)
    {
        String consulta = "insert into valoracion_Respuesta (idValoracion, idRespuesta) values(?,?)";
        try
        {
            con = conexion.establecerConexion();
            ps = con.prepareStatement(consulta);
            ps.setInt(1, pIdValoracion);
            ps.setInt(2,pIdRespuesta);
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error"+ e.toString());
        }
        return 1;
        
    }
    
}
