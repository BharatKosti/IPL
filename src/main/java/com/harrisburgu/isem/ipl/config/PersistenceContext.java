package com.harrisburgu.isem.ipl.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by bharatkosti on 4/20/15.
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.harrisburgu.isem.ipl"})
@EnableTransactionManagement
public class PersistenceContext {

  private static final String[] ENTITY_PACKAGES = {
      "com.harrisburgu.isem.ipl"
  };

  private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
  private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
  private static final String PROPERTY_NAME_DB_URL = "db.url";
  private static final String PROPERTY_NAME_DB_USER = "db.username";
  private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
  private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
  private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
  private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
  private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

  @Bean(destroyMethod = "close")
  DataSource dataSource(Environment env)
  {
    HikariConfig hikariConfig = new HikariConfig();
    //hikariConfig.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
    hikariConfig.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
    hikariConfig.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
    hikariConfig.setJdbcUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
    hikariConfig.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
   // hikariConfig.setConnectionTestQuery("show tables");
    return new HikariDataSource(hikariConfig);
  }

  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,Environment env)
  {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

    Properties jpaProperties = new Properties();
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT,env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO,env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
    //jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
                      env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
    jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL,
                      env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

    entityManagerFactoryBean.setJpaProperties(jpaProperties);

    return entityManagerFactoryBean;

  }


  @Bean
  JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory)
  {
    JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

    return jpaTransactionManager;
  }

}
