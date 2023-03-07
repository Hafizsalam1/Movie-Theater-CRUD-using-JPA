package org.example.Controller;

import jakarta.persistence.EntityManager;
import org.example.Config.Factory;
import org.example.Model.Customer;
import org.example.Repo.RepoCustomer;
import org.example.Repo.RepoFilm;
import org.example.Service.ServiceCustomer;
import org.example.Util.generateDate;

import java.util.Date;
import java.util.Scanner;

public class ControllerCustomer implements IController{

    EntityManager entityManager = Factory.start();

    RepoCustomer repoCustomer = new RepoCustomer(entityManager);
    ServiceCustomer serviceCustomer = new ServiceCustomer(repoCustomer);
    public ControllerCustomer() {
    }


    @Override
    public void create() {
        System.out.println("Masukkan nama customer baru");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());

        System.out.println("Masukkan birthdate customer baru");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Customer customer = new Customer();
        customer.setName(input1);
        customer.setBirthdate(generateDate.generate(input3));
        serviceCustomer.insert(customer);
        System.out.println("Data customer berhasil ditambahkan");

    }

    @Override
    public void findAll() {
        System.out.println("Masukkan nilai page");
        Scanner input = new Scanner(System.in);
        int input1 = Integer.parseInt(input.nextLine());
        System.out.println("Masukkan nilai page size");
        Scanner input2 = new Scanner(System.in);
        int input3 = Integer.parseInt(input2.nextLine());
        serviceCustomer.getAll(input1,input3);
    }

    @Override
    public void update() {
        System.out.println("Masukkan customer id dari customer yang ingin diupdate");
        Scanner input4 = new Scanner(System.in);
        String input5 = new String(input4.nextLine());


        System.out.println("Masukkan nama customer");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());

        System.out.println("Masukkan birthdate customer");
        Scanner input2 = new Scanner(System.in);
        String input3 = new String(input2.nextLine());
        Customer customer = new Customer();
        customer.setCustomerId(input5);
        customer.setName(input1);
        customer.setBirthdate(generateDate.generate(input3));
        serviceCustomer.update(customer);
        System.out.println("Data customer berhasil diupdate");


    }

    @Override
    public void delete() {
        System.out.println("Masukkan id customer yang ingin dihapus");
        Scanner input = new Scanner(System.in);
        String input1 = new String(input.nextLine());
        serviceCustomer.delete(input1);
    }
}
