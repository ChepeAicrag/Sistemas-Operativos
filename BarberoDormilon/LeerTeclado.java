import javax.swing.JOptionPane;
public class LeerTeclado
{
  public static String LeerString(String s){
    return JOptionPane.showInputDialog(s);
    }
   
  public static int LeerEntero(String s){
    int entero=0;
    boolean leidobien=false;
    String Cad=s;
    while(!leidobien){
     try{
      entero=Integer.parseInt(LeerString(Cad));
      if(entero <= 0)
      throw new NumberFormatException();
      else
      leidobien=true;
      
     }catch(NumberFormatException miExcepcion){
      Cad="Introduzca un número mayor a 0";
     }
    }
     return entero; 
  }
}
