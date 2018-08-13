/*
package com.hand.infra.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;


*/
/*MYSQL_IP: mysql-1
        MYSQL_PORT: 3306*//*

@ComponentScan
@Configuration
public class MyConfig {

    @Autowired
    private Environment env;




    @Bean
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();

        // 本地测试
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");

//        //    docker环境变量
        String mysql_ip = env.getProperty("MYSQL_IP");
        String mysql_port = env.getProperty("MYSQL_PORT");
        String url = "jdbc:mysql://"+mysql_ip+":"+mysql_port+"/sakila?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true";
        String username = env.getProperty("USERNAME");
        String password = env.getProperty("PASSWORD");
        dataSource.setDriverClassName(env.getProperty("driverName"));

        dataSource.setUrl(env.getProperty("url"));
        dataSource.setUsername(env.getProperty("username"));
        dataSource.setPassword(env.getProperty("password"));
        return dataSource;
    }
}
*/
