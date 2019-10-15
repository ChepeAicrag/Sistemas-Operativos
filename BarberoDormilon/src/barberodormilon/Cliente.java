package barberodormilon;
public class Cliente extends Thread{
    
    private int id, tiempoCorte;
    private boolean pasar;
    private Barbero barbero;
    private Thread hilo;
    
public Cliente(int id, Barbero barbero){
    
    this.id = id + 1;
    pasar = false;
    this.barbero = barbero;
    hilo = new Thread();
    hilo.start();
    
    tiempoCorte = (int)(Math.random() * 5000 + 1);
           
}


public int getNum(){
    return id;
}

public boolean getPasar(){
    return pasar;
}

public int getTiempoCorte(){
    return tiempoCorte + 1;
}

public void pasar() throws InterruptedException{
    System.out.println("El cliente " + getNum() + "está cortandose el pelo");
    pasar = true;
    
    hilo.sleep(getTiempoCorte());
    System.out.println("El cliente " + getNum() + " terminpo de pasar");
}

public void run(){
    try {
        pasar();
    } catch (InterruptedException ex) {
    }
}



















}

