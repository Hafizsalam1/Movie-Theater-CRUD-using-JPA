package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Rating;

import java.util.List;

public class RepoRating extends Repo implements IRepo<Rating>{


    public RepoRating(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Rating rating) {
        inTransaction(((em) -> em.persist(rating) ));
    }

    @Override
    public List<Rating> findAll(Integer page, Integer size) {

        TypedQuery<Rating> result = entityManager.createNamedQuery("find all rating", Rating.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Rating> ratings = result.getResultList();

        return ratings;
    }

    @Override
    public void update(Rating rating) {

        inTransaction(em -> { em.merge(rating);});

    }

    @Override
    public Rating findOne(String id) {
        TypedQuery<Rating> result = entityManager.createNamedQuery("find rating by id", Rating.class);
        result.setParameter("id", id);
        return result.getSingleResult();    }

    @Override
    public List<Rating> findByName(String rating_id) {
        TypedQuery<Rating > result = entityManager.createQuery("select s from Rating s where code like %?1% ", Rating.class);
        result.setParameter(1, rating_id);
        List<Rating> ratings = result.getResultList();
        return ratings;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Rating rating = findOne(id);
            em.remove(rating);
        });
    }
}
