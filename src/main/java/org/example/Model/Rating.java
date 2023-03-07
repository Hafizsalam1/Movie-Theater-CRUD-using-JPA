package org.example.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "t_rating")
@NamedQueries({
        @NamedQuery(name = "find all rating", query = "select s from Rating s"),
        @NamedQuery(name = "find rating by id", query = "select s from Rating s where s.ratingId = :id")
})

public class Rating {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "rating_id")
    private String ratingId;

    @Column(name = "code", nullable = false, length = 100)
    private org.example.Util.Rating rating;

    @Column(name = "deskripsi", nullable = false, length = 100)
    private String deskripsi;

    @OneToMany(mappedBy = "rating")
    private List<Film> film;

    public Rating() {
    }

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId= ratingId;
    }

    public org.example.Util.Rating getRating() {
        return rating;
    }

    public void setRating(org.example.Util.Rating rating) {
        this.rating = rating;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "ratingId=" + ratingId +
                ", rating=" + rating +
                ", deskripsi='" + deskripsi + '\'' +
                '}';
    }
}
