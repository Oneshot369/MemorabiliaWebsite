package com.josh.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MemMapper implements RowMapper<MemModel>{

    @Override
    public MemModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        MemModel newMem = new MemModel(
            rs.getLong("ID"),
            rs.getString("IMG"),
            rs.getString("PRODUCT_NAME"),
            rs.getFloat("PRICE"),
            rs.getString("DESCRIPTION")  
        );
        return newMem;
    }
    
}
