package org.example.Model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_film")
@NamedQueries({
        @NamedQuery(name = "find all film", query = "select s from Film s"),
        @NamedQuery(name = "find film by id", query = "select s from Film s where s.movieId = :id")
})
public class Film {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Movie_id")
    private String movieId;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Duration")
    private Integer duration;

    @Column(name = "Show_date")
    private Date showDate;

    @Column(name = "Price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @OneToMany(mappedBy = "film")
    private List<Theater> theater;

    public Film() {
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "movieId='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", showDate=" + showDate +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

}
