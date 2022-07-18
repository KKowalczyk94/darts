package com.javafee.darts.back.config;

import jakarta.persistence.Entity;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class HibernateConfig {
    @Getter
    private static Session session;

    static {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Map<String, Object> settings = Map.of(
                Environment.DRIVER, "org.postgresql.Driver",
                Environment.URL, AppProperties.value("db.connstr"), // jdbc:postgresql://localhost:5432/test",
                Environment.USER, AppProperties.value("db.user"), // "postgres",
                Environment.PASS, AppProperties.value("db.password"), // "admin123",
                Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect",
                Environment.HBM2DDL_AUTO, "create");
        registryBuilder.applySettings(settings);
        StandardServiceRegistry registry = registryBuilder.build();

        Reflections reflections = new Reflections("com.javafee.darts.back.domain");
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(Entity.class);

        MetadataSources sources = new MetadataSources(registry);
        classes.forEach(sources::addAnnotatedClass);

        Metadata metadata = sources.getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
    }
}
