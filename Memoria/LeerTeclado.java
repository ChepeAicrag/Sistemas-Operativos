/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import javax.swing.JOptionPane;

/**
 * Clase para validar la lectura de teclado.
 * @author Garcia Garcia Jose Angel
 */
public class LeerTeclado {
  
  public static String LeerString(String s){
    return JOptionPane.showInputDialog(s);
  }
  
  public static int LeerEntero(String s){
    int entero = 0;
    boolean leidobien = false;
    String Cad = s;
    while(!leidobien){
     try{
         entero=Integer.parseInt(LeerString(Cad));
      if(entero <= 0)
        throw new NumberFormatException();
      else
        leidobien=true;
     }catch(NumberFormatException miExcepcion){
         Cad = "Introduzca un número mayor a 0";
        }
    }
     return entero; 
  }
  
   public static boolean LeerBooleano(String s){
    boolean boleano = false;
    boolean leidobien = false;
    String Cad = s;
    while(!leidobien){
        try{    
            String p=LeerString(Cad);     
            if(p.equalsIgnoreCase("derecha")||p.equalsIgnoreCase("izquierda")){
                if(p.equalsIgnoreCase("derecha"))
                    return true;
                else
                    return false;
            }else
                throw new Exception();
        }catch(Exception mixd){
             Cad = "Introduzca el sentido derecha o izquierda";
        }
    }
     return boleano;
    }
}
