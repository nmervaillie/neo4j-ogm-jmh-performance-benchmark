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
public class SimpleEntity181 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity181> entities;

    public SimpleEntity181() {
    }

    public SimpleEntity181(String name) {
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

    public List<SimpleEntity181> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity181> entities) {
        this.entities = entities;
    }
}

