#!/bin/bash

mkdir -p src/main/java/org/neo4j/ogm/benchmark/entityscan/entities/

for i in {1..1000}
do
   cp src/main/resources/SimpleEntityX.java src/main/java/org/neo4j/ogm/benchmark/entityscan/entities/SimpleEntity$i.java

   sed -i "s/SimpleEntityX/SimpleEntity$i/g" src/main/java/org/neo4j/ogm/benchmark/entityscan/entities/SimpleEntity$i.java
done
