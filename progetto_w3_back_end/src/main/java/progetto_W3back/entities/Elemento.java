package progetto_W3back.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "elemento")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Elemento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPaagine;

    public Elemento() {

    }

    public Elemento(String titolo, int annoPubblicazione, int numeroPaagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPaagine = numeroPaagine;
    }

    public UUID getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(UUID codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPaagine() {
        return numeroPaagine;
    }

    public void setNumeroPaagine(int numeroPaagine) {
        this.numeroPaagine = numeroPaagine;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPaagine=" + numeroPaagine +
                '}';
    }
}
