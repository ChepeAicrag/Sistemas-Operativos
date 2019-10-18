
import java.util.*;
public class TestMesa
{
   public static void main() throws Exception{
     boolean op = false;
     int nfilo = LeerTeclado.LeerEntero("Introduce el numero de filosofos");  
     int nInicio = LeerTeclado.validarFilosofoInicial("Introduce el filosofo donde inicia", nfilo);
     boolean giro = LeerTeclado.LeerBooleano("Introduce el giro  derecha o izquierda ");
     Mesa m = new Mesa(nfilo,10);
     m.RellenarMesa(m);
     StdOut.println("////Mostrando los presentes en la cena/////\n");
     m.mostrarMesa();
     StdOut.println("Empieza la cena con el filosofo "+ nInicio +"...\n");
     StdOut.printf("Con el sentido a %s\n", (giro == true) ? "derecha" : "izquierda" );
     m.Run(nInicio,giro);
     StdOut.println("Comen en total " + m.CuantosComieron() + " filosofos");
     StdOut.println("Cada vuelta tenia una lapso de " + m.getTiempo() + " minutos" + "\nSe tardaron en comer " + m.getTiempoTotal() +" minutos todos los filosofos");
    }
}
