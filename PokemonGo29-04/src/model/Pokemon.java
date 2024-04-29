/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dama0501
 */
public class Pokemon {
    
    //ATRIBUTOS
    private int numPok;
    private String nombre;
    private String tipo;

    // Constructor
    public Pokemon(int numPok, String nombre, String tipo) {
        this.numPok = numPok;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    
    // Getters y setters
    public int getNumPok() {
        return numPok;
    }

    public void setNumPok(int numPok) {
        this.numPok = numPok;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //OTRAS FUNCIONES
    
    
    
    
}
