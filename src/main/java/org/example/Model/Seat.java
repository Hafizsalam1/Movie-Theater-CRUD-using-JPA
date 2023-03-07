package org.example.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "t_seat")
@NamedQueries({
        @NamedQuery(name = "find all seat", query = "select s from Seat s"),
        @NamedQuery(name = "find seat by id", query = "select s from Seat s where s.seatId = :id")
//        @NamedQuery(name = "count seat" , query = "Select Count(s) from Seat s where s.theater = :id")

})

public class Seat {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "seat_id")
    private String seatId;

    @Column(name = "seat number", nullable = false, length = 100)
    private String seatNumber;

    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    @OneToMany(mappedBy = "seat")
    private List<Ticket> ticket;

    public Seat() {
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
