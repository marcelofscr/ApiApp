package logicadenegocios;

import java.util.ArrayList;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Agustin Arias
 */
public class CategoriaConceptual {
    
    private String nombre;
    private int codigoCategoria;
    private String descripcion;
    private ArrayList<iItem> items;
    private ArrayList<iCurso> cursos;
    
    
    public CategoriaConceptual(String pNombre, String pDescripcion)
    {
        this.nombre = pNombre;
        this.descripcion = pDescripcion;
        this.codigoCategoria = generarNumeroRandom();
        
    }
    
    
    public void agregarCurso(Curso pCurso)
    {
       cursos.add(pCurso);
    }
    
    public void agregarItem(Item pItem)
    {
       items.add(pItem);
    }
    
    public int generarNumeroRandom()
    {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return number;
    }
    
    
    
    
    
    
    
}
