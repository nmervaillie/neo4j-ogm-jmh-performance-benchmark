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
public class SimpleEntity575 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity575> entities;

    public SimpleEntity575() {
    }

    public SimpleEntity575(String name) {
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

    public List<SimpleEntity575> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity575> entities) {
        this.entities = entities;
    }
}

