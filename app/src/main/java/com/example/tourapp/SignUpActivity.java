package com.example.tourapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    TextView btnContinue;
    EditText edtSignUpName, edtEmailSignUp, edtpasswordSignUp, edtPhoneSignUp;
    String emailV = "@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnContinue = findViewById(R.id.btnContinue);
        signUp();
    }

    private void signUp() {

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtEmailSignUp = findViewById(R.id.edtEmailSignUp);
                edtPhoneSignUp = findViewById(R.id.edtPhoneSignUp);
                edtSignUpName = findViewById(R.id.edtSignUpName);
                edtpasswordSignUp = findViewById(R.id.edtpasswordSignUp);

                btnContinue = findViewById(R.id.btnContinue);
                String nameS = edtSignUpName.getText().toString();
                String emailS = edtEmailSignUp.getText().toString();
                String passwordS = edtpasswordSignUp.getText().toString();
                String phoneS = edtPhoneSignUp.getText().toString();
                if (nameS.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();

                } else if (emailS.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please Enter email", Toast.LENGTH_SHORT).show();
                } else if (!emailS.endsWith(emailV)) {
                    Toast.makeText(SignUpActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();
                } else if (passwordS.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "PLease Enter password", Toast.LENGTH_SHORT).show();
                } else if (phoneS.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please Enter Phone", Toast.LENGTH_SHORT).show();
                } else if (phoneS.length() == 10) {
                    Toast.makeText(SignUpActivity.this, "enter 10 digits phone", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(SignUpActivity.this, DashBoardActivity.class);
                    intent.putExtra("emailS", emailS);
                    intent.putExtra("phoneS", phoneS);
                    intent.putExtra("nameS", nameS);
                    finish();
                    startActivity(intent);

                }
            }
        });
    }
}