package ua.nure.sdb.entity;

public class User {
    private long id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int gender;
    private String preferences;

    public static class Builder {
        private User newUser;

        public Builder() {
            newUser = new User();
        }
        public Builder withId(int id){
            newUser.id = id;
            return this;
        }

        public Builder withName(String name){
            newUser.name = name;
            return this;
        }

        public Builder withSurname(String surname){
            newUser.surname = surname;
            return this;
        }

        public Builder withLogin(String login){
            newUser.login = login;
            return this;
        }

        public Builder withPassword(String password){
            newUser.password = password;
            return this;
        }

        public Builder withGender(int gender){
            newUser.gender = gender;
            return this;
        }

        public Builder withPreferences(String preferences){
            newUser.preferences = preferences;
            return this;
        }

        public User build(){
            return newUser;
        }

    }

//    public User() {
//    }
//
//    public User(long id, String name, String surname, String login, String password, int gender, String preferences) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.login = login;
//        this.password = password;
//        this.gender = gender;
//        this.preferences = preferences;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }
}
