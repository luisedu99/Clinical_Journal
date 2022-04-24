package sv.edu.udb.clinicaljournal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "clinic.db";
    public static final String TABLE_DOCTORS = "t_doctores";
    public static final String TABLE_PATIENTS = "t_pacientes";
    public static final String TABLE_APPOINTMENT = "t_citas";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_DOCTORS + "(" +
                "id_doctor INTEGER PRIMARY KEY," +
                "nombre_doctor TEXT NOT NULL," +
                "apellido_doctor TEXT NOT NULL," +
                "email_doctor TEXT NOT NULL," +
                "contra_doctor TEXT NOT NULL," +
                "telefono_doctor TEXT NOT NULL," +
                "descripcion_doctor TEXT NOT NULL," +
                "rol_doctor INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_PATIENTS + "(" +
                "id_paciente INTEGER PRIMARY KEY," +
                "nombre_paciente TEXT NOT NULL," +
                "apellido_paciente TEXT NOT NULL," +
                "email_paciente TEXT NOT NULL," +
                "contra_paciente TEXT NOT NULL," +
                "telefono_paciente TEXT NOT NULL," +
                "descripcion_paciente TEXT NOT NULL," +
                "rol_paciente INTEGER NOT NULL)");

        db.execSQL("CREATE TABLE " + TABLE_APPOINTMENT + "(" +
                "id_cita INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_pacienteFK INTEGER NOT NULL," +
                "id_doctorFK INTEGER NOT NULL," +
                "consultorio TEXT NOT NULL," +
                "hora_cita TEXT NOT NULL," +
                "FOREIGN KEY(id_pacienteFK) REFERENCES t_pacientes(id_paciente)," +
                "FOREIGN KEY(id_doctorFK) REFERENCES t_doctores(id_doctor))");

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
