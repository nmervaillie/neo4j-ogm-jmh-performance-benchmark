package org.neo4j.ogm.benchmark.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.neo4j.ogm.benchmark.movie.domain.Movie;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

@Warmup(iterations = 3, time = 10)
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(2)
public class MovieWriteBenchmark {

    private static final Logger logger = LoggerFactory.getLogger(MovieWriteBenchmark.class);

    @State(Scope.Benchmark)
    public static class SessionState {

        SessionFactory sf = new SessionFactory(new Configuration.Builder(new ClasspathConfigurationSource("ogm.properties")).build(),
                "org.neo4j.ogm.benchmark.movie.domain");

        MovieService movieService;

        @Setup(Level.Trial)
        public void init() {
            Session session = sf.openSession();

            logger.info("Purging database");
            session.purgeDatabase();

            movieService = new MovieService(sf);
        }

    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object createSingleMovie(SessionState sessionState) {
        MovieService movieService = sessionState.movieService;
        return movieService.createMovie("The Matrix", 1999);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object createMovieBatch10(SessionState sessionState) {
        MovieService movieService = sessionState.movieService;
        return movieService.createMovies(testMovieData(10));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object createMovieBatch100(SessionState sessionState) {
        MovieService movieService = sessionState.movieService;
        return movieService.createMovies(testMovieData(100));
    }

    // this takes some time, but should be negligible compared to saving an entity
    private List<Movie> testMovieData(int count) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            movies.add(new Movie("The Matrix " + i, 1999 + i));
        }
        return movies;
    }


}
