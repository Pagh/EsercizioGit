package waitNotify;

public class Parcheggio {
    //Proprietà
    private int postiDisponibili = 10;

    //Get
    public int getPostiDisponibili() {
        return postiDisponibili;
    }
    
    //Metodo per regolare l'igresso delle auto
    public synchronized void ingresso(){
        while (postiDisponibili == 0) {
            try{
                wait();
            } catch (InterruptedException e) {}
        }
        postiDisponibili--;
    }
    
    //Metodo per regolare l'uscita delle auto
    public synchronized void uscita()
    {
        postiDisponibili++;
        notifyAll();
    }
}
