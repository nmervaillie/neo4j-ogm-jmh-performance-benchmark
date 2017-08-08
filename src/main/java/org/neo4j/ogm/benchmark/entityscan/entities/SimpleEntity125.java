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
public class SimpleEntity125 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity125> entities;

    public SimpleEntity125() {
    }

    public SimpleEntity125(String name) {
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

    public List<SimpleEntity125> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity125> entities) {
        this.entities = entities;
    }
}

