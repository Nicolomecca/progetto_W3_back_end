package progetto_W3back.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "prestito")
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID prestito_id;

    @ManyToOne
    @JoinColumn(name = " numero_tessera")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = " codice_ISBN")
    private Elemento elementoPrestato;

    private LocalDate dataInizio;
    private LocalDate dataRestituzionePrevista;
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {

    }

    public Prestito(Utente utente, Elemento elementoPrestato, LocalDate dataInizio, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizio = dataInizio;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public UUID getPresito_id() {
        return prestito_id;
    }

    public void setPresito_id(UUID presito_id) {
        this.prestito_id = presito_id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Elemento getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Elemento elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "presito_id=" + prestito_id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizio=" + dataInizio +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
