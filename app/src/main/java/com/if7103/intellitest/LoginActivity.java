package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.if7103.intellitest.domain.domain.ApplicationData;
import com.if7103.intellitest.domain.entity.User;
import com.if7103.intellitest.persistance.data.UserDataAccess;

public class LoginActivity extends AppCompatActivity {

    private EditText editUsername, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.editPassword = this.findViewById(R.id.editLoginPassword);
        this.editUsername = this.findViewById(R.id.editLoginUserName);
    }

    public void login(View view) {
        UserDataAccess userDataAccess = new UserDataAccess(this);

        if (checkInputs()) {
            User user = userDataAccess.getByUsername(editUsername.getText().toString());
            if (user == null) {
                this.editUsername.setError("Este usuario no existe.");
            } else {
                if (user.getPassword().equals(editPassword.getText().toString())) {
                    ApplicationData.getData().setUser(user);
                    launchMainView(view);
                } else {
                    this.editPassword.setError("Contraseña incorrecta.");
                }
            }
        }
    }

    private boolean checkInputs() {
        boolean status = true;
        if (this.editPassword.getText().length() == 0) {
            this.editPassword.setError("Debe ingresar una contraseña.");
            status = false;
        }

        if (this.editUsername.getText().length() == 0) {
            this.editUsername.setError("Debe ingresar un nombre de usuario.");
            status = false;
        }

        return status;
    }

    public void signup(View view) {
        launchSignUpView(view);
    }

    public void launchSignUpView(View view) {
        Intent myIntent = new Intent(LoginActivity.this, SignupActivity.class);
        LoginActivity.this.startActivity(myIntent);
    }
    public void launchMainView(View view) {
        Intent myIntent = new Intent(LoginActivity.this, HomeActivity.class);
        LoginActivity.this.startActivity(myIntent);
        this.finish(); //Finish this activity so it doesn't show on history stack.
    }

}