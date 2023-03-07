package org.example.Service;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Seat;
import org.example.Model.Theater;
import org.example.Repo.RepoSeat;
import org.example.Repo.RepoTheater;

import java.util.List;

public class ServiceSeat implements IService<Seat>{
    EntityManager entityManager = Factory.start();

    RepoTheater repoTheater = new RepoTheater(entityManager);
    ServiceTheater serviceTheater = new ServiceTheater(repoTheater);


    private RepoSeat repoSeat;


    public ServiceSeat(RepoSeat repoSeat) {
        this.repoSeat = repoSeat;
    }

    @Override
    public void insert(Seat seat) {

        System.out.println(seat);
        repoSeat.create(seat);
        Theater theater = seat.getTheater();
        Integer stockChair = theater.getStock();
        stockChair = stockChair+1;
        theater.setStock(stockChair);
        theater.setTheaterId(theater.getTheaterId());
        serviceTheater.update(theater);


    }

    @Override
    public void delete(String id) {
        repoSeat.delete(id);

    }

    @Override
    public void update(Seat seat) {
        repoSeat.update(seat);
    }

    @Override
    public Seat getById(String id) {

        Seat seat = repoSeat.findOne(id);
        return seat;
    }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Seat> seats = repoSeat.findAll(page, size);
        seats.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
