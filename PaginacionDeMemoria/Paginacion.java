import javax.swing.JOptionPane;
/**
 * Paginacion de Memoria 
 * @author José Ángel García García
 */
public class Paginacion {
    public static void main(String[] args) {       
        int tamArchivo = 0;
        int tamPagina = 0;
        boolean op = false;
        while(!op)
            try{
                 tamArchivo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del archivo"));
                 tamPagina = Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño de la pagina"));
                if(tamPagina > tamArchivo)
                    JOptionPane.showMessageDialog(null, "Su tamaño de pagina debe ser menor al del archivo");
                else if(tamArchivo > 0 && tamPagina > 0)
                    op = true;
                   else
                       JOptionPane.showMessageDialog(null, "Introduzca valores mayores a 0");
            }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Introduzca correctamente los datos");
            }
         new Ventana(tamArchivo,tamPagina);
        }
  }
 
