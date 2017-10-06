package org.neo4j.ogm.benchmark.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.neo4j.ogm.config.Configuration.Builder;
import org.neo4j.ogm.session.SessionFactory;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories
public class SpringConfig {

	@Autowired
	private Environment env;

	@Bean
	public org.neo4j.ogm.config.Configuration getConfiguration() {
		Builder configBuilder = new org.neo4j.ogm.config.Configuration.Builder();
		configBuilder
				.uri("bolt://localhost");
		return configBuilder.build();
	}

	@Bean
	public SessionFactory sessionFactory() {
	    return new SessionFactory(getConfiguration(), Person.class.getPackage().getName());
	}

	@Bean
	public Neo4jTransactionManager transactionManager() {
	    return new Neo4jTransactionManager();
	}

}
