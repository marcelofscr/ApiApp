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
public class Ejemplo {
    
    private String textoEjemplo;
    private ArrayList<Valoracion> valoraciones;
    
    
    public Ejemplo(String pTextoPregunta)
    {
        this.textoEjemplo = pTextoPregunta;
        valoraciones = new ArrayList();
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoEjemplo = textoPregunta;
    }

    

    public String getTextoPregunta() {
        return textoEjemplo;
    }

    
    public void agregarValoracionEjemplo(String pComentario, int pEstrellas)
    {
        Valoracion tValoracion = new Valoracion(pComentario, pEstrellas);
        this.valoraciones.add(tValoracion);
        
    }
    
    
    /*Hola Jime! :)*/
    
    
}





