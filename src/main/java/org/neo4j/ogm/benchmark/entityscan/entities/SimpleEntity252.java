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
public class SimpleEntity252 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity252> entities;

    public SimpleEntity252() {
    }

    public SimpleEntity252(String name) {
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

    public List<SimpleEntity252> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity252> entities) {
        this.entities = entities;
    }
}

