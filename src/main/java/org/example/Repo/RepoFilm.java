package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Film;
import org.example.Model.Rating;

import java.util.List;

public class RepoFilm extends Repo implements IRepo<Film> {
    public RepoFilm(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Film film) {
        inTransaction(((em) -> em.persist(film) ));

    }

    @Override
    public List<Film> findAll(Integer page, Integer size) {
        TypedQuery<Film> result = entityManager.createNamedQuery("find all film", Film.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Film> films = result.getResultList();
        return films;
    }

    @Override
    public void update(Film film) {

        inTransaction(em -> { em.merge(film);});

    }

    @Override
    public Film findOne(String id) {
        TypedQuery<Film> result = entityManager.createNamedQuery("find film by id", Film.class);
        result.setParameter("id", id);
        return result.getSingleResult();
    }

    @Override
    public List<Film> findByName(String name) {

        TypedQuery<Film> result = entityManager.createQuery("select s from Film s where code like %?1% ", Film.class);
        result.setParameter(1, "id");
        List<Film> films = result.getResultList();
        return films;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Film film = findOne(id);
            em.remove(film);
        });

    }
}
