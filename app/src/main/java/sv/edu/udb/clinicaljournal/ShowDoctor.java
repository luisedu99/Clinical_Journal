package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ShowDoctor extends AppCompatActivity {

    private RecyclerView recyclerViewDoctors;
    private DoctorsAdapter doctorsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdoctors_screen);

        recyclerViewDoctors = (RecyclerView)findViewById(R.id.recyclerShowDoctors);
        recyclerViewDoctors.setLayoutManager(new LinearLayoutManager(this));

        DbDoctors dbDoctors = new DbDoctors(getApplicationContext());

        doctorsAdapter = new DoctorsAdapter(dbDoctors.showDoctors());
        recyclerViewDoctors.setAdapter(doctorsAdapter);
    }
}