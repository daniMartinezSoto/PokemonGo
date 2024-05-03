/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menuUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mabardaji
 */
public class MenuDaw {
    private String Titol;
    private List<String> items;

    public MenuDaw(String Titol) {
        this.Titol = Titol;
        items = new ArrayList<String> ();
    }
    
    /**
     * rebr� per par�metre una opci� i afegir� l'Opci� 
     * a la collection demanada. 
     * (comprovar que no existeixi abans, 
     * i si existeix llan�ar l�excepci� OptionDuplicateException)
     * @param option_menu nueva opcion que tendra el men�
     */
    public void addOption(String option_menu) throws OptionDuplicateException
    {
        //com que el objecte arrayList es un String
        //ja te el equals implementat, i per tant funcionara 
        //contains
        if (!items.contains(option_menu))
        { //podria preguntar indexOf >0 existeix
            items.add(option_menu);
            //System.out.println("Opci� afegida -> " + option_menu);
        }
        else
        {
            throw new OptionDuplicateException(option_menu);
        }
        
    }
    
    public void addOptionsWithRepetition(String option_menu) throws OptionDuplicateException
    {
            items.add(option_menu);
            //System.out.println("Opci� afegida -> " + option_menu);
        
    }
    
    public void addOptionsByIndex(String option_menu, int pos)
            throws IndexOutOfBoundsException
    {
        //verificar que pos esta dintre de les que toquen
        //llan�ar la excepcio cap a dalt
        items.add(pos, option_menu);
        System.out.println("Opci� afegida -> " + option_menu);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("********************").append("\n");
        sb.append(Titol).append("\n");
        sb.append("********************").append("\n");
        for (int i = 0; i < items.size(); i++) {
            sb.append((i+1)).append("-").
                    append(items.get(i)).append("\n");
        }
        sb.append("********************").append("\n");
        return sb.toString();
    }
    
    /**
     * et demana que escolleixis una opci�, i la retornar�, 
     * sempre i quan sigui una opci� valida, 
     * sin� �s v�lida seguir� demanant 
     * la opci� dintre de les opcions v�lides. Aquest m�tode normalment anir� despr�s d�haver cridat al DisplayMen�
     * @return opcion escogida
     */
    public int chooseOption()
    {
        int option;
        
        Scanner sc = new Scanner(System.in);
        do{
        System.out.print("Escoge opcion (1-" + items.size() + "): ");
         option = sc.nextInt();
        }while(option <1 || option > this.numberOptionsMenu());
        return option;
    }
    
    public int displayMenu()
    {
        System.out.println(this.toString());
        int opcio = this.chooseOption();

        return opcio;
    }
    
    /**
     * Devuelve el numero de opciones que tiene el men�
     * @return numero opciones
     */
    public int numberOptionsMenu()
    {
        return items.size();
    }
    
    public String RemoveOptionByIndex(int indice) throws IndexOutOfBoundsException
    {
        String delete =  items.remove(indice);
        if (!delete.isEmpty())
        {
            System.out.println("Opcion borrada " + delete);
        }
        else
        {
            System.out.println("Opcion no borrada");
        }
        return delete;
    }
    
    public boolean Remove(String option_delete)
    {
        boolean delete = items.remove(option_delete);
        if (delete)
        {
            System.out.println("Opcion borrada");
        }
        else
        {
            System.out.println("Opcion no borrada");
        }
        return delete;
        
        
        
    }
}
