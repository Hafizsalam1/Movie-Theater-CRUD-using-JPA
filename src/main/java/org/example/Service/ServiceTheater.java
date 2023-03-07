package org.example.Service;

import org.example.Model.Customer;
import org.example.Model.Theater;
import org.example.Repo.RepoCustomer;
import org.example.Repo.RepoTheater;

import java.util.List;

public class ServiceTheater implements IService<Theater>{
    private RepoTheater repoTheater;

    public ServiceTheater(RepoTheater repoTheater) {
        this.repoTheater = repoTheater;
    }


    @Override
    public void insert(Theater theater) {
        System.out.println(theater);
        repoTheater.create(theater);
    }

    @Override
    public void delete(String id) {
        repoTheater.delete(id);

    }

    @Override
    public void update(Theater theater) {
        repoTheater.update(theater);
    }

    @Override
    public Theater getById(String id) {
        Theater theater = repoTheater.findOne(id);
        return theater;        }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Theater> theaters = repoTheater.findAll(page, size);
        theaters.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
