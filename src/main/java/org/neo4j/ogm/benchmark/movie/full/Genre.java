package org.neo4j.ogm.benchmark.movie.full;

import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

/**
 * @author Frantisek Hartman
 */
@NodeEntity
public class Genre {

    private Long id;

    private String name;

    @Relationship(type = "IN_GENRE", direction = "INCOMING")
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

    @Relationship(type = "IN_GENRE", direction = "INCOMING")
    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
