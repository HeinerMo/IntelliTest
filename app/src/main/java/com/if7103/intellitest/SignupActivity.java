package com.if7103.intellitest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.if7103.intellitest.domain.domain.ApplicationData;
import com.if7103.intellitest.domain.entity.User;
import com.if7103.intellitest.persistance.data.DatabaseController;

public class SignupActivity extends AppCompatActivity {

    private EditText editSignUpUserName, editSignupPassword, editSignupPasswordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        this.editSignUpUserName = this.findViewById(R.id.editSignUpUserName);
        this.editSignupPassword = this.findViewById(R.id.editSignupPassword);
        this.editSignupPasswordConfirmation = this.findViewById(R.id.editSignupPasswordConfirmation);
    }

    public void signup(View view) {
        DatabaseController databaseController = DatabaseController.getInstance(this);

        boolean success = true;

        if (!(editSignupPassword.getText().toString().equals(editSignupPasswordConfirmation.getText().toString()))) {
            success = false;
            editSignupPasswordConfirmation.setError("Las contraseñas deben coincidir.");
        }

        if (editSignupPassword.getText().length() == 0) {
            success = false;
            editSignupPassword.setError("Debe ingresar una contraseña.");
        }

        if (editSignupPasswordConfirmation.getText().length() == 0) {
            success = false;
            editSignupPasswordConfirmation.setError("Debe ingresar una contraseña.");
        }

        if (editSignUpUserName.getText().length() < 4) {
            success = false;
            editSignUpUserName.setError("Este nombre de usuario no es válido.");
        }

        if (success) {
            User user = new User(editSignUpUserName.getText().toString(), editSignupPassword.getText().toString());
            User tempUser = databaseController.getByUsername(user.getUserName());
            if (tempUser != null) {
                success = false;
                editSignUpUserName.setError("Este nombre de usuario no está disponible.");
            } else {
                databaseController.addUser(user);
                ApplicationData.getData().setUser(user);
                launchMainView(view);
            }
        }
    }

    public void launchMainView(View view) {
        Intent myIntent = new Intent(SignupActivity.this, HomeActivity.class);
        SignupActivity.this.startActivity(myIntent);
    }
}