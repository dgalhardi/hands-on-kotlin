package github.io.dgalhadi.desafio1_loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login");

        eName = findViewById(R.id.edit_text_credentials);
        ePassword = findViewById(R.id.edit_text_password);
        eLogin = findViewById(R.id.btn_sign_in);

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Autenticado com sucesso.", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(MainActivity.this, BackgroundActivity.class);
                    Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                    intent.putExtra("input_name", inputName);
                    startActivity(intent);
                }
            }
        });
    }
}