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
public class SimpleEntity983 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity983> entities;

    public SimpleEntity983() {
    }

    public SimpleEntity983(String name) {
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

    public List<SimpleEntity983> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity983> entities) {
        this.entities = entities;
    }
}

