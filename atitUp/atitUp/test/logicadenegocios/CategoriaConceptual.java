package logicadenegocios;

import comparadores.itemPromptComparator;
import comparadores.itemValoracionEjemploComparator;
import comparadores.itemValoracionRespuestasComparator;
import comparadores.itemValoracionTotalItemComparator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

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
        items = new ArrayList<>();
        cursos = new ArrayList<>();
        
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
    
    
    public ArrayList<iItem> getItems()
    {
        return items;
    }
    
    public ArrayList<iItem> getItemsAlfabeticamente()
    {
      ArrayList<iItem> aux;
      aux = items;
      Collections.sort(aux,new itemPromptComparator());
      return aux;
    }
    
     public ArrayList<iItem> getItemsPorValoracionRespuestas()
    {
      
      ArrayList<iItem> aux;
      aux = items;
      Collections.sort(aux,new itemValoracionRespuestasComparator());
      return aux;
      
    }
     
     public ArrayList<iItem> getItemsPorValoracionesEjemplos()
     {
        ArrayList<iItem> aux;
        aux = items;
        Collections.sort(aux,new itemValoracionEjemploComparator());
        return aux;
     }
     
     public ArrayList<iItem> getItemsValoracionTotal()
     {
        ArrayList<iItem> aux;
        aux = items;
        Collections.sort(aux,new itemValoracionTotalItemComparator());
        return aux;
     }
     
     
     
    
    
    
    
    
    
}
