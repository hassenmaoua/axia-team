package com.example.axiateams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.axiateams.objects.account.Account;
import com.example.axiateams.objects.account.Societe;
import com.example.axiateams.remote.ApiClient;
import com.example.axiateams.remote.LoginRequest;
import com.example.axiateams.remote.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private boolean isChecked = true;
    private static Account account;
    public static String TOKEN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setBackgroundDrawableResource(R.drawable.background_login);

        setupLogin();

        setupPasswordVisibility();

        setupForgotPasswordMessage();

    }


    private void setupLogin() {
        // Setup Account Button Click Listener
        Button loginButton = (Button) findViewById(R.id.login_button);
        EditText editUsername = (EditText) findViewById(R.id.email_input);
        EditText editPassword = (EditText) findViewById(R.id.password_input);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateLogin(editUsername, editPassword)) {
                    LoginRequest loginRequest = new LoginRequest();
                    loginRequest.setUsername(editUsername.getText().toString());
                    loginRequest.setPassword(editPassword.getText().toString());
                    loginUser(loginRequest);
                }
            }
        });
    }

    public void loginUser(LoginRequest loginRequest) {

        if (loginRequest.getUsername().equals("user") && loginRequest.getPassword().equals("123")) {
            account = new Account("Hassen Maoua",
                    "hassen@email.com",
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Elon_Musk_Royal_Society_%28crop2%29.jpg/220px-Elon_Musk_Royal_Society_%28crop2%29.jpg",
                    "AZERTY",
                    new Societe(0, "Abstract")
            );
            Intent intent = new Intent(LoginActivity.this, AccueilActivity.class);
            startActivity(intent);
            finish();

            Toast.makeText(LoginActivity.this, "Connecté", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "Email ou Mot de passe incorrect", Toast.LENGTH_LONG).show();
        }

//        Call<LoginResponse> loginResponseCall = ApiClient.getService().loginUser(loginRequest);
//        loginResponseCall.enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
//                LoginResponse loginResponse = response.body();
//                if (loginResponse != null) {
//                    if (response.isSuccessful() && loginResponse.getStatus()) {
//                        Intent intent = new Intent(LoginActivity.this, AccueilActivity.class);
//                        account = loginResponse.getData();
//                        TOKEN = account.getToken();
//                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
//                        startActivity(intent);
//                        finish();
//
//                    } else {
//                        Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
//                String message = t.getLocalizedMessage();
//                Toast.makeText(LoginActivity.this, "Fail: " + message, Toast.LENGTH_LONG).show();
//            }
//        });
    }

    private boolean validateLogin(TextView username, TextView password) {
        if (TextUtils.isEmpty(username.getText().toString())) {
            Toast.makeText(this, "Email est requis!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (TextUtils.isEmpty(password.getText().toString())) {
            Toast.makeText(this, "Le mot de passe est requis!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void setupPasswordVisibility() {
        // Setup Password Visibility handler
        EditText editPassword = findViewById(R.id.password_input);
        ImageButton eyeButton = findViewById(R.id.password_visibility_button);

        eyeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isChecked) {
                    editPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    eyeButton.setImageResource(R.drawable.ic_visibility);
                } else {
                    editPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    eyeButton.setImageResource(R.drawable.ic_visibility_off);

                }
                editPassword.setSelection(editPassword.getText().length());
                isChecked = !isChecked;
            }
        });
    }

    private void setupForgotPasswordMessage() {
        // Setup Forget Password Link

        TextView link = findViewById(R.id.oublier_link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "This Feature has not been implement yet!", Toast.LENGTH_LONG).show();
            }
        });

    }

    public static Account getAccount() {
        return account;
    }

}