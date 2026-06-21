package de.thws.klausurvorbereitung.twotter;

import java.io.Serializable;

public class User implements Serializable {
    private final String benutzername;
    private String passwort;
    private static final long serialVersionUID = 1L;


    public User(String name, String pw) {
        this.benutzername = name;
        this.passwort = pw;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    @Override
    public String toString() {
        return "User{" +
                "benutzername='" + benutzername + '\'' +
                '}';
    }
}
