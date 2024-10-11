package progetto_W3back.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "rivista")
public class Rivista extends Elemento {
    @Enumerated(EnumType.STRING)
    private Periodicita periodicita;

    public Rivista() {

    }

    public Rivista(String titolo, int annoPubblicazione, int numeroPaagine, Periodicita periodicita) {
        super(titolo, annoPubblicazione, numeroPaagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                "periodicita=" + periodicita +
                '}';
    }
}
