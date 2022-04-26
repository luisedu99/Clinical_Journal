package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DoctorMenuScreen extends AppCompatActivity {

    Button btnOption1Doctors, btnOption2Doctors, btnOption3Doctors;
    TextView txtDocName;
    int id_doc = 0;
    Doctors docs;
    DbDoctors dbDoctors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_menu_screen);

        txtDocName = (TextView)findViewById(R.id.txtDocName);

        Bundle b = getIntent().getExtras();
        id_doc = b.getInt("id_doctor");
        dbDoctors = new DbDoctors(this);
        docs = dbDoctors.getDoctorId(id_doc);
        txtDocName.setText(docs.getDoctor_name() + " " + docs.getDoctor_lastname());
    }
    public void showPatients(View v){
        Intent intent=new Intent(this, ShowPatients.class);
        startActivity(intent);
    }
    public void createDateDoctor(View v){
        Intent intent = new Intent(this, CreateDateDoctor.class);
        startActivity(intent);
    }
    public void showDatesDoctor(View v){
        Intent intent = new Intent(this, showDateDoctor.class);
        startActivity(intent);
    }
}