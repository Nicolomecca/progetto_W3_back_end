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
    private int numeroPagine;

    @OneToOne(mappedBy = "elementoPrestato")
    private Prestito prestito;

    public Elemento() {

    }

    public Elemento(String titolo, int annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
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

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public Prestito getPrestito() {
        return prestito;
    }

    public void setPrestito(Prestito prestito) {
        this.prestito = prestito;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPaagine=" + numeroPagine +
                '}';
    }
}
