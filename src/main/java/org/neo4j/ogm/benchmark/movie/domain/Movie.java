package org.neo4j.ogm.benchmark.movie.domain;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
public class Movie {

    private Long id;

    private String movieId;

    private String title;
    private String plot;

    private Integer year;
    private List<String> languages;
    private List<String> countries;

    @Relationship(type = "IN_GENRE")
    private Set<Genre> genres;

    @Relationship(type = "DIRECTED", direction = "INCOMING")
    private Set<Director> directors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public Set<Director> getDirectors() {
        return directors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    @Relationship(type = "IN_GENRE")
    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    @Relationship(type = "DIRECTED", direction = "INCOMING")
    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }
}
