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
 public class Cena {   
 Tenedor tenedores[];
 static Filosofo filosofos[];
 static int parametro = 5;//numero de filosofos y tenedoredd
 static int inicia = 1;
public static void main(String args[]){ 
 System.out.println("Cena de los Filosofos");  
 Cena cena = new Cena();  
 System.out.println("Inicia a comer el filosofo " + inicia );
 
 for(int i=0; i<5; i++){  
  Filosofo pensante = new Filosofo(i, cena); //Creacion del filosofo
  filosofos[i] = pensante; //Agregando el filosofo 
  if(i == inicia)
      filosofos[i].iniciodeHilo();
 }for(int i=0; i<5; i++)
     if(i!=inicia)
     filosofos[i].iniciodeHilo();
     
    if(!Filosofo.hilo.isAlive()) 
    System.out.println("Todos comieron en " + (NumFilosofos()/2 +1));
} 

public Cena(){  
 tenedores = new Tenedor[parametro];  
 filosofos = new Filosofo[parametro];
 for(int i=0; i<5; i++){  
  tenedores[i] = new Tenedor(i);  
 } 
}  
public Tenedor getTenedor(int x){  
     return tenedores[x];  
 }  
public int getTenedorDer(int x){  
     return (x+1)%parametro;  
 }  
public int getTenedorIzq(int x){  
     return x;  
 } 
public static int NumFilosofos(){ //Este ya sirve, no mover
    return parametro;
}


}  
    
