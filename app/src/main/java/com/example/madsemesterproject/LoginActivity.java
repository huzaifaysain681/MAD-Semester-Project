package com.example.madsemesterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailField = findViewById(R.id.email);
        passwordField = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);
        TextView forgotPasswordLink = findViewById(R.id.forgot_password);
        TextView tabSignUp = findViewById(R.id.tab_sign_up);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        tabSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loginUser() {
        // Replace with actual login logic
        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();

        if (email.equals("HNA") && password.equals("HNA")) {
            // Save login status (this should be replaced with a proper session management)
            getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isLoggedIn", true)
                    .apply();

            // Go to MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            // Show login error (implement error handling)
        }
    }
}
