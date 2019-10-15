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
public class Filosofo extends Thread {

    private Mesa mesa;
    private boolean comio;
    private int id;
    private Thread hilo;
    private int tiempoComer;

    public Filosofo(int id, Mesa mesa) {
        this.id = id + 1;
        this.mesa = mesa;
        comio = false;
        hilo = new Thread();
        hilo.start();
        tiempoComer = (int) (Math.random() * 20000);
    }

    public Mesa getMesa() {
        return mesa;
    }

    public int getNum() {
        return id;
    }

    public boolean getComio() {
        return comio;
    }

    public int tiempoComer() {
        return tiempoComer + 10;
    }

    public void comer() throws InterruptedException {
        StdOut.println("El filosofo " + getNum() + " está comiendo");
        comio = true;
        hilo.sleep(tiempoComer());
        StdOut.println("El filosofo " + getNum() + " termino de comer");
    }

    public void run() {
        try {
            comer();
        } catch (InterruptedException ex) {

        }
        
    }
}
