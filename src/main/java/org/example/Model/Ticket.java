package org.example.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "trx_ticket")
@NamedQueries({
        @NamedQuery(name = "find all ticket", query = "select s from Ticket s"),
        @NamedQuery(name = "find ticket by id", query = "select s from Ticket s where s.ticketId = :id")
})
public class Ticket {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ticketId")
    private String ticketId;

    @ManyToOne
    @JoinColumn(name = "seatId")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    public Ticket() {
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", seat=" + seat +
                ", customer=" + customer +
                '}';
    }
}
