package sv.edu.udb.clinicaljournal;

import static sv.edu.udb.clinicaljournal.DbHelper.TABLE_APPOINTMENT;
import static sv.edu.udb.clinicaljournal.DbHelper.TABLE_DOCTORS;
import static sv.edu.udb.clinicaljournal.DbHelper.TABLE_PATIENTS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateDateDoctor extends AppCompatActivity {

    EditText  txtDate,txtDateDetail;
    TextView txtDateIdDoctor,txtDateIdPatient;
    Spinner spHour , spDateDoctor,spDatePatient;
    Button btnSaveDate;
    DoctorMenuScreen dm;
    ArrayList<String> iddoctor;
    ArrayList<Doctors>DoctorList;

    ArrayList<String> idPatient;
    ArrayList<Patients> PatientsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createdatedoctor_screen);
        txtDate=(EditText) findViewById(R.id.editTextDate);
        txtDateDetail=(EditText) findViewById(R.id.edtDetailDate);
        txtDateIdDoctor=(TextView) findViewById(R.id.txtIdDoctor);
        txtDateIdPatient=(TextView) findViewById(R.id.txtIdP);
        spHour=(Spinner) findViewById(R.id.spHora);
        btnSaveDate=(Button) findViewById(R.id.btSaveDateP);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource
                (this, R.array.hours_available, android.R.layout.simple_spinner_dropdown_item);
        spHour.setAdapter(adapter);
        consultarDoctor();
        consultarPatient();
        spDateDoctor=(Spinner) findViewById(R.id.spDoctor);
        ArrayAdapter<CharSequence> adaptador=new ArrayAdapter(this, android.R.layout.simple_spinner_item,iddoctor);
        spDateDoctor.setAdapter(adaptador);
        spDateDoctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0){
                    txtDateIdDoctor.setText(Integer.toString(DoctorList.get(i-1).getId_doctor()));

                }else{
                    txtDateIdDoctor.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spDatePatient=(Spinner) findViewById(R.id.spPatient);
        ArrayAdapter<CharSequence> pat=new ArrayAdapter(this, android.R.layout.simple_spinner_item,idPatient);
        spDatePatient.setAdapter(pat);
        spDatePatient.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i!=0){
                    txtDateIdPatient.setText(Integer.toString(PatientsList.get(i-1).getId_pacient()));

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnSaveDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbAppointment dbAppointment=new DbAppointment(CreateDateDoctor.this);
                long id=dbAppointment.insertAppointment(Integer.parseInt(txtDateIdPatient.getText().toString()) ,Integer.parseInt(txtDateIdDoctor.getText().toString()),txtDate.getText().toString(),
                        spHour.getSelectedItem().toString(), txtDateDetail.getText().toString());
                if(id>0){
                    Log.d("Mensaje;","Cita registrada con exito");
                    Toast.makeText(CreateDateDoctor.this,"CITA REGISTRADA CON EXITO", Toast.LENGTH_LONG).show();
                }else{
                    Log.d("Mensaje: ", "ERROR al crear cita");
                    Toast.makeText(CreateDateDoctor.this, "ERROR AL CREAR CITA ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void consultarDoctor(){
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Doctors doc=null;
        DoctorList=new ArrayList<Doctors>();
        Cursor cursor=db.rawQuery("Select * From "+TABLE_DOCTORS,null);
        while(cursor.moveToNext()){
            doc=new Doctors();
            doc.setId_doctor(cursor.getInt(0));
            doc.setDoctor_name(cursor.getString(1));
            doc.setDoctor_lastname(cursor.getString(2));
            DoctorList.add(doc);
        }
        getDoctor();
    }
    private void getDoctor(){
        iddoctor=new ArrayList<String>();
        iddoctor.add("Seleccione");
        for(int i=0;i<DoctorList.size();i++){
            iddoctor.add(DoctorList.get(i).getId_doctor()+"-"+ DoctorList.get(i).getDoctor_name()+" - "+DoctorList.get(i).getDoctor_lastname());
        }
    }
    private void consultarPatient(){
        DbHelper dbHelper = new DbHelper(getApplicationContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Patients pat=null;
        PatientsList=new ArrayList<Patients>();
        Cursor cursor=db.rawQuery("Select * From "+TABLE_PATIENTS,null);
        while(cursor.moveToNext()){
            pat=new Patients();
            pat.setId_pacient(cursor.getInt(0));
            pat.setPatient_name(cursor.getString(1));
            pat.setPatient_lastname(cursor.getString(2));
            PatientsList.add(pat);
        }
        getPatient();
    }
    private void getPatient(){
        idPatient=new ArrayList<String>();
        idPatient.add("Seleccione");
        for(int i=0;i<PatientsList.size();i++){
            idPatient.add(PatientsList.get(i).getId_pacient()+"-"+ PatientsList.get(i).getPatient_name()+" - "+PatientsList.get(i).getPatient_lastname());
        }
    }
}