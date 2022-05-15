package sv.edu.udb.clinicaljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowDatePatient extends AppCompatActivity {

    TextView ApptDate, ApptHour, ApptDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdatepatient_screen);

        ApptDate = findViewById(R.id.ApptDate2);
        ApptHour = findViewById(R.id.ApptHour2);
        ApptDetails = findViewById(R.id.ApptDetails2);
        List<Appointment> appointmentsList = getAppointments();
    }

    public List<Appointment> getAppointments(){
        List<Appointment> AppoinmentList = new ArrayList<>();

        DbAppointment dbAppointment = new DbAppointment(ShowDatePatient.this);
        Cursor cursor = dbAppointment.showAppointments();

        if(cursor != null){
            if(cursor.moveToFirst()){
                do {
                    Appointment appt = new Appointment();
                    appt.setAppointment_date(cursor.getString(cursor.getColumnIndexOrThrow("appointment_date")));
                    appt.setAppointment_hour(cursor.getString(cursor.getColumnIndexOrThrow("appointment_hour")));
                    appt.setAppointment_detail(cursor.getString(cursor.getColumnIndexOrThrow("appointment_detail")));
                    AppoinmentList.add(appt);

                    StringBuilder editDate = new StringBuilder();
                    editDate.append(appt.getAppointment_date()).append("\n");
                    StringBuilder editHour = new StringBuilder();
                    editHour.append(appt.getAppointment_hour()).append("\n");
                    StringBuilder editDetails = new StringBuilder();
                    editDetails.append(appt.getAppointment_detail()).append("\n");

                    ApptDate.append(editDate);
                    ApptHour.append(editHour);
                    ApptDetails.append(editDetails);
                } while(cursor.moveToNext());
            }
        }
        dbAppointment.close();
        return AppoinmentList;
    }
}