package net.dautricourt.tp_techno_web;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by @HugoD <hg.dautricourt@gmail.com> on 07/04/2022
 */
@Configuration
public class DataSourceConfig {


    @Bean
    public DataSource getDataSource(){
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.hsqldb.jdbc.JDBCDriver");
        dataSourceBuilder.url("jdbc:hsqldb:hsql://localhost:9001/test");
        dataSourceBuilder.username("SA");
        return dataSourceBuilder.build();
    }


}
