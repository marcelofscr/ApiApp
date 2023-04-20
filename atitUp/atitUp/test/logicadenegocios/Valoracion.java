/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;

/**
 *
 * @author Agus
 */
public class Valoracion {
    
    private int estrella;
    private String comentario;
    
    
    public Valoracion(String pComentario, int pEstrellas)
    {
        this.estrella = pEstrellas;
        this.comentario = pComentario;
    }

    public void setEstrella(int estrella) {
        this.estrella = estrella;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getEstrella() {
        return estrella;
    }

    public String getComentario() {
        return comentario;
    }
    
    
    
}
