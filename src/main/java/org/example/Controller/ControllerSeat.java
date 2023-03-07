package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Rating;
import org.example.Model.Seat;
import org.example.Model.Theater;
import org.example.Repo.RepoRating;
import org.example.Repo.RepoSeat;
import org.example.Repo.RepoTheater;
import org.example.Service.ServiceRating;
import org.example.Service.ServiceSeat;
import org.example.Service.ServiceTheater;

import java.util.Scanner;

public class ControllerSeat implements IController {
    public ControllerSeat() {
    }

    EntityManager entityManager = Factory.start();

    RepoSeat repoSeat = new RepoSeat(entityManager);
    ServiceSeat serviceSeat = new ServiceSeat(repoSeat);

    RepoTheater repoTheater = new RepoTheater(entityManager);
    ServiceTheater serviceTheater = new ServiceTheater(repoTheater);

    @Override
    public void create() {
        System.out.println("Masukkan seat number baru");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        System.out.println("Masukkan theaterId");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Theater input4 = serviceTheater.getById(input3);
        Seat seat = new Seat();
        seat.setSeatNumber(input1);
        seat.setTheater(input4);
        serviceSeat.insert(seat);
        System.out.println("Data seat ditambahkan");
    }

    @Override
    public void findAll() {
        System.out.println("Masukkan nilai page");
        Scanner input = new Scanner(System.in);
        int input1 = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nilai page size");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        serviceSeat.getAll(input1,input3);
    }

    @Override
    public void update() {
        System.out.println("Masukkan seat id dri seat yang ingin diupdate");
        Scanner input5 = new Scanner(System.in);
        String input6 = new String(input5.nextLine());
        System.out.println("Masukkan seat number");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        System.out.println("Masukkan theaterId");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Theater input4 = serviceTheater.getById(input3);
        Seat seat = new Seat();
        seat.setSeatId(input6);
        seat.setSeatNumber(input1);
        seat.setTheater(input4);
        serviceSeat.update(seat);
        System.out.println("Data seat diupdate");
    }

    @Override
    public void delete() {
        System.out.println("Masukkan id seatyang ingin dihapus");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        serviceSeat.delete(input1);

    }
}
