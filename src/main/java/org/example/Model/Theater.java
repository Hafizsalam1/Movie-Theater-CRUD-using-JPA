package org.example.Model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "t_theater")
@NamedQueries({
        @NamedQuery(name = "find all theater", query = "select s from Theater s"),
        @NamedQuery(name = "find theater by id", query = "select s from Theater s where s.theaterId = :id"),

})
public class Theater {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "theaterId")
    private String theaterId;

    @Column(name = "Theater Number", unique = true)
    private String theaterNumber;

    @Column(name = "Stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Film film;

    @OneToMany(mappedBy = "theater")
    private List<Seat> seat;

    public Theater() {
    }

    public String getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public String getTheaterNumber() {
        return theaterNumber;
    }

    public void setTheaterNumber(String theaterNumber) {
        this.theaterNumber = theaterNumber;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Theater{" +
                "theaterId='" + theaterId + '\'' +
                ", theaterNumber='" + theaterNumber + '\'' +
                ", stock=" + stock +
                ", film=" + film +
                '}';
    }
}
