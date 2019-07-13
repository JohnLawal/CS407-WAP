package models;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object user){
        if (user == null) return false;
        if(! (user instanceof User)) return false;
        User nUser = (User) user;
        return nUser.getUsername().equals(this.getUsername()) && nUser.getPassword().equals(this.getPassword());
    }

}
