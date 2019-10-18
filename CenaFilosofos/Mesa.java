
/**
 * Segunda forma de hacerlo 
 * Lista ciruclar otra solucion 
 * objeto nota, encontrar una nota dado el titulo de la nota una parte o todo 
 * titulo, fecha, encabrzado y cuerpo
 */
public class Mesa
{
    private Filosofo filosofos[];
    private int N_Filosofos = 0;
    private int tiempo = 0;
    private int tiempoTotal = 0;
    
    public Mesa(int N_Filosofos, int tiempo){
        this.N_Filosofos = N_Filosofos;
        filosofos = new Filosofo[N_Filosofos];
        this.tiempo = tiempo;
    }
    
    public int getN_Filosfos(){
        return N_Filosofos;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    
    public int getTiempoTotal(){
        return tiempoTotal;
    }
    
    public void RellenarMesa (Mesa mesa){
        for(int i = 0; i < getN_Filosfos(); i++)
            filosofos[i] = new Filosofo(i,mesa);
    }
    
    public void formaComer(boolean sentido, int inicio){
        if(sentido) //true para derecha
        derecha(inicio);
        else
        izquierda(inicio);
    }
    
    public int CuantosComieron(){
        int Cuantos = 0; 
         for(Filosofo f : filosofos)
             if(f.getComio())
                Cuantos++;
        return Cuantos;
    }
    
    public boolean ComprobarComida(){
        if(CuantosComieron() == getN_Filosfos()) //Que ya todos hayan comido
            return true; //Retornar true si ya comieron todos
        return false; //Retorna false si no han comido todos
    }
    
    public int vueltas(){
        if(getN_Filosfos() % 2 == 0)
            return 2;
        return 3;
    }   
    
    public void mostrarMesa(){
        for(Filosofo x : filosofos)
        StdOut.println("Filosofo " + x.getId());
    }
    
    public void Run(int inicio, boolean donde){
        for(int i = 0; i < vueltas() ; i++){
            StdOut.println("--------------Vuelta " + (i+1) + "-------------- \n");
            tiempoTotal += getTiempo();
             if(i== 0)
                formaComer(donde,inicio);
             else if(!donde)
                    formaComer(donde,inicio - i);
                    else
                        formaComer(donde,inicio + i);
            StdOut.println("");
        }
    }
    
    public void derecha(int inicio){
        int aux = inicio-1;
         if(filosofos.length % 2 == 0 || CuantosComieron() != filosofos.length-1) // La mesa tiene filosfos pares
            for(int i = 0; i < filosofos.length/2; i++){
                if(aux == filosofos.length)
                    aux = 0;
                else if(aux == filosofos.length + 1)
                        aux = 1; 
                filosofos[aux].comer();
                StdOut.println("\tEl filosofo " + (aux + 1) + " come");
                aux += 2;
         }else  //La mesa tiene filosfos impares
             for(int i = 0; i < filosofos.length; i++)
                 if(filosofos[i].getComio() == false){
                     filosofos[i].comer();
                     StdOut.println("\tEl filosofo " + (i + 1) + " come al final :("); 
                 }
    }
    
    public void izquierda(int inicio){
        int aux = inicio-1;
        if(filosofos.length % 2 == 0 || CuantosComieron() != filosofos.length-1) // La mesa tiene filosfos pares
            for(int i = 0; i < filosofos.length/2; i++){
                if(aux == -1 )
                    aux = filosofos.length-1;
                else if(aux == -2)
                        aux = filosofos.length-2; 
                filosofos[aux].comer();
                StdOut.println("\tEl filosofo " + (aux + 1) + " come");
                aux -= 2;
        }else
            for(int i = 0; i < filosofos.length; i++)
                if(filosofos[i].getComio() == false){
                    filosofos[i].comer();
                    StdOut.println("\tEl filosofo " + (i + 1) + " come al ultimooo :(");
                } 
    }
}
