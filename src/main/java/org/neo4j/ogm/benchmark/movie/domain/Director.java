package org.neo4j.ogm.benchmark.movie.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Frantisek Hartman
 */
public class Director {

    private Long id;

    private String name;

    @Relationship(type = "DIRECTED")
    private Set<Movie> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


}
