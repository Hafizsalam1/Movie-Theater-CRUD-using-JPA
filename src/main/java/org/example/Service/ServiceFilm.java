package org.example.Service;
import org.example.Model.Film;
import org.example.Model.Rating;
import org.example.Repo.RepoFilm;

import java.util.List;

public class ServiceFilm implements IService<Film>{
    private RepoFilm repoFilm;


    public ServiceFilm(RepoFilm repoFilm) {
        this.repoFilm = repoFilm;
    }



    @Override
    public void insert(Film film) {
        System.out.println(film);
        repoFilm.create(film);


    }

    @Override
    public void delete(String id) {
        repoFilm.delete(id);
    }

    @Override
    public void update(Film film) {
        repoFilm.update(film);

    }

    @Override
    public Film getById(String id) {
        Film film = repoFilm.findOne(id);
        return film;     }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Film> films = repoFilm.findAll(page, size);
        films.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
