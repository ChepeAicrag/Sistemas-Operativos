package barberodormilon;

import java.util.Vector;

public class Barbero {

    private Vector<Cliente> sillas;
    private static int tiempoTotal = 0;
    private int N_Clientes = 0;
    private int N_Sillas = 0;
    private int N_sentados = 0;
    
    public Barbero(int N_Sillas, int N_Clientes) {
        this.N_Clientes = N_Clientes;
        this.N_Sillas = N_Sillas;
        sillas = new Vector(N_Clientes); //Tamaño de arreglo sillas
        N_sentados = N_Sillas;
    }

    public int getN_Clientes() {
        return N_Clientes;
    }

    public int getN_Sillas() {
        return N_Sillas;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
    public int getSentados(){
        return N_sentados;
    }
    
    public void RellenaBarberia(Barbero ba) {
        for (int i = 0; i < N_Clientes; i++) {
            sillas.add(new Cliente(i, ba));
        }
    }

    public void MostrarClientes() {
        System.out.println("Se mostrara los clientes sentados");
        for (int i = 0; i < N_Clientes; i++) {
            tiempoTotal += sillas.elementAt(i).getTiempoCorte();
            if (i != getN_Sillas()) {
                System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
            } else if (i == getN_Sillas()) {
                System.out.println("Los que esperan a fuera son ");
                System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
            } else {
                System.out.println("\t Cliente " + sillas.elementAt(i).getNum());
            }
        }
    }
    
    public void pasarCliente() throws InterruptedException {
        for (int i = 0; i < sillas.size(); i++){ 
            /*if (i == N_Sillas) {
                System.out.println("Los de afuera toman asientos ");
                for (int j = N_Sillas; j < sillas.size(); j++) 
                    System.out.println("\t Cliente " + sillas.elementAt(j).getNum());                              
            }*/            
            if(N_Clientes -N_Sillas <= 0)
                N_sentados--;
            
            N_Clientes--;
            sillas.elementAt(i).pasar();
            if (i == sillas.size() - 1) 
                System.out.println("Se tardaron en pasar " + sillas.size() + " clientes un total de " + tiempoTotal + " minutos");
        }
    }
}
