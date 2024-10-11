package progetto_W3back.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "libro")
public class Libro extends Elemento {
    private String genere;
    private String autore;

    public Libro() {

    }

    public Libro(String titolo, int annoPubblicazione, int numeroPagine) {
        super(titolo, annoPubblicazione, numeroPagine);
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genere='" + genere + '\'' +
                ", autore='" + autore + '\'' +
                '}';
    }
}
