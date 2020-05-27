package waitNotify;

public class Auto extends Thread{
    //Proprieta
    private Parcheggio parcheggio;

    //Costruttore
    public Auto(String nome, Parcheggio parcheggio) {
        super(nome);
        this.parcheggio = parcheggio;
        start();
    }
    
    //Metodo
    public void run(){
        while(true) {
            synchronized (parcheggio){
                parcheggio.ingresso();
                System.out.println("L'auto " + super.getName() + " é entrata\n Posti disponibili: " + parcheggio.getPostiDisponibili() + "\n");
            }          
            synchronized (parcheggio){
                parcheggio.uscita();
                System.out.println("L'auto " + super.getName() + " é uscita\n Posti disponibili: " + parcheggio.getPostiDisponibili() + "\n");
            }
        }
    } 
}
