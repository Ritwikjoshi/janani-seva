package com.janni.botlabs.jananiseva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    AppCompatButton logIn, register;
    AutoCompleteTextView emailEt;
    EditText passwordEt;
    String email, password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        logIn = findViewById(R.id.email_sign_in_button);
        register = findViewById(R.id.register_button);
        emailEt = findViewById(R.id.email);
        passwordEt = findViewById(R.id.password);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = emailEt.getText().toString().trim();
                password = passwordEt.getText().toString().trim();

                if (email.equals("kamla@gmail.com")) {
                    if (password.equals("kamla123")) {
                        Intent i = new Intent(Login.this, MainActivity.class);
                        startActivity(i);
                        Toast.makeText(Login.this, "Successfully logged In", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Login.this, "Enter correct password!", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(Login.this, "Enter correct e-mail Id!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, registrationActivity.class);
                startActivity(i);
            }
        });
    }
}
