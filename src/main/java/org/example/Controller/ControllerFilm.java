package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Film;
import org.example.Model.Rating;
import org.example.Repo.RepoCustomer;
import org.example.Repo.RepoFilm;
import org.example.Repo.RepoRating;
import org.example.Service.ServiceCustomer;
import org.example.Service.ServiceFilm;
import org.example.Service.ServiceRating;
import org.example.Util.generateDate;

import java.util.Date;
import java.util.Scanner;

public class ControllerFilm implements IController{
    public ControllerFilm() {
    }

    EntityManager entityManager = Factory.start();

    RepoFilm repoFilm = new RepoFilm(entityManager);

    RepoRating repoRating = new RepoRating(entityManager);
    ServiceFilm serviceFilm = new ServiceFilm(repoFilm);

     ServiceRating serviceRating = new ServiceRating(repoRating);

    @Override
    public void create() {
        System.out.println("Masukkan judul film baru");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());

        System.out.println("Masukkan Show date film baru");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());

        System.out.println("Masukkan harga film baru");
        Scanner input4 = new Scanner(System.in);
        int input5 = Integer.parseInt(input4.nextLine());

        System.out.println("Masukkan durasi film baru");
        Scanner input6 = new Scanner(System.in);
        int input7 = Integer.parseInt(input6.nextLine());

        System.out.println("Masukkan id rating film baru");
        Scanner input8 = new Scanner(System.in);
        String input9 = new String(input8.nextLine());
        Rating input10 = serviceRating.getById(input9);
        Film film = new Film();
        film.setTitle(input1);
        film.setShowDate(generateDate.generate(input3));
        film.setPrice(input5);
        film.setDuration(input7);
        film.setRating(input10);
        serviceFilm.insert(film);
        System.out.println("Data film ditambahkan");
    }

    @Override
    public void findAll() {
        System.out.println("Masukkan nilai page");
        Scanner input = new Scanner(System.in);
        int input1 = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nilai page size");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        serviceFilm.getAll(input1,input3);
    }

    @Override
    public void update() {
        System.out.println("Masukkan Id film dari film yang ingin di update");
        Scanner input11 = new Scanner(System.in);
        String input12 = new String(input11.nextLine());

        System.out.println("Masukkan judul film");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());

        System.out.println("Masukkan Show date film");
        Scanner input2 = new Scanner(System.in);
        Date input3 = new Date(input2.nextLine());

        System.out.println("Masukkan harga film");
        Scanner input4 = new Scanner(System.in);
        int input5 = Integer.parseInt(input4.nextLine());

        System.out.println("Masukkan durasi film");
        Scanner input6 = new Scanner(System.in);
        int input7 = Integer.parseInt(input6.nextLine());

        System.out.println("Masukkan id rating film");
        Scanner input8 = new Scanner(System.in);
        String input9 = new String(input8.nextLine());
        Rating input10 = serviceRating.getById(input9);
        Film film = new Film();
        film.setMovieId(input12);
        film.setTitle(input1);
        film.setShowDate(input3);
        film.setPrice(input5);
        film.setDuration(input7);
        film.setRating(input10);
        serviceFilm.update(film);
        System.out.println("Data film ditambahkan");
    }




    @Override
    public void delete() {
        System.out.println("Masukkan id rating yang ingin dihapus");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        serviceFilm.delete(input1);

    }
}
