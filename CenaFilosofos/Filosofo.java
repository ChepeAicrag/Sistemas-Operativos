
/**
 * Write a description of class Filosofo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Filosofo
{
    private Mesa mesa;
    private boolean comio;
    private int id;
    public Filosofo(int id, Mesa mesa){
        this.id = id + 1;
        this.mesa = mesa;
        comio = false;
    }
    
    public Mesa getMesa(){
        return mesa;
    }
    
    public int getId(){
        return id;
    }
    
    public void comer(){
        comio = true;
    }
    
    public boolean getComio(){
        return comio;
    } 
}
