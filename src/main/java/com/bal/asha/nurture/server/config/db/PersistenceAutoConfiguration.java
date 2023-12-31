package com.bal.asha.nurture.server.config.db;

import com.bal.asha.nurture.server.NoOpPersistencePackageMarker;
import com.bal.asha.nurture.server.common.domain.CustomRepositoryImpl;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
//@EntityScan(basePackageClasses = {NoOpPersistencePackageMarker.class})
@EnableJpaRepositories(repositoryBaseClass = CustomRepositoryImpl.class, basePackageClasses = {NoOpPersistencePackageMarker.class})
public class PersistenceAutoConfiguration {

   /* @Bean
    public Hibernate6Module hibernate5Module(){
        Hibernate5Module module =new Hibernate5Module();
        module.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        return module;
    }*/

   // @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(){
        return prop -> {
            prop.put("hibernate.id.new_generator_mappings", "true");
            prop.put("hibernate.jdbc.batch_size", "100");
           // prop.put("hibernate.generate_statistics", "true");
            prop.put("hibernate.jdbc.time_zone", "UTC");

        };
    }
}
