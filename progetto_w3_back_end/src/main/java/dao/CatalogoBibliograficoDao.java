package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import progetto_W3back.entities.Libro;
import progetto_W3back.entities.Rivista;
import progetto_W3back.entities.Utente;

import java.util.List;
import java.util.UUID;

public class CatalogoBibliograficoDao {
    private final EntityManager em;

    public CatalogoBibliograficoDao(EntityManager em) {
        this.em = em;
    }

    //Aggiungo un elemento

    public void aggiungoElemento(Utente elemento) {
        em.persist(elemento);
    }

    //Rimuovo un elemento
    public void rimuovoLibro(UUID codiceISBN) {
        Libro libro = em.find(Libro.class, codiceISBN);
        if (libro == null) {
            throw new IllegalArgumentException("Libro non trovato per ISBN: " + codiceISBN);
        }
        em.remove(libro);
    }

    //Ricerca rivista
    public Rivista cercoByISBN(UUID codiceISBN) {
        Rivista trovata = em.find(Rivista.class, codiceISBN);
        if (trovata == null) {
            throw new IllegalArgumentException("Rivista non trovata per ISBN: " + codiceISBN);
        }
        return trovata;
    }

    // Ricerca per anno di pubbicazione
    public List<Rivista> cercoPerAnnoPubblicazione(int annoPubblicazione) {
        TypedQuery<Rivista> queryRivistaAnno = em.createQuery("SELECT e FROM Rivista e WHERE e.annoPubblicazione = :anno", Rivista.class);
        queryRivistaAnno.setParameter("anno", annoPubblicazione);
        return queryRivistaAnno.getResultList();
    }

    // Ricerca per autore
    public List <Libro> cercoPerAutore
}

