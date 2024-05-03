/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongo;

import BD.DBConnect;
import fitxers.Caratula;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import menuUtils.MenuDaw;
import menuUtils.OptionDuplicateException;
import model.Entrenador;
import model.EntrenadorDAO;
import model.Pokemon;
import model.PokemonDAO;
import model.MochilaDAO;
/**
 *
 * @author mabardaji
 */
public class PokemonGo {

    Scanner sc;
    EntrenadorDAO entrenadores;
    PokemonDAO pokedex;
    Entrenador login;
    MochilaDAO mochila;

    public static void main(String[] args) {
        PokemonGo app = new PokemonGo();
        app.run();
    }

    private void run() {
        
        try {
            
            mostrarLogo();
            DBConnect.loadDriver();
            entrenadores = new EntrenadorDAO();
            pokedex = new PokemonDAO();
            mochila = new MochilaDAO();
            //boolean user_valid = validar_usuari();
            //canviar a que devuelva String en lugar de boolean
            
            //login = recuperar_datos_entrenador();
            boolean user_valid = true;
            if (user_valid)
            {
                juego_valido();
            }
 
        } catch (SQLException ex) {
            System.out.println("Hay un error SQL " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    
}

    private void mostrarLogo()  {
        try {
            Caratula logo = new Caratula("ficheros/logo.pok");
            
            List<String> portada = logo.recuperarDatos();
            
            for (String lineas : portada) {
                System.out.println(lineas);
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error leyendo fichero " + ex.getMessage());
        }
        
        
        
    }
    
    
    private static void addAllOptions(MenuDaw menu) {
        try {
            menu.addOption("Salir");
            menu.addOption("Dar de alta entrenador");
            menu.addOption("Dar de baja entrenador");
            menu.addOption("Consultar entrenador");
            menu.addOption("Listar entrenadores");
            menu.addOption("Cazar Pokemon");
            menu.addOption("Listar Pokemons Cazados");
            menu.addOption("Listar tipos Pokemon existentes en juego");
            
        } catch (OptionDuplicateException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * pide datos al usuario para poder dar de alta a un entrenador
     */
    private void altaEntrenador() {
        try {
            sc = new Scanner(System.in);
            int insertado ;
            System.out.println("Pon el nombre del nuevo entrenador");
            String nombre = sc.nextLine();
            System.out.println("Pon el password");
            String password = sc.nextLine();
            Entrenador nuevo = new Entrenador(nombre, password);
            //llamar al dao existeEntrenador
            //if (entrenadores.existeEntrenador(nombre))
            insertado = entrenadores.altaEntrenador(nuevo);
            if (insertado > 0)
            {
                System.out.println("Se ha insertado el nuevo entrenador ");
            }
            else
            {
                System.out.println("Error insertando entrenador puede que exista ya con el nombre " + nombre);
            }
        } catch (SQLException ex) {
            System.out.println("Error SQL insertando entrenador" + ex.getMessage());
        }
        
    }

    private void borrarEntrenador() {
        try {
            sc = new Scanner(System.in);
            System.out.println("Pon el nombre del entrenador a borrar");
            String nombre = sc.nextLine();
            Entrenador borrado = entrenadores.esborrarEntrenador(nombre);
            if (borrado!=null)
            {
                System.out.println("Borrado " + borrado);
            }
            else
            {
                System.out.println("El entrenador " + nombre + " no existe en BD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void ConsultaEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void consultaEntrenador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void cazarPokemon() {
        
        try {
            Pokemon aparecido = pokedex.getPokemonRandom();
            String pokemonEncontrado=aparecido.getNombre();
            String ruta="ficheros/"+pokemonEncontrado+".pok";
            int atkPok= generarAtaque();
            
            
            System.out.println(aparecido);
            System.out.println("ATAQUE:"+atkPok);
            Caratula pok = new Caratula(ruta);
            List<String> portada = pok.recuperarDatos();
            
            for (String lineas : portada) {
                System.out.println(lineas);
            }
            
            mochila.darCaptura(1, aparecido.getNum_id(), atkPok);
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PokemonGo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static int generarAtaque() {
        Random rd = new Random();
        int min = 1;
        int max = 100;
        int range = max - min + 1;
        return rd.nextInt(range) + min;
    }
    private void listarMochila() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void listarTodosPokemons() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void salir() {
        try {
            System.out.println("Te esperamos pronto de vuelta... ");
            entrenadores.cerrarConexion();
        } catch (SQLException ex) {
            System.out.println("Error cerrar conexión " + ex.getMessage());
        }
    }

    private void todosEntrenadores() {
        try {
            //demanar coses a usuari
            //no h'hi
            
            //interacció DAO
            List<Entrenador> todos = entrenadores.totsEntrenadors();
            
            System.out.println("Todos los entrenadores pokemon... ");
            //informar usuari
            for (Entrenador trainer : todos) {
                System.out.println(trainer);
            }
            System.out.println("Numero de entrenadores... "+ todos.size());
            
            
        } catch (SQLException ex) {
            System.out.println("Error sql" + ex.getSQLState() + " - " + ex.getMessage());
        }
    }

    private boolean validar_usuari() {
            sc = new Scanner(System.in);
            try {
            System.out.print("pon el usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Pon el password: ");
            String contrasenya = sc.nextLine();

            if (entrenadores.existeEntrenador(nombre))
            { //existeix
                Entrenador existe = entrenadores.devolverEntrenador(nombre);
                if (existe.getPassword().equals(contrasenya))
                {
                    System.out.println("Bienvenido de nuevo " + nombre);
                    return true;
                }
                else
                {
                    System.out.println("Password incorrecto no puedes entrar");
                    return false;
                }
            }
            else
            {   
                //si no existeix
                Entrenador alta = new Entrenador(nombre, contrasenya);
                entrenadores.altaEntrenador(alta);
                System.out.println("Usuario nuevo dado de alta");
                return true;
                
            }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    return false;
                }       
    }

    private void juego_valido() {
        boolean exit = false;
         MenuDaw menu = new MenuDaw("**** POKEMON GO ***");
                 addAllOptions(menu); 
                 //introDadesProva(/* */);
                 int opcio;
                 
                 //tractar opcio escollida bucle fins que donis sortir no acabi CASA
                 do
                 {
                     //mostrar el menu i escollir opcio CASA
                     opcio = menu.displayMenu();
                     switch(opcio)
                     {
                         case 1: //Sortir
                             salir();
                             exit = true;
                             break;                   
                         case 2:
                             altaEntrenador();
                             break;
                         case 3:
                             borrarEntrenador();
                             break;
                         case 4:
                             consultaEntrenador();
                             break;
                         case 5:
                             todosEntrenadores();
                             break;
                         case 6:
                             cazarPokemon();
                             break;
                         case 7:
                             listarMochila();
                             break;
                         case 8:
                             listarTodosPokemons();
                             break;

                     } 
                 }while(!exit); 
    }
        
}