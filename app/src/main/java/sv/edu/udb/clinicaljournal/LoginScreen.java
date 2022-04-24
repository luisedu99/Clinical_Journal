package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginScreen extends AppCompatActivity {

    EditText user, pass;
    Button btnEntrar, btnRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        user = (EditText)findViewById(R.id.txtUsuario);
        pass = (EditText)findViewById(R.id.txtPassword);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        btnRegistrarse = (Button)findViewById(R.id.btnRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(intent);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(LoginScreen.this, DoctorMenuScreen.class);
                startActivity(intent);
            }
        });
    }
}