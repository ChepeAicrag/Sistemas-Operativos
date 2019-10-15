/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cena;

import com.sun.prism.impl.PrismTrace;

/**
 *
 * @author Chepe
 */
public class Filosofo implements Runnable{  
   static public Thread hilo;  
   protected Cena cena;  
   protected int tizq, tder;  
   protected int numero;  
   protected  boolean comio;
   protected  int comieron;
   static int vueltas;
public Filosofo (int x, Cena cena){  
      this.numero= x;  
      this.cena= cena;  
      tizq= cena.getTenedorIzq(numero);  
      tder= cena.getTenedorDer(numero);
      comio = false; //no inician comiendo
        
   }  
public void iniciodeHilo(){
      hilo = new Thread(this);
      hilo.start();

}
public void tomarTenedores(){  
     System.out.println ("Tomando tenedores");  
     Tenedor t1= cena.getTenedor(tizq);  
     Tenedor t2= cena.getTenedor(tder);  
     t1.usar();  
     t2.usar();  
}  
public void comer(){  
     try{  
        System.out.println("Filosofo "+numero+" esta comiendo");  
        int espera= (int)(Math.random()*700);  
        hilo.sleep(espera);  
        System.out.println("Filosofo "+numero+" esta satisfecho");
        comio = true; //cambia su estado a que ya comio 
        comieron--; //Se aumenta el contador de comieron comieron
         
     }catch(InterruptedException e){  
  e.printStackTrace();  
     }  
}  
protected void dejarTenedores(){  
     System.out.println("Soltando los tenedores.");  
     Tenedor t1= cena.getTenedor(tizq);  
     Tenedor t2= cena.getTenedor(tder);  
     t1.dejar();  
     t2.dejar();  
}

public void run() {
      while(!comio && comieron != cena.NumFilosofos() ){
         tomarTenedores();  
         comer();  
         dejarTenedores();
      } 
      
  }  

public int Nvueltas(){
return vueltas;
}
}  