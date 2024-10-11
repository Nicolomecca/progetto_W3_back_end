package progetto_W3back;

import dao.CatalogoBibliograficoDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import progetto_W3back.entities.Libro;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_catalogo_bibliografico");
        EntityManager em = emf.createEntityManager();

        CatalogoBibliograficoDao dao = new CatalogoBibliograficoDao(em);

        em.getTransaction().begin();
//
//        Libro libro = new Libro("Peppone", 1949, 328);
//        libro.setGenere("Cartoon");
//        libro.setAutore("Paperone");
//        em.persist(libro);
//
////         //aggiungo utente
//        Utente nuovoUtente = new Utente("Giovani", "Verdi", LocalDate.of(1992, 3, 10));
//        dao.aggiungoElemento(nuovoUtente);
//
////
//        UUID codice1ISBN = UUID.fromString("cd2be1e7-49d3-4240-86d0-c94eee2c7984");
//
//        try {
//            dao.rimuovoLibro(codice1ISBN);
//            System.out.println("Libro rimosso con successo.");
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        //cerco un elemento(rivista)
//        UUID codiceISBN = UUID.fromString("8144896a-97dc-435e-baea-5f77ceb0ab1d");
//
//        try {
//            Rivista trovata = dao.cercoByISBN(codiceISBN);
//            if (trovata != null) {
//                System.out.println("Rivista trovata: " + trovata.getTitolo() + ", Periodicità: " + trovata.getPeriodicita());
//            }
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // cerco riviste per anno di pubblicazione
//        int annoPubblicazione = 2024;
//        List<Rivista> riviste = dao.cercoPerAnnoPubblicazione(annoPubblicazione);
//        for (Rivista rivista : riviste) {
//            System.out.println("Rivista:" + rivista.getTitolo() + "Anno :" + rivista.getAnnoPubblicazione());
//
//        }

        //cerco libri per autore
        String autore = "George Orwell";
        List<Libro> libri = dao.cercoPerAutore(autore);
        for (Libro l : libri) {
            System.out.println("Libro: " + l.getTitolo() + ", Autore: " + l.getAutore());
        }


        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}