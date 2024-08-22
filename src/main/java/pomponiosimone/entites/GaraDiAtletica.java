import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import pomponiosimone.entites.Evento;
import pomponiosimone.entites.Persona;

import java.util.Date;
import java.util.Set;

@Entity
@DiscriminatorValue("ATLETICA")
public class GaraDiAtletica extends Evento {
    @ManyToMany
    private Set<Persona> atleti;

    @ManyToOne
    private Persona vincitore;

    // Costruttori, getters, setters
    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String nome, Date data, Set<Persona> atleti, Persona vincitore) {
        super(nome, data);
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    // Getters e setters
    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}