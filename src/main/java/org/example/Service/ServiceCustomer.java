package org.example.Service;

import org.example.Model.Customer;
import org.example.Model.Rating;
import org.example.Repo.RepoCustomer;
import org.example.Repo.RepoFilm;

import java.util.List;

public class ServiceCustomer implements IService<Customer>{

    private RepoCustomer repoCustomer;

    public ServiceCustomer(RepoCustomer repoCustomer) {
        this.repoCustomer = repoCustomer;
    }

    @Override
    public void insert(Customer customer) {
        System.out.println(customer);
        repoCustomer.create(customer);
    }

    @Override
    public void delete(String id) {
        repoCustomer.delete(id);
    }

    @Override
    public void update(Customer customer) {
        repoCustomer.update(customer);

    }

    @Override
    public Customer getById(String id) {

        Customer customer = repoCustomer.findOne(id);
        return customer;
    }

    @Override
    public void getAll(Integer page, Integer size) {
        List<Customer> customers = repoCustomer.findAll(page, size);
        customers.forEach(System.out::println);
    }

    @Override
    public void getAllByName(String name) {

    }
}
