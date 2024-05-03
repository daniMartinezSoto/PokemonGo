/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import BD.DBConnect;import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author admin
 */
public class MochilaDAO {

Connection conn_principal;

    public MochilaDAO() throws SQLException {
        conn_principal = DBConnect.getConnection(); 
    }

    public boolean darCaptura(int id_entrenador, int num_pokemon, int CP) {
        
        String query = "INSERT INTO mochila (id_entrenador, num_pokemon, CP) VALUES (" +
                id_entrenador + ", " + num_pokemon + ", " + CP + ")";
        try (
            
            Statement stmt = conn_principal.createStatement()) {
           
            int filasAfectadas = stmt.executeUpdate(query);

            
            if (filasAfectadas > 0) {
                return true; 
            } else {
                return false; 
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL");
            return false; 
        }
    }
}
