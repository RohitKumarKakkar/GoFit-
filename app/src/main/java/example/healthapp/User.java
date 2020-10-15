package example.healthapp;

import android.widget.EditText;

public class User {

    public String fullname, email, gender, dateis, password, url;

    public User() {

    }

    public User(String fullname, String email, String gender, String dateis, String password, String url) {
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.dateis = dateis;
        this.password = password;
        this.url = url;
    }
}
