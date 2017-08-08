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
public class SimpleEntity703 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity703> entities;

    public SimpleEntity703() {
    }

    public SimpleEntity703(String name) {
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

    public List<SimpleEntity703> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity703> entities) {
        this.entities = entities;
    }
}

