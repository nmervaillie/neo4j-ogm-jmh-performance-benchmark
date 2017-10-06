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
public class SimpleEntity157 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity157> entities;

    public SimpleEntity157() {
    }

    public SimpleEntity157(String name) {
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

    public List<SimpleEntity157> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity157> entities) {
        this.entities = entities;
    }
}

