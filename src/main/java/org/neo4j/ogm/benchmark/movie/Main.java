package org.neo4j.ogm.benchmark.movie;

import java.util.Collection;

import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 */
public class Main {

    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
                .include("org\\.neo4j\\.ogm\\.benchmark\\.movie.MovieOgmBenchmark.loadOneMovieDepth2")
                .forks(1)
                .jvmArgs("-XX:+UnlockCommercialFeatures", "-XX:+FlightRecorder","-XX:StartFlightRecording=name=MyRecording,filename=target/myrecording.jfr,settings=profile,dumponexit=true")
                .resultFormat(ResultFormatType.TEXT)
                .build();

        new Runner(opts).run();
    }

}
