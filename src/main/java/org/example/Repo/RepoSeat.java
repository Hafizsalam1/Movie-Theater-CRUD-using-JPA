package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Film;
import org.example.Model.Seat;

import java.util.List;

public class RepoSeat extends Repo implements IRepo<Seat>{

    public RepoSeat(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Seat seat) {
        inTransaction(((em) -> em.persist(seat) ));

    }

    @Override
    public List<Seat> findAll(Integer page, Integer size) {
        TypedQuery<Seat> result = entityManager.createNamedQuery("find all seat", Seat.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Seat> seats = result.getResultList();
        return seats;    }

    @Override
    public void update(Seat seat) {

        inTransaction(em -> { em.merge(seat);});
    }

    @Override
    public Seat findOne(String id) {
        TypedQuery<Seat> result = entityManager.createNamedQuery("find seat by id", Seat.class);
        result.setParameter("id", id);
        return result.getSingleResult();
    }
    @Override
    public List<Seat> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Seat seat = findOne(id);
            em.remove(seat);
        });

    }
}
