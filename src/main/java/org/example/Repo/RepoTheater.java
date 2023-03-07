package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Film;
import org.example.Model.Theater;

import java.util.List;

public class RepoTheater extends Repo implements IRepo<Theater> {

    public RepoTheater(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    public void create(Theater theater) {
        inTransaction(((em) -> em.persist(theater) ));
    }

    @Override
    public List<Theater> findAll(Integer page, Integer size) {
        TypedQuery<Theater> result = entityManager.createNamedQuery("find all theater", Theater.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Theater> theaters = result.getResultList();
        return theaters;
    }

    @Override
    public void update(Theater theater) {

        inTransaction(em -> { em.merge(theater);});


    }

    @Override
    public Theater findOne(String id) {
        TypedQuery<Theater> result = entityManager.createNamedQuery("find theater by id", Theater.class);
        result.setParameter("id", id);
        return result.getSingleResult();
    }

    @Override
    public List<Theater> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Theater theater = findOne(id);
            em.remove(theater);
        });

    }
}

