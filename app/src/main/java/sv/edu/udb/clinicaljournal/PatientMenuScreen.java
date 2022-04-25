package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PatientMenuScreen extends AppCompatActivity {

    Button btnOption1Patients, btnOption2Patients, btnOption3Patients;
    TextView txtvPatName;
    int id_pat = 0;
    Patients pats;
    DbPatients dbPatients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_menu_screen);

        txtvPatName = (TextView)findViewById(R.id.txtvPatName);

        Bundle b = getIntent().getExtras();
        id_pat = b.getInt("id_pacient");
        dbPatients = new DbPatients(this);
        pats = dbPatients.getPatientId(id_pat);
        txtvPatName.setText(pats.getPatient_name() + " " + pats.getPatient_lastname());
    }
}