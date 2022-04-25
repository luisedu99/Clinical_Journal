package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterScreen extends AppCompatActivity {

    EditText txtPatientName, txtPatientLastname, txtPatientEmail, txtPatientPassword, txtPatientPhone, txtPatientDescription;
    Button btnRegister;
    RadioButton rdbtnPatientRegister, rdbtnDoctorRegister;
    //DbPatients dbPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        txtPatientName = (EditText)findViewById(R.id.txtRegisterName);
        txtPatientLastname = (EditText)findViewById(R.id.txtRegisterLastname);
        txtPatientEmail = (EditText)findViewById(R.id.txtRegisterEmail);
        txtPatientPassword = (EditText)findViewById(R.id.txtRegisterPass);
        txtPatientPhone = (EditText)findViewById(R.id.txtRegisterPhone);
        txtPatientDescription = (EditText)findViewById(R.id.txtRegisterDescrip);

        rdbtnPatientRegister = (RadioButton)findViewById(R.id.rdbtnPatientRegister);
        rdbtnDoctorRegister= (RadioButton)findViewById(R.id.rdbtnDoctorRegister);

        btnRegister = (Button)findViewById(R.id.btnRegister);

       // dbPatients = new DbPatients(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Registrar un paciente
                if(rdbtnPatientRegister.isChecked() == true){

                    DbPatients dbPatients = new DbPatients(RegisterScreen.this);
                    long id = dbPatients.insertPatients(txtPatientName.getText().toString(), txtPatientLastname.getText().toString(), txtPatientEmail.getText().toString(),
                            txtPatientPassword.getText().toString(), txtPatientPhone.getText().toString(), txtPatientDescription.getText().toString(), 0);

                    if(id > 0){
                        Log.d("Mensaje: ", "PACIENTE creado con exito");
                        Toast.makeText(RegisterScreen.this, "PACIENTE CREADO CON EXITO", Toast.LENGTH_LONG).show();
                    }else{
                        Log.d("Mensaje: ", "ERROR al crear paciente");
                        Toast.makeText(RegisterScreen.this, "ERROR AL CREAR PACIENTE ", Toast.LENGTH_LONG).show();
                    }

                }
                //Registrar un doctor
                else if(rdbtnDoctorRegister.isChecked() == true){

                    DbDoctors dbDoctors =new DbDoctors(RegisterScreen.this);
                    long id = dbDoctors.insertDoctors(txtPatientName.getText().toString(), txtPatientLastname.getText().toString(), txtPatientEmail.getText().toString(),
                            txtPatientPassword.getText().toString(), txtPatientPhone.getText().toString(), txtPatientDescription.getText().toString(), 1);

                    if(id > 0){
                        Log.d("Mensaje: ", "DOCTOR creado con exito");
                        Toast.makeText(RegisterScreen.this, "DOCTOR CREADO CON EXITO", Toast.LENGTH_LONG).show();
                    }else{
                        Log.d("Mensaje: ", "ERROR al crear doctor");
                        Toast.makeText(RegisterScreen.this, "ERROR AL CREAR DOCTOR ", Toast.LENGTH_LONG).show();
                    }

                }
                //No ha seleccionado un role en el radiobutton
                else {
                    Log.d("Mensaje: ", "ERROR debe seleccionar un rol");
                    Toast.makeText(RegisterScreen.this, "ERROR DEBE SELECCIONAR UN ROL", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}