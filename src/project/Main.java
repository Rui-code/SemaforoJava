package project;

public class Main {

    public static void main(String[] args){

        Semaforo sem = new Semaforo();

        for (int i=0; i<10; i++){
            System.out.println(sem.getCor());
            sem.esperaCorMudar();
        }

        sem.desliga();
    }
}
