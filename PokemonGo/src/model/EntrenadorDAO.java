/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author mabardaji
 */
public class EntrenadorDAO {
    //atribut per la conexi
    Connection conn_principal;

    public EntrenadorDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); //estara oberta fins al final
    }
    
    
    public int altaEntrenador(Entrenador trainer) throws SQLException
    {

        int rows=0;
        if (conn_principal!=null)
        {
            //realitzo insert
           //llamar al metodo existeEntrenador y si da cierto no hago el insert
            
           String query = "INSERT INTO ENTRENADORS  "
                        + "(name, password) "
                        + " VALUES"
                        + " (?,?)"; //id no informat perque es autoincremental
            //verificacio
            System.out.println("prueba Query-->"+query); //s'ha de treure quant funcioni 
            
            PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
            
            preparedQuery.setString(1, trainer.getName());
            preparedQuery.setString(2,trainer.getPassword());
            rows = preparedQuery.executeUpdate();   
        }
        
        return rows;
    }
    
    
    /**
     * devuelve cierto si ya exsite un entrenador en base de datos con ese nombre
     * false si no existe
     * @param name
     * @return 
     */
    public boolean existeEntrenador(String name) throws SQLException
    {
       boolean existe = false;
    
    if (conn_principal != null) {
        
        Statement stmt = conn_principal.createStatement();
        String query = "id, name, password"
                +"from entrenadors where UPPER(name)"
                +"= '"+name.toUpperCase()+"'";
        
        ResultSet cursor = stmt.executeQuery(query);
        
        
        if (cursor.next()) {
            return true;
        }
        else{
            return false;
        }     
    }
    return existe;
    }
    
    
    /**
     * Borrar entrenador amb el nom
     * Primer el te que recuperar, si existeix
     * i despres borrar-lo, pero retornant el objecte entrenador informat
     * si no existia, retorna null 
     * @param name
     * @return 
     */
    public boolean esborrarEntrenador(String name) throws SQLException
    {
         boolean borradoExitoso = false;
    
    if (conn_principal != null) {
        String query = "DELETE FROM entrenador WHERE name = ?";
        
        PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
        preparedQuery.setString(1, name);
        
        int rowsAffected = preparedQuery.executeUpdate();
        
        if (rowsAffected > 0) {
            borradoExitoso = true;
        }
        
        preparedQuery.close();
    }
    
    return borradoExitoso;
    }
    
    
    /**
     * retorna tots els entrenadors de la base de dades o null si no n'hi ha cap
     * @return 
     */
    public List<Entrenador> totsEntrenadors() throws SQLException
            {    
        
        List<Entrenador> all_trainers = null;
        
        if (conn_principal != null) {
            
        
        
        Statement stmt = conn_principal.createStatement();
        
        String query = "SELECT id, name, password FROM entrenadors";
        
        ResultSet cursor = stmt.executeQuery(query);
        all_trainers = new ArrayList<>();
            System.out.println("query-->"+query);
        while(cursor.next()){
            String nom = cursor.getString("name");
            String contraseña= cursor.getString("password");
            int id = cursor.getInt("id");
            
            all_trainers.add(new Entrenador(id, nom, contraseña));
        }
        
        return all_trainers;
        }
      
        return all_trainers;
    }
    
    
    /**
     * retorna un objecte entrenador amb els atributs informats que tingui el name.
     * Si no existei retorna null
     * @param name 
     */
    public Entrenador devolverEntrenador(String name) throws SQLException
    {
        Statement stmt = conn_principal.createStatement();
        
        String query = "SELECT id, name, password FROM entrenadors WHERE name = '"
                +name+"'";
        
        
        
        
        
        
        
        return null;
    }
    
    
    public void cerrarConexion() throws SQLException
    {
        conn_principal.close();
    }
    
}
