package com.crud.smog.service;

import com.crud.smog.config.DbConfig;
import org.springframework.beans.factory.annotation.Autowired;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbManager {
    private static Connection conn;
    private static DbManager dbManagerInstance;
    @Autowired
    private DbConfig dbConfig;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties ();
        connectionProps.put("user", "lukasz_lizewski");
        connectionProps.put("password", "My$zy320");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lukasz_lizewski_Api?serverTimezone=Europe/Warsaw&useSSL=False&allowPublicKeyRetrieval=true",
                connectionProps);
    }
    public static DbManager getInstance() throws SQLException{
        if (dbManagerInstance == null){
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }
    public Connection getConnection(){
        return conn;
    }
}

