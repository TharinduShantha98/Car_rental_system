package lk.ijse.spring.config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "lk.ijse.spring.repo")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class JpaConfig {


    @Autowired
    Environment emv;


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,
                                                                           JpaVendorAdapter jpaVendorAdapter){

        LocalContainerEntityManagerFactoryBean bean =  new LocalContainerEntityManagerFactoryBean();
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(emv.getRequiredProperty("entity_package_name"));
        return bean;

    }


    @Bean
    public DataSource dataSource(){
       /* DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(emv.getRequiredProperty("my_app_url"));
        dataSource.setUsername(emv.getRequiredProperty("my_app_user_name"));
        dataSource.setPassword(emv.getRequiredProperty("my_app_password"));
        dataSource.setDriverClassName(emv.getRequiredProperty("my_app_driverClassName"));
        return dataSource;*/


        BasicDataSource basicDataSource =  new BasicDataSource();
        basicDataSource.setDriverClassName(emv.getRequiredProperty("my_app_driverClassName"));
        basicDataSource.setUrl(emv.getRequiredProperty("my_app_url"));
        basicDataSource.setUsername(emv.getRequiredProperty("my_app_user_name"));
        basicDataSource.setPassword(emv.getRequiredProperty("my_app_password"));
        basicDataSource.setMaxTotal(5);
        basicDataSource.setInitialSize(5);

        return basicDataSource;
    }


    @Bean
    public JpaVendorAdapter jpaVendorAdapter(){
        HibernateJpaVendorAdapter va =  new HibernateJpaVendorAdapter();
        va.setDatabasePlatform(emv.getRequiredProperty("my_app_dialect"));
        va.setDatabase(Database.MYSQL);
        va.setGenerateDdl(true);
        va.setShowSql(true);
        return va;

    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        return new JpaTransactionManager(emf);
    }















}
