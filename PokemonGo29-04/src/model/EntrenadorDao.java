/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BBDD.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;

/**
 *
 * @author dama0501
 */
public class EntrenadorDao {

    //atribut para la conexion
    Connection conn_principal;
    
    
    //CONSTRUCTOR

    public EntrenadorDao() throws SQLException {
        conn_principal = DBConnect.getConnection();
    }

   
  
    
   
    
    //METODOS
   public int altaEntrenador(Entrenador newEntrenador) throws SQLException {
       
    int rows=0;
    String query;
  
  if(conn_principal!=null){
  //REALIZAMOS EL INSERT
  
 
  query = "INSERT INTO ENTRENADORES"
          +"(name, password) "
          +"(?,?)"; //id no por que es autoincremental
  
  //COMPROBACIÓN QUERY:
      System.out.println("orden-->"+query);
      
  PreparedStatement preparedQuery = conn_principal.prepareStatement(query);
  
                preparedQuery.setString(1, newEntrenador.getNombre());
                preparedQuery.setString(2, newEntrenador.getPassword());
                
                rows=preparedQuery.executeUpdate();
                return rows;
  }
  else{
      System.out.println("NO SE HA ESTABLECIDO CONEXIÓN");
  }
  
   return rows;
   } 
   
   
   public boolean existeixEntrenador(String nombre){return false;}
   public Entrenador buscarEntrenador(String nombre) {return null;}
   //public Entrenador esborrarEntrenador(String nombre){}
   //public List<Entrenador> totsEntrenadors(){}
    
}
