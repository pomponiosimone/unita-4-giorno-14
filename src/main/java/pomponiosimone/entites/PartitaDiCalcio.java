package pomponiosimone.entites;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
@DiscriminatorValue("CALCIO")
public class PartitaDiCalcio extends Evento {
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int numeroGolSquadraCasa;
    private int numeroGolSquadraOspite;

    // Costruttori, getters, setters
    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String nome, Date data, String squadraCasa, String squadraOspite, int numeroGolSquadraCasa, int numeroGolSquadraOspite) {
        super(nome, data);
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
        this.squadraVincente = determinaSquadraVincente();
    }

    private String determinaSquadraVincente() {
        if (numeroGolSquadraCasa > numeroGolSquadraOspite) {
            return squadraCasa;
        } else if (numeroGolSquadraCasa < numeroGolSquadraOspite) {
            return squadraOspite;
        } else {
            return null; // Pareggio
        }
    }

    // Getters e setters
    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraCasa() {
        return numeroGolSquadraCasa;
    }

    public void setNumeroGolSquadraCasa(int numeroGolSquadraCasa) {
        this.numeroGolSquadraCasa = numeroGolSquadraCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}