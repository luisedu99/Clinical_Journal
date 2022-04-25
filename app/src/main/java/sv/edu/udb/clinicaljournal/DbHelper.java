package sv.edu.udb.clinicaljournal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "clinic.db";
    public static final String TABLE_DOCTORS = "t_doctors";
    public static final String TABLE_PATIENTS = "t_patients";
    public static final String TABLE_APPOINTMENT = "t_appointments";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_DOCTORS + "(" +
                "id_doctor INTEGER PRIMARY KEY AUTOINCREMENT," +
                "doctor_name TEXT NOT NULL," +
                "doctor_lastname TEXT NOT NULL," +
                "doctor_email TEXT NOT NULL," +
                "doctor_pass TEXT NOT NULL," +
                "doctor_phone TEXT NOT NULL," +
                "doctor_description TEXT NOT NULL," +
                "doctor_role INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_PATIENTS + "(" +
                "id_patient INTEGER PRIMARY KEY AUTOINCREMENT," +
                "patient_name TEXT NOT NULL," +
                "patient_lastname TEXT NOT NULL," +
                "patient_email TEXT NOT NULL," +
                "patient_pass TEXT NOT NULL," +
                "patient_phone TEXT NOT NULL," +
                "patient_description TEXT NOT NULL," +
                "patient_role INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_APPOINTMENT + "(" +
                "id_appointment INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_patientFK INTEGER NOT NULL," +
                "id_doctorFK INTEGER NOT NULL," +
                "clinic TEXT NOT NULL," +
                "appointment_date TEXT NOT NULL," +
                "FOREIGN KEY(id_patientFK) REFERENCES t_patients(id_patient)," +
                "FOREIGN KEY(id_doctorFK) REFERENCES t_doctors(id_doctor))");

    }

    private void chargeSomething(SQLiteDatabase db){
        //Aqui es para la data precargada
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_APPOINTMENT);
        db.execSQL("DROP TABLE " + TABLE_PATIENTS);
        db.execSQL("DROP TABLE " + TABLE_DOCTORS);
        onCreate(db);
    }
}
