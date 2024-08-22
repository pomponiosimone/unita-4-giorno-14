package pomponiosimone.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("CONCERTO")
public class Concerto extends Evento {
    private Genere genere;
    private boolean inStreaming;

    // Costruttori, getters, setters
    public Concerto() {
    }

    public Concerto(String nome, Date data, Genere genere, boolean inStreaming) {
        super(nome, data);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    // Getters e setters
    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    public enum Genere {
        CLASSICO, ROCK, POP
    }
}