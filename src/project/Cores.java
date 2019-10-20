package project;

import org.jetbrains.annotations.Contract;

public enum Cores {
    VERDE(2000), VERMELHO(3000), AMARELO(1000);

    private int tempo;

    Cores(int tempo){
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }
}
