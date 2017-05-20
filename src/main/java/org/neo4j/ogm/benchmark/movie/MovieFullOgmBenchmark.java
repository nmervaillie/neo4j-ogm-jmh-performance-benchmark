package org.neo4j.ogm.benchmark.movie;

import java.util.concurrent.TimeUnit;

import org.neo4j.ogm.benchmark.movie.full.Movie;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
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

@Warmup(iterations = 3, time = 10)
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(2)
public class MovieFullOgmBenchmark {

    @State(Scope.Benchmark)
    public static class SessionState {

        SessionFactory sf = new SessionFactory(new Configuration.Builder(new ClasspathConfigurationSource("ogm.properties")).build(),
                                               "org.neo4j.ogm.benchmark.movie.full");
        Session session;

        @Setup(Level.Trial)
        public void init() {
            session = sf.openSession();
        }

        @Setup(Level.Trial)
        public void shutdown() {
            sf.close();
        }

        public Session getSession() {
            return session;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object loadOneMovieDepth1(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.load(Movie.class, id, 1);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object loadOneMovieDepth2(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.load(Movie.class, id, 2);
    }

   /* @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object load100MoviesDepth1(SessionState sessionState) {
        Session session = sessionState.getSession();
        return session.loadAll(Movie.class, new Pagination(0, 100), 1);
    }*/


}
