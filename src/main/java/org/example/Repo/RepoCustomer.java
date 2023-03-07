package org.example.Repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.Model.Customer;
import org.example.Model.Film;

import java.util.List;

public class RepoCustomer extends Repo implements IRepo<Customer>{

    public RepoCustomer(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Customer customer) {
        inTransaction(((em) -> em.persist(customer) ));
    }

    @Override
    public List<Customer> findAll(Integer page, Integer size) {

        TypedQuery<Customer> result = entityManager.createNamedQuery("find all customer", Customer.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Customer> customers = result.getResultList();
        return customers;    }

    @Override
    public void update(Customer customer) {
        inTransaction(em -> { em.merge(customer);});
    }

    @Override
    public Customer findOne(String id) {

        TypedQuery<Customer> result = entityManager.createNamedQuery("find customer by id", Customer.class);
        result.setParameter("id", id);
        return result.getSingleResult();    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Customer customer = findOne(id);
            em.remove(customer);
        });

    }
}
