package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Film;
import org.example.Model.Theater;
import org.example.Repo.RepoFilm;
import org.example.Repo.RepoSeat;
import org.example.Repo.RepoTheater;
import org.example.Service.ServiceFilm;
import org.example.Service.ServiceSeat;
import org.example.Service.ServiceTheater;

import java.util.Scanner;

public class ControllerTheater implements IController{
    EntityManager entityManager = Factory.start();

    RepoTheater repoTheater = new RepoTheater(entityManager);
    ServiceTheater serviceTheater = new ServiceTheater(repoTheater);
    RepoFilm repoFilm = new RepoFilm(entityManager);
    ServiceFilm serviceFilm = new ServiceFilm(repoFilm);
    public ControllerTheater() {

    }

    @Override
    public void create() {
        System.out.println("Masukkan theater number baru");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        System.out.println("Masukkan Movie ID teater baru");
        Scanner input4 = new Scanner(System.in);
        String input5 = new String(input4.nextLine());
        Film input6 = serviceFilm.getById(input5);
        Theater theater = new Theater();
        theater.setTheaterNumber(input1);
        theater.setStock(0);
        theater.setFilm(input6);
        serviceTheater.insert(theater);
    }

    @Override
    public void findAll() {
        System.out.println("Masukkan nilai page");
        Scanner input = new Scanner(System.in);
        int input1 = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nilai page size");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        serviceTheater.getAll(input1,input3);
    }

    @Override
    public void update() {
        System.out.println("Masukkan id theater dari theater yang ingin diupdate");
        Scanner input7 = new Scanner(System.in);
        String input8 = new String(input7.nextLine());
        System.out.println("Masukkan theater number");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        System.out.println("Masukkan stock theater");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        System.out.println("Masukkan Movie ID teater");
        Scanner input4 = new Scanner(System.in);
        String input5 = new String(input4.nextLine());
        Film input6 = serviceFilm.getById(input5);
        Theater theater = new Theater();
        theater.setTheaterId(input8);
        theater.setTheaterNumber(input1);
        theater.setStock(input3);
        theater.setFilm(input6);
        serviceTheater.update(theater);
        System.out.println("Data theater diupdate");

    }


    @Override
    public void delete() {
        System.out.println("Masukkan id theater yang ingin dihapus");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        serviceTheater.delete(input1);
    }
}
