package cl.citiaps.spring.backend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "film")
public class Film implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="film_id", unique=true, nullable=false)
    private Integer filmId;

    @Column(name="title", nullable=false, length=255)
    private String title;

    @Column(name="description", nullable=true)
    private String description;

    @Column(name="release_year", nullable=true)
    private Date releaseYear;

    @Column(name="language_id", nullable=false, columnDefinition = "TINYINT(3)")
    private Integer languageId;

    @Column(name="original_language_id", nullable=true, columnDefinition = "TINYINT(3)")
    private Integer originalLanguageId;

    @Column(name="rental_duration", nullable=false, columnDefinition = "TINYINT(3) default 3")
    private Integer rentalDuration;

    @Column(name="rental_rate", nullable=false)
    private BigDecimal rentalRate = BigDecimal.valueOf(4.99);

    @Column(name="length", nullable=true)
    private Integer length;

    @Column(name="replacement_cost", nullable=false)
    private BigDecimal replacementCost = BigDecimal.valueOf(19.99);

    @Column(name="rating", nullable=true)
    private String rating;

    @Column(name="special_features", nullable=true)
    private String specialFeatures;

    @Column(name="last_update", nullable=false)
    private String lastUpdate;

    //Lista que contiene todos los actores de una película
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "films")
    @JsonIgnore
    private List<Actor> actores;

    public Film(){

    }

    public List<Actor> getActores() {
        return this.actores;
    }

    public void addActor(Actor actor) {this.actores.add(actor);}

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
