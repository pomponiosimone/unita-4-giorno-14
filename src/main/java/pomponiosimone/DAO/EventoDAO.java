package pomponiosimone.DAO;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import pomponiosimone.entities.Concerto;

import java.util.List;

public class EventoDAO {
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        String jpql = "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming";
        TypedQuery<Concerto> query = entityManager.createQuery(jpql, Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Concerto.Genere genere) {
        String jpql = "SELECT c FROM Concerto c WHERE c.genere = :genere";
        TypedQuery<Concerto> query = entityManager.createQuery(jpql, Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }
}