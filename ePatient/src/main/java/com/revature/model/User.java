package com.revature.model;

public class User {
    private String token;
    private Person person;

    public User(){

    }

    public User(String token, Person person) {
        this.token = token;
        this.person = person;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User [person=" + person + ", token=" + token + "]";
    }
}
