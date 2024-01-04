package com.josh.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public class UserEntity {
    @Id
    @Column("ID")
    Long Id;
    
    @Column("NAME")
    String Name;
    @Column("LNAME")
    String LName;
    @Column("EMAIL")
    String Email;
    @Column("USERNAME")
    String Username;
    @Column("PASSWORD")
    String Password;
    
    public UserEntity() {
    }

    public UserEntity(Long id, String name, String lName, String email, String username, String password) {
        Id = id;
        Name = name;
        LName = lName;
        Email = email;
        Username = username;
        Password = password;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String lName) {
        LName = lName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "UserEntity [Id=" + Id + ", Name=" + Name + ", LName=" + LName + ", Email=" + Email + ", Username="
                + Username + ", Password=" + Password + "]";
    }

    
}
