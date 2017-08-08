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
public class SimpleEntity80 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity80> entities;

    public SimpleEntity80() {
    }

    public SimpleEntity80(String name) {
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

    public List<SimpleEntity80> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity80> entities) {
        this.entities = entities;
    }
}

