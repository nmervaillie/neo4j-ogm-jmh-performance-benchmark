package org.neo4j.ogm.benchmark.entityscan.entities;

import java.util.List;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Template for single entity
 *
 * Run src/main/resouces.copy.sh to create copies in sources directory.
 *
 * @author Frantisek Hartman
 */
@NodeEntity
public class SimpleEntity448 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity448> entities;

    public SimpleEntity448() {
    }

    public SimpleEntity448(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SimpleEntity448> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity448> entities) {
        this.entities = entities;
    }
}

