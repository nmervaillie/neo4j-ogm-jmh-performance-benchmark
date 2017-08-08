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
public class SimpleEntity588 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity588> entities;

    public SimpleEntity588() {
    }

    public SimpleEntity588(String name) {
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

    public List<SimpleEntity588> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity588> entities) {
        this.entities = entities;
    }
}

