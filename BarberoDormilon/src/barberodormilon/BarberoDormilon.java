/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barberodormilon;

/**
 *
 * @author Chepe
 */
public class BarberoDormilon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        Barbero barbero= new Barbero(1, 5);
        barbero.RellenaBarberia(barbero);
        barbero.MostrarClientes();
        long  tiempoInicial = System.currentTimeMillis();
        barbero.pasarCliente();
        long  tiempoFinal = System.currentTimeMillis();
        System.out.println("\nSe tardo en ejecutar " + (tiempoFinal-tiempoInicial));
        
        
    }
    
}
