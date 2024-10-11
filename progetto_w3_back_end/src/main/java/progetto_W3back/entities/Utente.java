package progetto_W3back.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "utente")
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID numero_tessera;
    private String nome;
    private String cognome;
    private LocalDate data_nascita;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> prestiti;

    public Utente() {

    }

    public Utente(String nome, String cognome, LocalDate data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    public UUID getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(UUID numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "numero_tessera=" + numero_tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                '}';
    }
}
