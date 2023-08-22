package com.works.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class DB {

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public DriverManagerDataSource connect() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    public void login(  String email, boolean enable ) {
        try {
            String sql = "select * from customer where email = ? and enable = ?";
            PreparedStatement st = connect().getConnection().prepareStatement(sql);
            st.setString(1, email);
            st.setBoolean(2, enable);
            ResultSet rs = st.executeQuery();
            boolean status = rs.next();
            System.out.println("Status: " + status);
        }catch (Exception  ex) {
            System.err.println("login error: " + ex);
        }
    }



}
