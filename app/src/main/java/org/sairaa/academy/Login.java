package org.sairaa.academy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText userId, password;
    Button singIn;
    private final String URL = "http://sairaa.org/academy/triveni/login.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userId = (EditText)findViewById(R.id.e_username);
        password = (EditText)findViewById(R.id.e_password);
        singIn = (Button)findViewById(R.id.b_signin);
        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userId.getText().toString();
                String passwordL = password.getText().toString();
                validateLogin login = new validateLogin(Login.this);
                login.execute(URL,username,passwordL);

            }
        });
    }
}
