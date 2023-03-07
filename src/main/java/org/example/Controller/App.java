package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Repo.*;
import org.example.Service.ServiceFilm;
import org.example.Service.ServiceRating;

import java.util.Scanner;

public class App {
    public void Run(){
         EntityManager entityManager = Factory.start();
         RepoFilm repoFilm = new RepoFilm(entityManager);
         RepoRating repoRating = new RepoRating(entityManager);
        RepoSeat repoSeat = new RepoSeat(entityManager);
        RepoTheater repoTheater = new RepoTheater(entityManager);
        RepoTicket repoTicket = new RepoTicket(entityManager);



        ServiceRating serviceRating = new ServiceRating(repoRating);
         ServiceFilm serviceFilm = new ServiceFilm(repoFilm);
         ControllerCustomer controllerCustomer = new ControllerCustomer();
         ControllerFilm controllerFilm = new ControllerFilm();
         ControllerRating controllerRating = new ControllerRating();
         ControllerSeat controllerSeat = new ControllerSeat();
         ControllerTheater controllerTheater = new ControllerTheater();
         ControllerTicket controllerTicket = new ControllerTicket();

         while(true){
             System.out.println("Welcome to bioskop App");
             System.out.println("1. Customer");
             System.out.println("2. Film");
             System.out.println("3. Rating");
             System.out.println("4. Seat");
             System.out.println("5. Theater");
             System.out.println("6. Pesan tiket");
             System.out.println("7. Exit");


             System.out.println("Masukkan menu yang diinginkan");
             Scanner input = new Scanner(System.in);
             int input1 = Integer.parseInt(input.nextLine());
             switch (input1){
                 case 1:
                     System.out.println("customer");
                     System.out.println("1. Add customer");
                     System.out.println("2. View customer");
                     System.out.println("3. Update customer");
                     System.out.println("4. delete customer");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input2 = new Scanner(System.in);
                     int input3 = Integer.parseInt(input2.nextLine());
                     switch (input3){
                         case 1:
                             controllerCustomer.create();
                             break;
                         case 2:
                             controllerCustomer.findAll();
                             break;
                         case 3:
                             controllerCustomer.update();
                             break;
                         case 4:
                             controllerCustomer.delete();
                             break;

                     }
                     break;

                 case 2:
                     System.out.println("film");
                     System.out.println("1. Add film");
                     System.out.println("2. View film");
                     System.out.println("3. Update film");
                     System.out.println("4. delete film");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input4 = new Scanner(System.in);
                     int input5 = Integer.parseInt(input4.nextLine());

                     switch (input5){
                         case 1:
                             controllerFilm.create();
                             break;
                         case 2:
                             controllerFilm.findAll();
                             break;

                         case 3:
                             controllerFilm.update();
                             break;

                         case 4:
                             controllerFilm.delete();
                             break;
                     }
                     break;

                 case 3:
                     System.out.println("rating");
                     System.out.println("1. Add rating");
                     System.out.println("2. View rating");
                     System.out.println("3. Update rating");
                     System.out.println("4. delete rating");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input6 = new Scanner(System.in);
                     int input7 = Integer.parseInt(input6.nextLine());

                     switch (input7){
                         case 1:
                             controllerRating.create();
                             break;
                         case 2:
                             controllerRating.findAll();
                             break;

                         case 3:
                             controllerRating.update();
                             break;

                         case 4:
                             controllerRating.delete();
                             break;

                     } break;

                 case 4:
                     System.out.println("seat");
                     System.out.println("1. Add seat");
                     System.out.println("2. View seat");
                     System.out.println("3. Update seat");
                     System.out.println("4. delete seat");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input8 = new Scanner(System.in);
                     int input9 = Integer.parseInt(input8.nextLine());
                     switch (input9){
                         case 1:
                             controllerSeat.create();
                             break;
                         case 2:
                             controllerSeat.findAll();
                             break;

                         case 3:
                             controllerSeat.update();
                             break;

                         case 4:
                             controllerSeat.delete();
                             break;

                     } break;

                 case 5:
                     System.out.println("theater");
                     System.out.println("1. Add theater");
                     System.out.println("2. View theater");
                     System.out.println("3. Update theater");
                     System.out.println("4. delete theater");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input10 = new Scanner(System.in);
                     int input11 = Integer.parseInt(input10.nextLine());
                     switch (input11){
                         case 1:
                             controllerTheater.create();
                             break;
                         case 2:
                             controllerTheater.findAll();
                             break;

                         case 3:
                             controllerTheater.update();
                             break;

                         case 4:
                             controllerTheater.delete();
                             break;


                     }break;

                 case 6:
                     System.out.println("theater");
                     System.out.println("1. Add ticket");
                     System.out.println("2. View ticket");
                     System.out.println("3. Update ticket");
                     System.out.println("4. delete ticket");
                     System.out.println("Masukkan menu yang diinginkan");
                     Scanner input12 = new Scanner(System.in);
                     int input13 = Integer.parseInt(input12.nextLine());

                     switch (input13){
                         case 1:
                             controllerTicket.create();
                             break;
                         case 2:
                             controllerTicket.findAll();
                             break;

                         case 3:
                             controllerTicket.update();
                             break;

                         case 4:
                             controllerTicket.delete();
                             break;

                     }




                 }break;
             }

         }




    }






