package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class showDateDoctor extends AppCompatActivity {

    TextView ApptDate, ApptHour, ApptDetails, ApptPatient, ApptDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdatedoctor_screen);

        ApptDate = findViewById(R.id.ApptDate);
        ApptHour = findViewById(R.id.ApptHour);
        ApptDetails = findViewById(R.id.ApptDetails);
        ApptPatient = findViewById(R.id.ApptPatient);
        ApptDoctor = findViewById(R.id.ApptDoctor);
        List<Appointment> appointmentsList = getAppointments();
    }

    public List<Appointment> getAppointments(){
        List<Appointment> AppoinmentList = new ArrayList<>();

        DbAppointment dbAppointment = new DbAppointment(showDateDoctor.this);
        Cursor cursor = dbAppointment.showAppointments();

        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    Appointment appt = new Appointment();
                    appt.setAppointment_date(cursor.getString(cursor.getColumnIndexOrThrow("appointment_date")));
                    appt.setAppointment_hour(cursor.getString(cursor.getColumnIndexOrThrow("appointment_hour")));
                    appt.setAppointment_detail(cursor.getString(cursor.getColumnIndexOrThrow("appointment_detail")));
                    appt.setId_patientFK(cursor.getInt(cursor.getColumnIndexOrThrow("id_patientFK")));
                    appt.setId_doctorFK(cursor.getInt(cursor.getColumnIndexOrThrow("id_doctorFK")));
                    AppoinmentList.add(appt);

                    StringBuilder editDate = new StringBuilder();
                    editDate.append(appt.getAppointment_date()).append("\n");
                    StringBuilder editHour = new StringBuilder();
                    editHour.append(appt.getAppointment_hour()).append("\n");
                    StringBuilder editDetails = new StringBuilder();
                    editDetails.append(appt.getAppointment_detail()).append("\n");
                    StringBuilder editPatient = new StringBuilder();
                    editPatient.append(String.valueOf(appt.getId_patientFK())).append("\n");
                    StringBuilder editDoctor = new StringBuilder();
                    editDoctor.append(String.valueOf(appt.getId_doctorFK())).append("\n");

                    ApptDate.append(editDate);
                    ApptHour.append(editHour);
                    ApptDetails.append(editDetails);
                    ApptPatient.append(editPatient);
                    ApptDoctor.append(editDoctor);
                } while(cursor.moveToNext());
            }
        }
        dbAppointment.close();
        return AppoinmentList;
    }
}