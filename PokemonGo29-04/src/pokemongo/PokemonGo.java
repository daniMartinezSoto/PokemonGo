/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import fitxers.Caratula;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entrenador;
import model.EntrenadorDao;

/**
 *
 * @author dama0501
 */
public class PokemonGo {
Scanner sc = new Scanner(System.in);
EntrenadorDao entrenadores;
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
        entrenadores = new EntrenadorDao();
        mostrarCaratula();
        mostrarMenu();
        
        
    
    } catch (SQLException ex) {
        Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }

    private void mostrarMenu() {
        
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        // Mostrar el menú
            System.out.println("----- Menu -----");
            System.out.println("0.- Salir");
            System.out.println("1.- Dar de alta entrenador");
            System.out.println("2.- Dar de baja entrenador");
            System.out.println("3.- Consultar entrenador");
            System.out.println("4.- Cazar pokemon");
            System.out.println("5.- Listar Pokemons cazados");
            System.out.println("6.- Listar tipos Pokemon existentes en juego");
            System.out.println("***********************");
            System.out.print("Elige una opción: ");
        
            opcion = scanner.nextInt();
            scanner.nextLine(); 
        
            switch (opcion) {
            
             case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                case 1:
                    darDeAltaEntrenador();
                    break;
                case 2:
                    darDeBajaEntrenador();
                    break;
                case 3:
                    consultarEntrenador();
                    break;
                case 4:
                    cazarPokemon();
                    break;
                case 5:
                    listarPokemonsCazados();
                    break;
                case 6:
                    listarTiposPokemon();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
            
            
            }
        
    }

    private void darDeAltaEntrenador() {
    try {
        System.out.println("Has escogido Dar de alta entrenador");
        
        //PIDE DATOS AL USUARIO PARA PODER DAR DE ALTA A UN ENTRENADOR
        sc = new Scanner(System.in);
        int insertado;
        System.out.println("PON EL NOMBRE DEL NUEVO ENTRENADOR");
        String newName= sc.nextLine();
        System.out.println("PON EL PASSWORD");
        String newPassword= sc.nextLine();
        Entrenador nuevo = new Entrenador(newName, newPassword);
        insertado = entrenadores.altaEntrenador(nuevo);
        
        if (insertado>0) {
            System.out.println("se ha insertado un entrenador");
        }
        else{
            System.out.println("Error: no insertado");
        }
        
    } catch (SQLException ex) {
        System.out.println("Error SQL");
    }
        
    }

    private void darDeBajaEntrenador() {
        System.out.println("Has escogido dar de baja entrenador");
    }

    private void consultarEntrenador() {
        System.out.println("has escogido consultar entrenador");
    }

    private void cazarPokemon() {
        System.out.println("has escogido cazar pokemon!");
    }

    private void listarPokemonsCazados() {
        System.out.println("has escogido listar Pokemons cazados");
    }

    private void listarTiposPokemon() {
        System.out.println("Has escogido listar tipos de pokemons");
    }

    private void mostrarCaratula() {
         try {
            /*mostrar caratula*/
            /*recuperar datos fichero de caratula*/
            
            Caratula portada = new Caratula("ficheros/logo.pok");
             
            
            ArrayList<String> lineasDelLogo = portada.recuperarDatos();
            
             for (String linea : lineasDelLogo) {
                System.out.println(linea);
            }

             
        } catch (FileNotFoundException ex) {
             System.out.println("FICHERO NO ENCONTRADO");
        } catch (IOException ex) {
             System.out.println("Erro de fichero");
            }
    }
}
