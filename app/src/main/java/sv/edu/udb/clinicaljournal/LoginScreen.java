package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {

    EditText user, pass;
    Button btnEntrar, btnRegistrarse;
    RadioButton rdbtnPatientLogin, rdbtnDoctorLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        user = (EditText)findViewById(R.id.txtUserEmail);
        pass = (EditText)findViewById(R.id.txtUserPassword);
        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        btnRegistrarse = (Button)findViewById(R.id.btnRegistrarse);

        rdbtnPatientLogin = (RadioButton)findViewById(R.id.rdbtnPatientLogin);
        rdbtnDoctorLogin= (RadioButton)findViewById(R.id.rdbtnDoctorLogin);

        //Boton de registrarse
        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creando base de datos
                DbHelper dbHelper = new DbHelper(LoginScreen.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db != null){
                    Log.d("MENSAJE: ", "Base de datos creada con exito");
                } else {
                    Log.d("MENSAJE: ", "Error al crear la base de datos");
                }

                Intent intent =new Intent(LoginScreen.this, RegisterScreen.class);
                startActivity(intent);
            }
        });

        //Boton para Loguearse
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userEmail = user.getText().toString();
                String userPass = pass.getText().toString();

                //Validando campos vacios
                if(userEmail.equals("") || userPass.equals("")){
                    Toast.makeText(LoginScreen.this, "ERROR: Los campos tiene que estar llenos.", Toast.LENGTH_LONG).show();
                }else{
                    //Entrar como paciente
                    if(rdbtnPatientLogin.isChecked() == true){
                        DbPatients dbPatients = new DbPatients(LoginScreen.this);
                        user.setText("");
                        pass.setText("");
                        Log.d("LoginScreen: ", userEmail);
                        Log.d("LoginScreen: ", userPass);

                        if(dbPatients.patientLogin(userEmail, userPass) == 1){

                            Patients pat = dbPatients.getPatient(userEmail, userPass);
                            Toast.makeText(LoginScreen.this, "Datos correctos", Toast.LENGTH_LONG).show();
                            Intent intent1 =new Intent(LoginScreen.this, PatientMenuScreen.class);
                            intent1.putExtra("id_pacient", pat.getId_pacient());
                            startActivity(intent1);

                        }else{
                            Toast.makeText(LoginScreen.this, "ERROR AL INGRESAR COMO PACIENTE", Toast.LENGTH_LONG).show();
                        }
                    }
                    //Entrar como doctor
                    else if(rdbtnDoctorLogin.isChecked() == true){
                        DbDoctors dbDoctors = new DbDoctors(LoginScreen.this);

                        if(dbDoctors.doctorLogin(userEmail, userPass) == 1){

                            Doctors doc = dbDoctors.getDoctor(userEmail, userPass);
                            Toast.makeText(LoginScreen.this, "Datos correctos", Toast.LENGTH_LONG).show();
                            Intent intent2 =new Intent(LoginScreen.this, DoctorMenuScreen.class);
                            intent2.putExtra("id_doctor", doc.getId_doctor());
                            user.setText("");
                            pass.setText("");
                            startActivity(intent2);
                        }else{
                            Toast.makeText(LoginScreen.this, "ERROR AL INGRESAR COMO DOCTOR", Toast.LENGTH_LONG).show();
                        }
                    }
                    //No ha seleccionado un rol en los radioButton
                    else{
                        Log.d("Mensaje: ", "ERROR debe seleccionar un rol");
                        Toast.makeText(LoginScreen.this, "ERROR DEBE SELECCIONAR UN ROL", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
    }
}