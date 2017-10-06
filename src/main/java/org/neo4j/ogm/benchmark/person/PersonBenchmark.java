package org.neo4j.ogm.benchmark.person;

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
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;

/**
 * Expects data in neo4j database, see resources/person folder
 */
@Warmup(iterations = 3, time = 10)
@Measurement(iterations = 5, time = 10, timeUnit = TimeUnit.SECONDS)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(1)
public class PersonBenchmark {

    @State(Scope.Benchmark)
    public static class SessionState {

        PersonRepository personRepository;
        private AnnotationConfigApplicationContext context;

        @Setup(Level.Trial)
        public void init() {
            context = new AnnotationConfigApplicationContext(SpringConfig.class);
            personRepository = context.getBean(PersonRepository.class);

            for (int i = 0; i < 1500; i++) {
                personRepository.findAll(new PageRequest(0, 1));
            }
        }


        public PersonRepository getSession() {
            return personRepository;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object queryResultFindAllByQuery(SessionState sessionState) {
        PersonRepository repository = sessionState.getSession();

        return repository.findAllByQuery();
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Object findAll(SessionState sessionState) {
        PersonRepository repository = sessionState.getSession();

        return repository.findAll();
    }




}
