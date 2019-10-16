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
    System.out.println("El cliente " + getNum() + " está cortandose el pelo");
    pasar = true;
    hilo.sleep(getTiempoCorte());
    if(barbero.getN_Clientes() >= barbero.getN_Sillas()){
    System.out.println("El cliente " + getNum() + " termino de pasar\t\t  Tiempo en corte " + getTiempoCorte() + "\t\t Están sentados " 
        + ((barbero.getN_Sillas()) +" y " + (barbero.getN_Clientes() - barbero.getN_Sillas()) +" a fuera"));
    }else{
    System.out.println("El cliente " + getNum() + " termino de pasar\t\t  Tiempo en corte " + getTiempoCorte() + "\t\t Están sentados " 
        + (barbero.getSentados()) + " y 0 a fuera\n");
    }
}

public void run(){
    try {
        pasar();
    } catch (InterruptedException ex) {}
}



















}

