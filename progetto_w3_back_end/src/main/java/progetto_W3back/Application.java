package progetto_W3back;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import progetto_W3back.entities.*;

import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("progetto_catalogo_bibliografico");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Utente utente1 = new Utente("Mario", "Rossi", LocalDate.of(1990, 1, 1));
        em.persist(utente1);
        Utente utente2 = new Utente("Giulia", "Bianchi", LocalDate.of(1985, 5, 15));
        em.persist(utente2);

        Libro libro1 = new Libro("Il Signore degli anelli", 1954, 1200);
        Libro libro2 = new Libro("1984", 1949, 328);
        libro1.setGenere("Fantasy");
        libro1.setAutore("J.R.R. Tolkien");

        libro2.setGenere("Distopia");
        libro2.setAutore("George Orwell");

        em.persist(libro1);
        em.persist(libro2);

        Rivista rivista1 = new Rivista("National Geographic", 2024, 100, Periodicita.MENSILE);
        Rivista rivista2 = new Rivista("Time", 2024, 80, Periodicita.SETTIMANALE);
        em.persist(rivista1);
        em.persist(rivista2);

        Prestito prestito1 = new Prestito(utente1, libro1, LocalDate.now(), LocalDate.now().plusDays(30), null);
        Prestito prestito2 = new Prestito(utente2, libro2, LocalDate.now(), LocalDate.now().plusDays(30), null);
        em.persist(prestito1);
        em.persist(prestito2);


        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
