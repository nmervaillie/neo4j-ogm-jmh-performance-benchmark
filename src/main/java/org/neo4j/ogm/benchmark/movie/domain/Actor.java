package org.neo4j.ogm.benchmark.movie.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
public class Actor {

    private Long id;

    private String name;

    @Relationship(type = "ACTED_IN")
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

    @Relationship(type = "ACTED_IN")
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
