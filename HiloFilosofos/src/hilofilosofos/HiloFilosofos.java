/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilofilosofos;

/**
 *
 * @author Chepe
 */
public class HiloFilosofos {

    /**
     * @param args the command line arguments
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        boolean op = false;
        int nfilo = LeerTeclado.LeerEntero("Introduce el numero de filosofos");
        int nInicio = LeerTeclado.validarFilosofoInicial("Introduce el filosofo donde inicia", nfilo);
        boolean giro = LeerTeclado.LeerBooleano("Introduce el giro  derecha o izquierda ");
        Mesa m = new Mesa(nfilo);
        m.RellenarMesa(m);
        StdOut.println("////Mostrando los presentes en la cena/////\n");
        m.mostrarMesa();
        StdOut.println("Empieza la cena con el filosofo " + nInicio + "...\n");
        StdOut.printf("Con el sentido a %s\n\n", (giro == true) ? "derecha" : "izquierda");
        m.Run(nInicio, giro);
        StdOut.println("\nComen en total " + m.CuantosComieron() + " filosofos");
        StdOut.println("Se tardaron en comer " + m.getTiempoTotal() + " minutos todos los filosofos");

    }

}
