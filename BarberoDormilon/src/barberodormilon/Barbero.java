package barberodormilon;

import java.util.Vector;

public class Barbero {
    private Vector  <Cliente> sillas;
    private static int tiempoTotal = 0;
    private  int N_Clientes = 0;
    private int N_Sillas = 0;

public Barbero(int N_Sillas, int N_Clientes){
    this.N_Clientes = N_Clientes;
    this.N_Sillas = N_Sillas;
    sillas = new Vector(N_Sillas); //Tamaño de arreglo sillas
}

public int getN_Clientes(){
    return N_Clientes;
}

public int getN_Sillas(){
    return N_Sillas;
}
public void RellenaBarberia(Barbero ba){
    for(int i = 0 ; i < N_Clientes; i++)
        sillas.add(new Cliente(i,ba)); 
}

public int CuantosPasaron(){
    int cuantos = 0;
    for(Cliente c : sillas)
        if (c.getPasar()) {
            cuantos++;
        }
return cuantos;
}

public boolean ComprobarCuantos(){
    if(CuantosPasaron() == getN_Clientes())
        return true;
return false;
} 

public void MostrarClientes(){
    System.out.println("Se mostrara los clientes sentados");
     for(int i = 0 ; i < N_Clientes; i++){
         if(i != getN_Sillas())
             System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
         else if(i == getN_Sillas()){
             System.out.println("Los que esperan a fuera son ");
             System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
         }else
             System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
     }   
}


public void pasarCliente() throws InterruptedException{
    if(!sillas.elementAt(0).getPasar())
        sillas.elementAt(0).pasar();
}

}



