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
public class SimpleEntity390 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity390> entities;

    public SimpleEntity390() {
    }

    public SimpleEntity390(String name) {
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

    public List<SimpleEntity390> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity390> entities) {
        this.entities = entities;
    }
}

