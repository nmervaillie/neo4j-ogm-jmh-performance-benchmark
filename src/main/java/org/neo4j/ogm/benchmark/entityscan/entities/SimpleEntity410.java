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
public class SimpleEntity410 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity410> entities;

    public SimpleEntity410() {
    }

    public SimpleEntity410(String name) {
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

    public List<SimpleEntity410> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity410> entities) {
        this.entities = entities;
    }
}

