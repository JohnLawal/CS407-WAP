package models;

import java.io.Serializable;

public class User  {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.phone = null;
        this.email = null;
        this.address = null;
    }

    public User(String username, String password, String phone, String email,String address) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object user) {
        if (user == null) return false;
        if (!(user instanceof User)) return false;
        User nUser = (User) user;
        return nUser.getUsername().equals(this.getUsername()) && nUser.getPassword().equals(this.getPassword());
    }

}
