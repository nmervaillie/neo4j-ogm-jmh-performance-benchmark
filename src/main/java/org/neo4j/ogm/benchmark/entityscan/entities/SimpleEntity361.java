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
public class SimpleEntity361 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity361> entities;

    public SimpleEntity361() {
    }

    public SimpleEntity361(String name) {
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

    public List<SimpleEntity361> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity361> entities) {
        this.entities = entities;
    }
}

