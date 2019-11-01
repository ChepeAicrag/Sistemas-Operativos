/**
 * Simulacion de un semaforo
 * 
 * @Jose Angel Garcia 
 * @31/10/2019
 */
import javax.swing.JOptionPane;
import java.util.*;
import java.util.Calendar;
public class Semaforo extends Thread
{
    private static Vector<String> semaforo1;
    private static Vector<String> semaforo2;
    private static Vector<String> semaforo3;
    private static Vector<String> semaforo4;
    private static Thread hilo;
    private static int tiempoTotal;
    public static void main(){
        hilo = new Thread();
        hilo.start();
        /*int n1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de carros en el semaforo 1"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de carros en el semaforo 2"));
        int n3 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de carros en el semaforo 3"));
        int n4 = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de carros en el semaforo 4"));
        int semaforoInicio = Integer.parseInt(JOptionPane.showInputDialog("Introduce el numero del semaforo que inicia"));
        */
        System.out.println(mostrarFecha("Inicial"));
        Semaforo semaforos = new Semaforo(3,4,5,6,1); //Aqui van las variables de n1,n2,n3,n4
        System.out.println(mostrarFecha("Final"));
        
        
    }
    
    public Semaforo(int ... carros){
        LlenarCarros(carros[0],carros[1],carros[2],carros[3]);
        MostrarInfoSema(getSemaforo(1));    
        MostrarInfoSema(getSemaforo(2));
        MostrarInfoSema(getSemaforo(3));    
        MostrarInfoSema(getSemaforo(4));   
        run(carros[4]);
    }
    
    public static String mostrarFecha(String indica){
        tiempoTotal = 0;
        Calendar fecha = Calendar.getInstance();
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);
        return String.format("%nHora %s: %02d:%02d:%02d %n", indica,hora, minuto, segundo);
    }
    
    public void LlenarCarros(int... carros){
        semaforo1 = new Vector<String>(carros[0]);
        semaforo2 = new Vector<String>(carros[1]);
        semaforo3 = new Vector<String>(carros[2]);
        semaforo4 = new Vector<String>(carros[3]);
        for(int i = 0; i < carros[0]; i++){
            int op = (int)(Math.random()*3);
            semaforo1.addElement(giro(op));
        }
        for(int i = 0; i < carros[1]; i++){
            int op = (int)(Math.random()*3);
            semaforo2.addElement(giro(op));   
        }
        for(int i = 0; i < carros[2]; i++){
            int op = (int)(Math.random()*3);
            semaforo3.addElement(giro(op));    
        }
        for(int i = 0; i < carros[3]; i++){
            int op = (int)(Math.random()*3);
            semaforo4.addElement(giro(op));
        }    
    }
    public void MostrarInfoSema(Vector<String> v){
        for(int i = 0; i < v.size(); i++)
            StdOut.printf(v.elementAt(i) + "  ");
        StdOut.println("");    
    }  
    
    public void run(int semaforoInicio){
        try{
            Pasar(semaforoInicio);
        }catch(Exception e){}
    }
    
    public String giro(int n){
        if(n == 0)
            return "derecha";
        else if(n == 1)
            return "izquierda";
        return "derecho";    
    }
    
    public Vector<String> getSemaforo(int x){
        if(x == 1)
            return semaforo1;
        else if(x == 2)
            return semaforo2;
        else if(x == 3)
            return semaforo3;
        else
            return semaforo4;
    }
    
    public void Pasar(int SemaforoInicio)throws InterruptedException {
        int otro = 0;
        int tiempoPorSema = 0;
       while(getSemaforo(1).size() != 0 || getSemaforo(2).size() != 0 || getSemaforo(3).size() != 0 || getSemaforo(4).size() != 0){
          if(SemaforoInicio == 1){
             otro = 4;
             tiempoPorSema = 5;
            }else if(SemaforoInicio == 2){
               tiempoPorSema = 4;
               otro = SemaforoInicio - 1;
               }else if(SemaforoInicio == 3){
                   tiempoPorSema = 5;
                   otro = SemaforoInicio - 1;
                }else{
                    tiempoPorSema = 2;
                    otro = SemaforoInicio - 1;
                }
          StdOut.printf("\nEstán pasando los carros del semaforo %d y posiblemente los del %d%n",SemaforoInicio,otro);
          if(getSemaforo(SemaforoInicio).size() != 0)
          Direccion(getSemaforo(SemaforoInicio),getSemaforo(SemaforoInicio).size(),tiempoPorSema,otro); 
          if(SemaforoInicio == 4)
            SemaforoInicio = 1;
          SemaforoInicio++;
       }
        
    }
    // Hasta es el maximo de carros que pueden pasar
    //n es la cantidad de carros que tiene la fila
    public void Direccion(Vector<String> x,int n, int hasta,int otro) throws InterruptedException {
           for(int i = 0; i < hasta || i < n ; i++){ // 15 son los segundos que dura el semaforo
               if(x.size() <= 0)
                  break;
               if(x.elementAt(0) != null) {
                   StdOut.printf("Carro %d gira a la %s%n",i + 1 ,x.elementAt(0));
                   hilo.sleep(3000);
                   x.removeElementAt(0);
                }
           }
            Vector <String> temp = getSemaforo(otro);
           if(temp.size() > 0){
               if(temp.elementAt(0).equals("derecha"))
               for(int i = 0; i < hasta ; i++){
                  if(temp.elementAt(0) != null)
                   if(temp.elementAt(0).equals("derecha")){
                      StdOut.printf("Carro %d del semaforo %d direccion => %s%n",i + 1,otro ,temp.elementAt(0));
                      hilo.sleep(3000);
                      temp.removeElementAt(0);
                  }
                }
            }
        } 
    }

