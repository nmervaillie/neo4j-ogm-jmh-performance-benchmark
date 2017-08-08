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
public class SimpleEntity128 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity128> entities;

    public SimpleEntity128() {
    }

    public SimpleEntity128(String name) {
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

    public List<SimpleEntity128> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity128> entities) {
        this.entities = entities;
    }
}

