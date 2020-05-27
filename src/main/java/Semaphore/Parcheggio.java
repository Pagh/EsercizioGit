package Semaphore;

import java.util.concurrent.Semaphore;

public class Parcheggio {
    //Proprieta
    private int postiDisponibili  = 10;
    private Semaphore postiDisp;
    private Semaphore postiOcc;
    
    //Costruttore
    public Parcheggio() {
        postiDisp = new Semaphore(postiDisponibili, true);
        postiOcc = new Semaphore(0, true);
    }
    
    //Get
    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    
    //
    public synchronized void ingresso()
    {
        try
        {
            postiDisp.acquire();
        } catch (InterruptedException e) {}
        postiOcc.release();
        postiDisponibili--;
    }
    
    public synchronized void uscita()
    {
        try
        {
            postiOcc.acquire();
        } catch (InterruptedException e) {}
        postiDisp.release();
        postiDisponibili++;
    }
}
