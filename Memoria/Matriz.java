 

/**
 *
 * @author Garcia Garcia Jose Angel
 */
import java.util.*;
import javax.swing.JOptionPane;
public class Matriz {
    static String[][] matriz;
    public static void main(String[] args) {
        int filas = LeerTeclado.LeerEntero("Introduce el numero de filas");
        int columnas = LeerTeclado.LeerEntero("Introduce el numero de columnas");
        boolean sentido = LeerTeclado.LeerBooleano("Introduce el sentido a rellenar (izquierda o derecha)");
        String dato1 = JOptionPane.showInputDialog("Introduce tu primer dato (cualquier tipo de dato)");
        int dato2 = LeerTeclado.LeerEntero("Introduce tu edad (numero)");
        String dato3 = (String) JOptionPane.showInputDialog("Introduce tu sexo");
        String datos = dato1 + " " + (dato2/256) + "" + (dato2%256) + " " + dato3;
        matriz = evaluarTamaño(filas, columnas,datos);
        llenar(sentido, datos);
        mostrar(matriz);
    }
    
    public static String[][] evaluarTamaño(int filas, int columnas, String datos){
        if((filas*columnas) < datos.length()){
            int tam = (int)Math.sqrt(datos.length()) + 1;
            JOptionPane.showMessageDialog(null, "El tamaño es insuficiente para los datos.\nSe reajustara el tamaño a " + tam + " x " + tam);
            filas = tam;
            columnas = tam;
        }
        return  new String[filas][columnas];
    }
            
    public static void mostrar(String [][] mat){
        for (int i = 0; i < mat[0].length; i++)
            System.out.printf("  ----");
        System.out.println("  ");
        for (int i = 0; i < mat.length; i++){ 
            for (int j = 0; j < mat[i].length; j++)
                System.out.printf("|  " + mat[i][j] + "  ");
            System.out.println("|");
        }
        for (int i = 0; i < mat[0].length; i++) 
            System.out.printf("  ----");
        System.out.println(" ");
    }
    
    public static void llenar(boolean sentido, String datos){
        int pos = 0; 
        if(sentido)
            for(int i = 0; i < matriz.length; i++ )
                for (int j = 0; j < matriz[i].length; j++){ 
                    if(pos < datos.length() && datos.charAt(pos) != ' ')
                        matriz[i][j] = "" + datos.charAt(pos);
                    else
                        matriz[i][j] = "/";
                    pos++;
            }
        else
            for(int i = 0 ; i < matriz.length; i++)
                for (int j = matriz[i].length -1 ; j >= 0; j--){ 
                    if(pos < datos.length() && datos.charAt(pos) != ' ')
                        matriz[i][j] = "" + datos.charAt(pos);
                    else
                        matriz[i][j] = "/";
                    pos++;
            }
   }
}
