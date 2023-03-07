package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Theater;
import org.example.Model.Ticket;

import java.util.List;

public class RepoTicket extends Repo implements IRepo<Ticket>{

    public RepoTicket(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Ticket ticket) {
        inTransaction(((em) -> em.persist(ticket) ));
    }

    @Override
    public List<Ticket> findAll(Integer page, Integer size) {
        TypedQuery<Ticket> result = entityManager.createNamedQuery("find all ticket", Ticket.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Ticket> tickets = result.getResultList();
        return tickets;
    }

    @Override
    public void update(Ticket ticket) {

        inTransaction(em -> { em.merge(ticket);});
    }

    @Override
    public Ticket findOne(String id) {
        TypedQuery<Ticket> result = entityManager.createNamedQuery("find ticket by id", Ticket.class);
        result.setParameter("id", id);
        return result.getSingleResult();    }

    @Override
    public List<Ticket> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Ticket ticket = findOne(id);
            em.remove(ticket);
        });
    }
}
