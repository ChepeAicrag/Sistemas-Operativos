
import java.util.Vector;
import java.util.Scanner;
import java.util.Calendar;
public class Barbero extends Thread
{
    private int totalClientes;
    private static int tiempoTotal,N_Clientes = 0,N_Sillas,tiempoCorte;
    private Thread hilo;
    private static int horaFinal = 0;
    public static void main(){
        N_Sillas = LeerTeclado.LeerEntero("Introduce la cantidad de sillas");
        N_Clientes = LeerTeclado.LeerEntero("Introduce la cantidad de clientes");
        Barbero bar = new Barbero(N_Sillas,N_Clientes);
        bar.MostrarClientes();
        System.out.println(mostrarFecha("Inicial"));
        bar.run();
        System.out.println(mostrarFecha("Final"));
    }
    
    public static String mostrarFecha(String indica){
        tiempoTotal = 0;
        Calendar fecha = Calendar.getInstance();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        return String.format("%nHora %s: %02d:%02d:%02d %n", indica,hora, minuto, segundo);
    }
    
    public Barbero(int N_Sillas, int N_Clientes) {
        this.N_Clientes = N_Clientes;
        this.N_Sillas = N_Sillas;
        totalClientes = N_Clientes; 
        hilo = new Thread();
        hilo.start();
        tiempoCorte = (int)(Math.random() * 5000 + 1);
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
    
    public int getTiempoCorte(){
      return tiempoCorte + 1;
    }
   
   public void run(){
       try {
            pasarCliente();
       } catch (InterruptedException ex) {}
    }

    
    public void MostrarClientes() {
        System.out.println("Se mostrara los clientes sentados");
        for (int i = 0; i < N_Clientes; i++) {
            if (i != getN_Sillas()) {
                System.out.println("\t Cliente " + (i + 1));
            } else if (i == getN_Sillas()) {
                System.out.println(" Los que esperan a fuera son ");
                System.out.println("\t Cliente " + (i + 1));
            } else {
                System.out.println("\t Cliente " + (i + 1));
            }
        }
        System.out.println("\nEmpiezan a pasar los clientes...");
    }
    
    public void pasarCliente() throws InterruptedException {
        for (int i = 0; i < totalClientes; i++){ 
             tiempoTotal += getTiempoCorte();
             N_Clientes--;
             System.out.println("\nEl cliente " + (i + 1) + " está cortandose el pelo");
             hilo.sleep(getTiempoCorte());
             if(N_Clientes >= N_Sillas){
                 System.out.println("El cliente " + (i + 1) + " termino de pasar\t\t  Tiempo en corte " + (float)getTiempoCorte()/1000 + "\t\t Están sentados " 
                 + N_Sillas  +" y " + (N_Clientes - N_Sillas) +" a fuera");
                }else{
                     System.out.println("El cliente " + (i + 1) + " termino de pasar\t\t  Tiempo en corte " + (float)getTiempoCorte()/1000 + "\t\t Están sentados " 
                     + N_Clientes  + " y 0 a fuera\n");
                    }
             if(i == totalClientes - 1) 
                System.out.printf("Se tardaron en pasar %d clientes un total de %.2f segundos%n", totalClientes, (float)tiempoTotal/1000);
        }
    }
}
