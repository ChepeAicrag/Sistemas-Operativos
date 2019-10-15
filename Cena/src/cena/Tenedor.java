/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cena;

/**
 *
 * @author Chepe
 */
public class Tenedor{  
  
private int numero; //Numero de tenedor 
private boolean enUso;  //Saber si el tenedor está libre o no
   
public Tenedor(int numero){  
 this.numero = numero;  
 }  
  
synchronized public void usar() {   
      if(enUso){  
         System.out.println("Tenedor "+numero+" en uso, espera");  
      }else{  
         enUso= true;  
         System.out.println("Se esta usando el tenedor "+numero);  
      }  
}  
  
synchronized public void dejar(){   
      enUso = false;  
      System.out.println("Tenedor "+numero+" esta ahora disponible");  
   }  
}  
