package sv.edu.udb.clinicaljournal;

import static sv.edu.udb.clinicaljournal.DbHelper.TABLE_APPOINTMENT;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbAppointment extends DbHelper {
    Context context;

    public DbAppointment(@Nullable Context context){
        super(context);
        this.context=context;
    }

    public long insertAppointment(int id_patientFK, int id_doctorFK, String appointment_date,String appointment_hour, String appointment_detail){
        long id=0;
        try {
            DbHelper dbHelper= new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("id_patientFK",id_patientFK);
            values.put("id_doctorFK",id_doctorFK);
            values.put("appointment_date",appointment_date);
            values.put("appointment_hour",appointment_hour);
            values.put("appointment_detail",appointment_detail);


            id = db.insert(TABLE_APPOINTMENT,null,values);
        }catch (Exception ex){
            ex.toString();
        }
        return id;
    }
}
