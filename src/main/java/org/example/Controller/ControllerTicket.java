package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Customer;
import org.example.Model.Seat;
import org.example.Model.Ticket;
import org.example.Repo.*;
import org.example.Service.*;

import java.util.Scanner;

public class ControllerTicket implements IController{
    EntityManager entityManager = Factory.start();

    RepoTheater repoTheater = new RepoTheater(entityManager);
    RepoSeat repoSeat = new RepoSeat(entityManager);
    RepoTicket repoTicket = new RepoTicket(entityManager);
    RepoFilm repoFilm = new RepoFilm(entityManager);

    RepoCustomer repoCustomer = new RepoCustomer(entityManager);


    ServiceTheater serviceTheater = new ServiceTheater(repoTheater);
    ServiceFilm serviceFilm = new ServiceFilm(repoFilm);
    ServiceTicket serviceTicket = new ServiceTicket(repoTicket);
    ServiceSeat serviceSeat = new ServiceSeat(repoSeat);

    ServiceCustomer serviceCustomer = new ServiceCustomer(repoCustomer);

    public ControllerTicket() {
    }

    @Override
    public void create() {
        System.out.println("Masukkan seat ID");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        Seat input2 = serviceSeat.getById(input1);

        System.out.println("Masukkan customer ID");
        Scanner input3 = new Scanner(System.in);
        String input4 = new String(input3.nextLine());
        Customer input5 = serviceCustomer.getById(input4);

        Ticket ticket = new Ticket();
        ticket.setCustomer(input5);
        ticket.setSeat(input2);
        serviceTicket.insert(ticket);


    }

    @Override
    public void findAll() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
