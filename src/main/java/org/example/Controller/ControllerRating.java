package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Rating;
import org.example.Repo.RepoCustomer;
import org.example.Repo.RepoRating;
import org.example.Service.ServiceCustomer;
import org.example.Service.ServiceRating;

import java.util.List;
import java.util.Scanner;

public class ControllerRating implements IController{

    EntityManager entityManager = Factory.start();

    RepoRating repoRating = new RepoRating(entityManager);
    ServiceRating serviceRating = new ServiceRating(repoRating);


    public ControllerRating() {
    }


    @Override
    public void create() {
        System.out.println("Masukkan rating baru");
        Scanner input = new Scanner(System.in);
        org.example.Util.Rating input1 = org.example.Util.Rating.valueOf(input.nextLine());
        System.out.println("Masukkan deskripsi rating baru");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Rating rating = new Rating();
        rating.setRating(input1);
        rating.setDeskripsi(input3);
        serviceRating.insert(rating);
        System.out.println("Data rating ditambahkan");
    }

    @Override
    public void findAll() {
        System.out.println("Masukkan nilai page");
        Scanner input = new Scanner(System.in);
        int input1 = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nilai page size");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        serviceRating.getAll(input1,input3);

    }

    @Override
    public void update() {
        System.out.println("Masukkan Id rating dari rating yang ingin diupdate");
        Scanner input4 = new Scanner(System.in);
        String input5 = new String(input4.nextLine());

        System.out.println("Masukkan rating baru");
        Scanner input = new Scanner(System.in);
        org.example.Util.Rating input1 = org.example.Util.Rating.valueOf(input.nextLine());
        System.out.println("Masukkan deskripsi rating baru");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Rating rating = new Rating();
        rating.setRatingId(input5);
        rating.setRating(input1);
        rating.setDeskripsi(input3);
        serviceRating.update(rating);
        System.out.println("Data rating diupdate");


    }


    @Override
    public void delete() {
        System.out.println("Masukkan id rating yang ingin dihapus");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        serviceRating.delete(input1);
    }
}
