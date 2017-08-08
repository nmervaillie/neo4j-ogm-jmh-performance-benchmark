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
public class SimpleEntity116 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity116> entities;

    public SimpleEntity116() {
    }

    public SimpleEntity116(String name) {
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

    public List<SimpleEntity116> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity116> entities) {
        this.entities = entities;
    }
}

