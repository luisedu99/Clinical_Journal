package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ShowPatients extends AppCompatActivity {

    private RecyclerView recyclerViewPatients;
    private PatientsAdapter patientsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpatients_screen);

        recyclerViewPatients = (RecyclerView)findViewById(R.id.recyclerShowPatients);
        recyclerViewPatients.setLayoutManager(new LinearLayoutManager(this));

        DbPatients dbPatients = new DbPatients(getApplicationContext());

        patientsAdapter = new PatientsAdapter(dbPatients.showPatients());
        recyclerViewPatients.setAdapter(patientsAdapter);
    }
}