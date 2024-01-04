package com.josh.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<NewUserModel>{

    @Override
    public NewUserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        NewUserModel newLog = new NewUserModel(
            rs.getLong("ID"),
            rs.getString("NAME"),
            rs.getString("LNAME"),
            rs.getString("EMAIL"),
            rs.getString("USERNAME"),
            rs.getString("PASSWORD")
        );
        return newLog;
    }
    
}
