package org.example.Service;

import org.example.Model.Rating;
import org.example.Repo.RepoRating;

import java.util.List;

public class ServiceRating implements IService<Rating>{
    private RepoRating repoRating;

    public ServiceRating(RepoRating repoRating) {
        this.repoRating = repoRating;
    }

    @Override
    public void insert(Rating rating) {
        System.out.println(rating);
        repoRating.create(rating);
    }

    @Override
    public void delete(String id) {
        repoRating.delete(id);
    }
    @Override
    public void update(Rating rating) {

        repoRating.update(rating);
    }

    @Override
    public Rating getById(String id) {
        Rating rating = repoRating.findOne(id);
        return rating;
    }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Rating> ratings = repoRating.findAll(page, size);
        ratings.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
