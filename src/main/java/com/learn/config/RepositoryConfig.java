package com.learn.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.learn.dao.jpa")
@EnableElasticsearchRepositories(basePackages = "com.learn.dao.elastic")
public class RepositoryConfig {

}
