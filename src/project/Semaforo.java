package project;

public class Semaforo implements Runnable{

    private Cores cor;
    private boolean parar;
    private boolean corMudou;

    public Semaforo(){
        this.cor = Cores.VERMELHO;
        this.corMudou = false;
        this.parar = false;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while(!parar){
            try {
                Thread.sleep(this.cor.getTempo());
                mudaCor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void mudaCor(){
        switch(this.cor) {
            case VERMELHO:
                this.cor = Cores.VERDE;
                break;
            case AMARELO:
                this.cor = Cores.VERMELHO;
                break;
            case VERDE:
                this.cor = Cores.AMARELO;
                break;
            default:
                break;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized void esperaCorMudar(){
        while (!this.corMudou){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.corMudou = false;
    }

    public synchronized void desliga(){
        this.parar = true;
    }

    public Cores getCor() {
        return cor;
    }
}



