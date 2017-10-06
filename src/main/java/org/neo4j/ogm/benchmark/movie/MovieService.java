package org.neo4j.ogm.benchmark.movie;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import org.neo4j.ogm.benchmark.movie.domain.Movie;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;

/**
 * @author Frantisek Hartman
 */
public class MovieService {

    private SessionFactory sf;

    public MovieService(SessionFactory sf) {
        this.sf = sf;
    }

    public Movie createMovie(String title, Integer year) {
        return runInTransaction((session) -> {
            Movie movie = new Movie(title, year);
            session.save(movie);
            return movie;
        });
    }


    public List<Movie> createMovies(List<Movie> movies) {
        return runInTransaction((session) -> {
            session.save(movies);
            return movies;
        });
    }

    <T> T runInTransaction(Function<Session, T> supplier) {
        Session session = sf.openSession();

        try(Transaction tx = session.beginTransaction()) {
            T result = supplier.apply(session);
            tx.commit();
            return result;
        }
    }
}
