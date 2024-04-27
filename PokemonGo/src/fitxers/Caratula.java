/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitxers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author dama0501
 */
public class Caratula {
    //atributos necesarios para leer un fichero
    
    File ruta_archivo; //objecte file necessari
    FileReader reader; //
    BufferedReader fichero;
    
    
    //constructor necesario
    public  Caratula(String ruta_relativa) throws FileNotFoundException
    {
        ruta_archivo = new File(ruta_relativa);
        reader = new FileReader(ruta_archivo);
        fichero = new BufferedReader(reader);
    }        

    //recuperarDatos
    public ArrayList<String> recuperarDatos() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        
        String linea;
        while ((linea = fichero.readLine()) != null) {
            lineas.add(linea);
        }

        return lineas;
    
    }
    
    
    
}
