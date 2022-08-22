package com.jungle.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // this class is mapped to user_table in my database
@Table(name = "user_table")
public class User {

    // these fields represent data in database
    @Id
    @GeneratedValue
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private Date date_of_birth;
    private String username;
    private String user_password;
    private String about_me;
    private String status;

    // an empty constructor for Hibernate
    public User(){}

    // a full constructor to create full objects
    public User(int user_id, String first_name, String last_name, String email, Date date_of_birth, String username, String user_password, String about_me, String status){
            this.user_id = user_id;
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.date_of_birth = date_of_birth;
            this.username = username;
            this.user_password = user_password;
            this.about_me = about_me;
            this.status = status;
        }

    // a constructor without a pre-set id
    public User(String first_name, String last_name, String email, Date date_of_birth, String username, String user_password, String about_me, String status){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.username = username;
        this.user_password = user_password;
        this.about_me = about_me;
        this.status = status;
    }

    // a constructor simply to log in
    public User(String username, String user_password){
        this.username = username;
        this.user_password = user_password;
    }

    // a constructor to check username exists
    public User(String username){
        this.username = username;
    }
    
    // a constructor to register a new account
    public User(String first_name, String last_name, String email, Long date_of_birth, String username, String user_password){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = new Date(date_of_birth);
        this.username = username;
        this.user_password = user_password;
    }

        // getters and setters
        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Date getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(long date_of_birth) {
            this.date_of_birth = new Date(date_of_birth);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getAbout_me() {
            return about_me;
        }

        public void setAbout_me(String about_me) {
            this.about_me = about_me;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        // printing everything out as a String
        @Override
        public String toString() {
            return "User [about_me=" + about_me + ", date_of_birth=" + date_of_birth + ", email=" + email
                    + ", first_name=" + first_name + ", last_name=" + last_name + ", status=" + status + ", user_id="
                    + user_id + ", user_password=" + user_password + ", username=" + username + "]";
        }    
}
