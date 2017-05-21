package com.karaapp.karaokeapp.mdl;

/**
 * Created by Nganq on 4/18/2017.
 */

public class UserProfileReponse {
    private String id;
    private String name;
    private String email;

    public UserProfileReponse(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Class [id = " + id + ", email" + ", name = " + name + "]";
    }
}
