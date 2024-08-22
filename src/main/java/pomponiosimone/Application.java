package pomponiosimone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pomponiosimone.DAO.EventoDAO;
import pomponiosimone.entites.PartitaDiCalcio;
import pomponiosimone.entities.Concerto;

import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unita-4-giorno-12");
        EntityManager em = emf.createEntityManager();


        EventoDAO eventoDAO = new EventoDAO(em);

        em.getTransaction().begin();

        Concerto concerto1 = new Concerto("Concerto Rock", new Date(), Concerto.Genere.ROCK, true);
        Concerto concerto2 = new Concerto("Concerto Classico", new Date(), Concerto.Genere.CLASSICO, false);
        Concerto concerto3 = new Concerto("Concerto Pop", new Date(), Concerto.Genere.POP, true);


        em.persist(concerto1);
        em.persist(concerto2);
        em.persist(concerto3);

        em.getTransaction().commit();


        List<Concerto> concertiInStreaming = eventoDAO.getConcertiInStreaming(true);
        System.out.println("Concerti in streaming:");
        for (Concerto c : concertiInStreaming) {
            System.out.println(c.getNome() + " - " + c.getGenere());
        }


        List<Concerto> concertiRock = eventoDAO.getConcertiPerGenere(Concerto.Genere.ROCK);
        System.out.println("Concerti di genere ROCK:");
        for (Concerto c : concertiRock) {
            System.out.println(c.getNome() + " - " + c.getGenere());
        }
        PartitaDiCalcio partita1 = new PartitaDiCalcio("Derby", new Date(), "Roma", "Milan", 2, 1);
        PartitaDiCalcio partita2 = new PartitaDiCalcio("Classico", new Date(), "Juve", "Napoli", 1, 3);
        PartitaDiCalcio partita3 = new PartitaDiCalcio("Rivalità", new Date(), "Roma", "Lazio", 1, 1);


        em.persist(partita1);
        em.persist(partita2);
        em.persist(partita3);

        em.getTransaction().commit();


        List<PartitaDiCalcio> partiteVinteInCasa = eventoDAO.getPartiteVinteInCasa();
        System.out.println("Partite vinte in casa:");
        for (PartitaDiCalcio p : partiteVinteInCasa) {
            System.out.println(p.getSquadraCasa() + " ha vinto contro " + p.getSquadraOspite());
        }


        List<PartitaDiCalcio> partiteVinteInTrasferta = eventoDAO.getPartiteVinteInTrasferta();
        System.out.println("Partite vinte in trasferta:");
        for (PartitaDiCalcio p : partiteVinteInTrasferta) {
            System.out.println(p.getSquadraOspite() + " ha vinto contro " + p.getSquadraCasa());
        }


        em.close();
        emf.close();
    }
}