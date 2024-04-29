/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author dama0501
 */
public class Entrenador {
    
    //ATRIBUTOS
    private int id;
    private String name;
    private String password;

    //CONSTRUCTOR
    public Entrenador(int id, String nombre, String password) {
        this.id = id;
        this.name = nombre;
        this.password = password;
    }
    
    //ID AUTOINCREMENTAL:
    public Entrenador(String nombre, String password) {
        this.name = nombre;
        this.password = password;
    }

    //PENDIENTE--> ARREGLAR TOSTRING
    @Override
    public String toString() {
        return "Entrenador{" + "id=" + id + ", nombre=" + name + ", password=" + password + '}';
    }
    
    
    
    
     // Getters y setters
    public int getId() {
        return id;
    }


    public String getNombre() {
        return name;
    }

    public void setNombre(String nombre) {
        this.name = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    //EQUALS
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entrenador)) {
            return false;
        }
        final Entrenador other = (Entrenador) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.name, other.name);
    }
    
    
   //OTRAS FUNCIONES
 
    
    
    
    
    
}
