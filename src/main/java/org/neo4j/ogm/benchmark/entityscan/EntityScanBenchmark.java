package org.neo4j.ogm.benchmark.entityscan;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.infra.Blackhole;

import org.neo4j.ogm.metadata.MetaData;
import org.neo4j.ogm.metadata.ClassInfo;

/**
 * Using Mode.SingleShotTime because we want to capture warm up time
 */
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(10)
public class EntityScanBenchmark {

    @Benchmark
    public Object benchmarkMetadataInit(Blackhole bh ) {
        MetaData metaData = new MetaData("org.neo4j.ogm.benchmark.entityscan.entities");

        for (int i = 1; i < 1000; i++) {
            ClassInfo classInfo = metaData.classInfo("org.neo4j.ogm.benchmark.entityscan.SimpleEntity" + i);
            bh.consume(classInfo);
        }

        return metaData;
    }


}
