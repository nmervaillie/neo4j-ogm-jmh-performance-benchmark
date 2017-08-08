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
public class SimpleEntity236 {

    Long id;

    String name;

    @Relationship(type = "REL")
    List<SimpleEntity236> entities;

    public SimpleEntity236() {
    }

    public SimpleEntity236(String name) {
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

    public List<SimpleEntity236> getEntities() {
        return entities;
    }

    public void setEntities(List<SimpleEntity236> entities) {
        this.entities = entities;
    }
}

