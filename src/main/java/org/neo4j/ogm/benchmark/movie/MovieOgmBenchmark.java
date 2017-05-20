package org.neo4j.ogm.benchmark.movie;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.neo4j.ogm.benchmark.movie.domain.Movie;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.cypher.query.Pagination;
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
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@Warmup(iterations = 3, time = 10)
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(2)
public class MovieOgmBenchmark {

    @State(Scope.Benchmark)
    public static class SessionState {

        SessionFactory sf = new SessionFactory(new Configuration.Builder(new ClasspathConfigurationSource( "ogm.properties")).build(),
                                               "org.neo4j.ogm.benchmark.movie.domain");
        Session session;

        @Setup(Level.Trial)
        public void init() {
            session = sf.openSession();
        }

        /*@Setup(Level.Trial)
        public void shutdown() {
            sf.close();
        }*/

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

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object queryOneMovieDepth1(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.query("MATCH (m:Movie)-[r:IN_GENRE|DIRECTED]-(n) WHERE id(m) = {id} " +
                             "RETURN m,r,n", Collections.singletonMap("id", id));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object queryClassOneMovieDepth1(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.query(Movie.class, "MATCH (m:Movie)-[r:IN_GENRE|DIRECTED]-(n) WHERE id(m) = {id} " +
                                          "RETURN m,r,n", Collections.singletonMap("id", id));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object queryOneMovieDepth2(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.query("MATCH p=(m:Movie)-[r*0..2]-(n) WHERE id(m) = {id} " +
                             "RETURN last(nodes(p)),last(rels(p))",
                             Collections.singletonMap("id", id));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object queryClassOneMovieDepth2(SessionState sessionState) {
        Session session = sessionState.getSession();

        Long id = 2081L; // The Matrix
        return session.query(Movie.class,
                             "MATCH (m:Movie) WHERE id(m) = {id} " +
                             "OPTIONAL MATCH (m)-[rg:IN_GENRE]->(g:Genre) " +
                             "WITH m,collect(rg) AS rgs, collect(g) AS gs " +
                             "OPTIONAL MATCH (m)-[rd:DIRECTED]-(d:Director) " +
                             "OPTIONAL MATCH (d)-[rdm:DIRECTED]-(m2) " +
                             "RETURN m,rgs,gs,collect(rd) AS rds, collect(d) AS ds, collect(rdm) AS rdms,collect(m2) " +
                             "AS m2s ",
                             Collections.singletonMap("id", id));
    }



   /* @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object load100MoviesDepth1(SessionState sessionState) {
        Session session = sessionState.getSession();
        return session.loadAll(Movie.class, new Pagination(0, 100), 1);
    }*/

}
