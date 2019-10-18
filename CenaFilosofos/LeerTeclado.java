import javax.swing.JOptionPane;
public class LeerTeclado
{
  public static String LeerString(String s){
    return JOptionPane.showInputDialog(s);
    }
   
  public static int validarFilosofoInicial(String s, int nFilo){
     int nFiloIni = LeerEntero(s);
     if(nFiloIni <= nFilo )
        return nFiloIni;
     else
     validarFilosofoInicial("Introduce un filosofo existente menor o igual a "+nFilo,nFilo);
  return 0;  
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
  
   public static boolean LeerBooleano(String s){
    boolean boleano=false;
    boolean leidobien=false;
    String Cad=s;
    while(!leidobien){
     try{    
    String p=LeerString(Cad);     
    if(p.equalsIgnoreCase("derecha")||p.equalsIgnoreCase("izquierda")){
         if(p.equalsIgnoreCase("derecha"))
         p = "true";
         else
         p = "false";
        boleano=Boolean.parseBoolean(p);
        leidobien=true;
    }else{
    throw new Exception();
    }
    }catch(Exception mixd){
     Cad="Introduzca el sentido derecha o izquierda";
     }
    }
     return boleano;
    }
}
