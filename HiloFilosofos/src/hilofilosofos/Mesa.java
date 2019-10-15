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
public class Mesa {

    private Filosofo filosofos[];
    private int N_Filosofos = 0;
    private static int tiempoTotal = 0;
    private int tiempoVuelta[];

    public Mesa(int N_Filosofos) {
        this.N_Filosofos = N_Filosofos;
        filosofos = new Filosofo[N_Filosofos];
        tiempoVuelta = new int[vueltas() + 1];

    }

    public int getN_Filosfos() {
        return N_Filosofos;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public int getTiempoVuelta(int pos) {
        return tiempoVuelta[pos];
    }

    public void RellenarMesa(Mesa mesa) {
        for (int i = 0; i < getN_Filosfos(); i++) {
            filosofos[i] = new Filosofo(i, mesa);
        }
    }

    public void formaComer(boolean sentido, int inicio) throws InterruptedException {
        if (sentido) //true para derecha
        {
            derecha(inicio);
        } else {
            izquierda(inicio);
        }
    }

    public int CuantosComieron() {
        int Cuantos = 0;
        for (Filosofo f : filosofos) {
            if (f.getComio()) {
                Cuantos++;
            }
        }
        return Cuantos;
    }

    public boolean ComprobarComida() {
        if (CuantosComieron() == getN_Filosfos()) //Que ya todos hayan comido
        {
            return true; //Retornar true si ya comieron todos
        }
        return false; //Retorna false si no han comido todos
    }

    public int vueltas() {
        if (getN_Filosfos() % 2 == 0) {
            return 2;
        }
        return 3;
    }

    public void mostrarMesa() {
        for (Filosofo x : filosofos) {
            StdOut.println("Filosofo " + x.getNum());
        }
    }

    public void Run(int inicio, boolean donde) throws InterruptedException {
        for (int i = 0; i < vueltas(); i++) {
            StdOut.println("\n--------------Vuelta " + (i + 1) + "-------------- \n");

            if (i == 0) {
                formaComer(donde, inicio);
            } else if (!donde) {
                formaComer(donde, inicio - i);
            } else {
                formaComer(donde, inicio + i);
            }
            StdOut.println("\n***** Tardaron en comer los de la vuelta " + (i + 1) + " un total de " + Math.abs(getTiempoVuelta(i + 1) - getTiempoVuelta(i)) + " minutos *****");
        }
    }

    static int con = 1;

    public void derecha(int inicio) throws InterruptedException {
        int aux = inicio - 1;

        if (filosofos.length % 2 == 0 || CuantosComieron() != filosofos.length - 1) // La mesa tiene filosofos pares
        {
            for (int i = 0; i < filosofos.length / 2; i++) {
                if (aux == filosofos.length) {
                    aux = 0;
                } else if (aux == filosofos.length + 1) {
                    aux = 1;
                }
                filosofos[aux].comer();
                tiempoTotal += filosofos[aux].tiempoComer() / 1000;
                StdOut.println("\tEl filosofo " + (aux + 1) + " comió y tardo " + filosofos[aux].tiempoComer() / 1000 + " minutos");
                aux += 2;
            }
            tiempoVuelta[con] = tiempoTotal;
        } else //La mesa tiene filosofos impares
        {
            for (int i = 0; i < filosofos.length; i++) {
                if (filosofos[i].getComio() == false) {
                    filosofos[i].comer();
                    tiempoTotal += filosofos[i].tiempoComer() / 1000;
                    StdOut.println("\tEl filosofo " + (i + 1) + " comió al final y tardo " + filosofos[i].tiempoComer() / 1000 + " minutos");
                }
            }
            tiempoVuelta[con] = tiempoTotal;
        }
        con++;
    }

    public void izquierda(int inicio) throws InterruptedException {
        int aux = inicio - 1;
        if (filosofos.length % 2 == 0 || CuantosComieron() != filosofos.length - 1) // La mesa tiene filosfos pares
        {
            for (int i = 0; i < filosofos.length / 2; i++) {
                if (aux == -1) {
                    aux = filosofos.length - 1;
                } else if (aux == -2) {
                    aux = filosofos.length - 2;
                }
                filosofos[aux].comer();
                tiempoTotal += filosofos[aux].tiempoComer() / 1000;
                StdOut.println("\tEl filosofo " + (aux + 1) + " tardo en comer " + filosofos[aux].tiempoComer() / 1000 + " minutos");
                aux -= 2;
            }
            tiempoVuelta[con] = tiempoTotal;
        } else {
            for (int i = 0; i < filosofos.length; i++) {
                if (filosofos[i].getComio() == false) {
                    filosofos[i].comer();
                    tiempoTotal += filosofos[i].tiempoComer() / 1000;
                    StdOut.println("\tEl filosofo " + (i + 1) + " comió al final y tardo en comer " + filosofos[i].tiempoComer() / 1000 + " minutos");
                }
            }
            tiempoVuelta[con] = tiempoTotal;
        }
        con++;
    }
}
