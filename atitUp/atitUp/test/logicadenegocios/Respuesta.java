/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

import java.util.ArrayList;

/**
 *
 * @author Agus
 */
public class Respuesta {
    
    private String textoRespuesta;
    private ArrayList<Valoracion> valoraciones;
    
    
    public Respuesta(String pTextoRespuesta)
    {
        this.textoRespuesta = pTextoRespuesta;
        valoraciones = new ArrayList();
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    
    public void agregarValoracionRespuesta(String pComentario, int pEstrellas)
    {
        Valoracion tValoracion = new Valoracion(pComentario, pEstrellas);
        this.valoraciones.add(tValoracion);
        
    }
    
    public int getSumaEstrellas()
    {
      int i = 0;
      int suma;
      for(Valoracion v: valoraciones)
      {
          i +=  v.getEstrella();
      }
       suma = i; 
       return suma;
    }
    
    public int getValorPonderadoRespuesta()
    {
       return getSumaEstrellas()/getCantidadValoraciones();
    }
    
    
    public int getCantidadValoraciones()
    {
        return this.valoraciones.size();
    }
    
    
    
}
