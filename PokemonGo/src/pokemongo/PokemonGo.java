/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import fitxers.Caratula;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dama0501
 */
public class PokemonGo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         PokemonGo app = new PokemonGo();
        app.run();
        
        
        
    }

      /* la ejecucion programa*/
    private void run() {
        
        try {
            /*mostrar caratula*/
            /*recuperar datos fichero de caratula*/
            
            Caratula portada = new Caratula("ficheros/logo.pok");
             
            ArrayList<String> lineasDelLogo = portada.recuperarDatos();
             for (String linea : lineasDelLogo) {
                System.out.println(linea);
            }
            
            mostrarMenu();
            
            
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void mostrarMenu() {
        
        // Mostrar el menú
            System.out.println("----- Menú -----");
            System.out.println("0.- Salir");
            System.out.println("1.- Dar de alta entrenador");
            System.out.println("2.- Dar de baja entrenador");
            System.out.println("3.- Consultar entrenador");
            System.out.println("4.- Cazar pokemon");
            System.out.println("5.- Listar Pokemons cazados");
            System.out.println("6.- Listar tipos Pokemon existentes en juego");
            System.out.println("***********************");
            System.out.print("Elige una opción: ");
        
        
        
    }
}
