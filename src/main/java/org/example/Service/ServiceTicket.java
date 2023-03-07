package org.example.Service;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.*;
import org.example.Repo.*;
import org.example.Util.generateDate;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

public class ServiceTicket implements IService<Ticket>{

    private RepoTicket repoTicket;
    private RepoCustomer repoCustomer;

    private RepoSeat repoSeat;


    private RepoFilm repoFilm;

    EntityManager entityManager = Factory.start();

    RepoTheater repoTheater = new RepoTheater(entityManager);



    public ServiceTicket(RepoTicket repoTicket) {
        this.repoTicket = repoTicket;
    }

    ServiceTheater serviceTheater = new ServiceTheater(repoTheater);

    @Override
    public void insert(Ticket ticket) {
        Seat seat = ticket.getSeat();
        Theater theater = seat.getTheater();
        Film film = theater.getFilm();
        Rating rating = film.getRating();
        Integer stockChair = theater.getStock();


        Customer customer = ticket.getCustomer();
        Date birthdate = customer.getBirthdate();
        Date now = generateDate.generate("2023-03-20");


        long age = now.getTime()-birthdate.getTime();

        long ageYear = age/(1000L * 60 * 60 * 24 * 365);

        int ageInt=(int)ageYear;


        if(rating.getRating() == org.example.Util.Rating.A ){
            if (stockChair>0){
                System.out.println(ticket);
                repoTicket.create(ticket);
                stockChair = stockChair-1;
                theater.setStock(stockChair);
                theater.setTheaterId(theater.getTheaterId());
                serviceTheater.update(theater);
                System.out.println("Tiket berhasil dipesan");

            }
            else{
                System.out.println("Kursi habis");
            }

        }

        else if(ageInt>=21){
            if (stockChair>0){
                System.out.println(ticket);
                repoTicket.create(ticket);
                stockChair = stockChair-1;
                theater.setStock(stockChair);
                theater.setTheaterId(theater.getTheaterId());
                serviceTheater.update(theater);
                System.out.println("Tiket berhasil dipesan");

            }
            else{
                System.out.println("Kursi habis");
            }

        }
        else if(ageInt>=18 && (rating.getRating() == org.example.Util.Rating.R || rating.getRating() == org.example.Util.Rating.BO || rating.getRating() == org.example.Util.Rating.A)) {
            if (stockChair>0){
                System.out.println(ticket);
                repoTicket.create(ticket);
                stockChair = stockChair-1;
                theater.setStock(stockChair);
                theater.setTheaterId(theater.getTheaterId());
                serviceTheater.update(theater);
                System.out.println("Tiket berhasil dipesan");

            }
            else{
                System.out.println("Kursi habis");
            }

        } else if (ageInt>=13 && (rating.getRating()== org.example.Util.Rating.BO || rating.getRating() == org.example.Util.Rating.A)) {
            if (stockChair>0){
                System.out.println(ticket);
                repoTicket.create(ticket);
                stockChair = stockChair-1;
                theater.setStock(stockChair);
                theater.setTheaterId(theater.getTheaterId());
                serviceTheater.update(theater);
                System.out.println("Tiket berhasil dipesan");

            }
            else{
                System.out.println("Kursi habis");
            }

        }
        else{
            System.out.println("Umur tidak mencukupi");
        }



    }

    @Override
    public void delete(String id) {
        repoTicket.delete(id);
    }

    @Override
    public void update(Ticket ticket) {
        repoTicket.update(ticket);

    }

    @Override
    public Ticket getById(String id) {
        Ticket ticket = repoTicket.findOne(id);
        return ticket;
    }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Ticket> tickets = repoTicket.findAll(page, size);
        tickets.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
