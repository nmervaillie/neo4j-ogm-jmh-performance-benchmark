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
public class SimpleEntity373 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity373> entities;

    public SimpleEntity373() {
    }

    public SimpleEntity373(String name) {
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

    public List<SimpleEntity373> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity373> entities) {
        this.entities = entities;
    }
}

