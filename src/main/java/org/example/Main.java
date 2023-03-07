package org.example;
import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Controller.App;
import org.example.Model.*;
import org.example.Repo.*;
import org.example.Service.*;
import org.example.Util.generateDate;

public class Main {


    public static void main(String[] args) {

        App app = new App();
        app.Run();













    }
//    static void insertRating(){
//        Rating rating = new Rating();
//        rating.setRating(org.example.Util.Rating.A);
//        rating.setDeskripsi("Anak-anak");
//
//        Rating rating1 = new Rating();
//        rating1.setRating(org.example.Util.Rating.R);
//        rating1.setDeskripsi("Remaja");
//
//        Rating rating2 = new Rating();
//        rating2.setRating(org.example.Util.Rating.BO);
//        rating2.setDeskripsi("Bimbingan Orangtua");
//
//        Rating rating3 = new Rating();
//        rating3.setRating(org.example.Util.Rating.D);
//        rating3.setDeskripsi("Dewasa");
//
//        serviceRating.insert(rating);
//        serviceRating.insert(rating1);
//        serviceRating.insert(rating2);
//        serviceRating.insert(rating3);
//
//
//
//
//    }
}