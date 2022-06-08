package com.ticketapp.accountservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@EnableCassandraRepositories
@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${accountservice.cassandra.keyspace.name}")
    private String keyspaceName;

    @Value("${accountservice.cassandra.port}")
    private int port;

    @Value("${accountservice.cassandra.contact.point}")
    private String contactPoints;

    @Value("${accountservice.cassandra.username}")
    private String username;

    @Value("${accountservice.cassandra.password}")
    private String password;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactPoints;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.ticketapp.accountservice"};
    }

    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean cqlSessionFactoryBean = super.cassandraSession();
        cqlSessionFactoryBean.setUsername(username);
        cqlSessionFactoryBean.setPassword(password);
        return cqlSessionFactoryBean;
    }


}
