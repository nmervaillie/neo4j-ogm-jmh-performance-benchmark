package org.neo4j.ogm.benchmark.relationship;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@Warmup(iterations = 2, time = 10)
@Measurement(iterations = 5, time = 15, timeUnit = TimeUnit.SECONDS)
public class Neo4jOgmBenchmark {

    @State(Scope.Benchmark)
    public static class SessionState {

        SessionFactory sf = new SessionFactory("org.neo4j.ogm.benchmark");
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
    public Iterable load20kRelationships(SessionState sessionState) {
        return sessionState.getSession().query(Primary.class, "MATCH (n:Primary) WITH n MATCH path=(n)-[*0..]->() RETURN path limit 20000", new HashMap());
    }

    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(".*" + Neo4jOgmBenchmark.class.getSimpleName() + ".*")
                .warmupIterations(3).warmupTime(TimeValue.seconds(10))
                .measurementIterations(10).measurementTime(TimeValue.seconds(20))
                .forks(1)
//                .jvmArgs("-agentpath:/opt/yjp-2015-build-15084/bin/linux-x86-64/libyjpagent.so", "-Xms512m", "-Xmx512m")
                .resultFormat(ResultFormatType.TEXT)
                .build();

        Collection<RunResult> records = new Runner(opts).run();
        for (RunResult result : records) {
            Result r = result.getPrimaryResult();
            System.out.println("API replied benchmark score: "
                    + r.getScore() + " "
                    + r.getScoreUnit() + " over "
                    + r.getStatistics().getN() + " iterations");
            System.out.println(result.getAggregatedResult());
        }
    }

}
