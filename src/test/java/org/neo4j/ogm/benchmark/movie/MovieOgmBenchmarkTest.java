package org.neo4j.ogm.benchmark.movie;

import java.util.Collections;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 * @author Frantisek Hartman
 */
public class MovieOgmBenchmarkTest {

    private static SessionFactory sf;

    @BeforeClass
    public static void setUpClass() {
        sf = new SessionFactory("org.neo4j.ogm.benchmark.movie.domain");
    }

    @Test
    public void shoulLoadMovie() throws Exception {
        Session session = sf.openSession();

        session.query("MATCH (m:Movie)-[r:IN_GENRE|DIRECTED]-(n) WHERE id(m) = {id} \n" +
                      "RETURN m,r,n", Collections.singletonMap("id", 2081L));
    }
}
