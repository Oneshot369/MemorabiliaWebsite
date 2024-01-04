package com.josh.demo.database;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.josh.model.LoginModel;
import com.josh.model.NewUserModel;
import com.josh.model.UserMapper;

public class UserSQLDatabase {
    
    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbc;

    public UserSQLDatabase(DataSource data) {
        this.dataSource = data;
        jdbc = new JdbcTemplate(dataSource);
    }

    public List<NewUserModel> getLogins(){
        return jdbc.query(
            "select * from user", 
            new UserMapper()
            );
    }

    public void addUser(NewUserModel userToAdd){
        jdbc.update("insert into user (NAME, LNAME, EMAIL, USERNAME, PASSWORD) values (?, ?, ?, ?, ?)",
            userToAdd.getName(),
            userToAdd.getLName(),
            userToAdd.getEmail(),
            userToAdd.getUsername(),
            userToAdd.getPassword()
        );
    }
}
