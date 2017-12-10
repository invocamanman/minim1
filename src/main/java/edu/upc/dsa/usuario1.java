package edu.upc.dsa;

import java.util.ArrayList;

public class usuario1 {

    String email;
    String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public usuario1(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public usuario1() {
    }
}
