package org.example.Model;

import jakarta.persistence.*;
import org.example.Util.Rating;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "m_customer")
@NamedQueries({
        @NamedQuery(name = "find all customer", query = "select s from Customer s"),
        @NamedQuery(name = "find customer by id", query = "select s from Customer s where s.customerId = :id")
})

public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Customer_id")
    private String customerId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="birthdate")
    private Date birthdate;

    @OneToMany(mappedBy = "customer")
    private List<Ticket> ticket;

    public Customer() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", Name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
