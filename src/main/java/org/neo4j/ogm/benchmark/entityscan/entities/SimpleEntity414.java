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
public class SimpleEntity414 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity414> entities;

    public SimpleEntity414() {
    }

    public SimpleEntity414(String name) {
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

    public List<SimpleEntity414> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity414> entities) {
        this.entities = entities;
    }
}

