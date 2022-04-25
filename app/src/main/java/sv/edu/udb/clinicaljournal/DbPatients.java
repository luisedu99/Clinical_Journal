package sv.edu.udb.clinicaljournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbPatients extends DbHelper{

    Context context;
    //SQLiteDatabase sql;
    ArrayList<Patients> patientList;

    public DbPatients(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertPatients(String patient_name, String patient_lastname, String patient_email, String patient_pass, String patient_phone, String patient_descrip, int patient_role){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("patient_name",patient_name);
            values.put("patient_lastname",patient_lastname);
            values.put("patient_email",patient_email);
            values.put("patient_pass",patient_pass);
            values.put("patient_phone",patient_phone);
            values.put("patient_description",patient_descrip);
            values.put("patient_role",patient_role);

            id = db.insert(TABLE_PATIENTS, null,values);
        }
        catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Patients> selectPatients(){
        ArrayList<Patients> patientsList = new ArrayList<Patients>();
        patientsList.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM t_patients",null);
        if(cr != null && cr.moveToFirst()){
            do{
                Patients pat = new Patients();
                pat.setId_pacient(cr.getInt(0));
                pat.setPatient_name(cr.getString(1));
                pat.setPatient_lastname(cr.getString(2));
                pat.setPatient_email(cr.getString(3));
                pat.setPatient_pass(cr.getString(4));
                pat.setPatient_phone(cr.getString(5));
                pat.setPatient_descrip(cr.getString(6));
                pat.setPatient_role(cr.getInt(7));
                patientsList.add(pat);

            }while(cr.moveToNext());
        }
        return patientsList;
    }

    public int patientLogin(String user, String pass){

        int a = 0;

        Log.d("DbPatients: ", user);
        Log.d("DbPatients: ", pass);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM t_patients", null);
        Log.d("DbPatientsCR: ", cr.toString());
        if (cr != null && cr.moveToFirst()) {
            do {
                if(cr.getString(3).equals(user) && cr.getString(4).equals(pass)){
                    a++;
                }
            } while (cr.moveToNext());
        }
        return a;
    }

    public Patients getPatient(String u, String p){
        patientList = selectPatients();

        for (Patients pats:patientList){
            if(pats.getPatient_email().equals(u) && pats.getPatient_pass().equals(p)){
                return pats;
            }
        }
        return null;
    }

    public Patients getPatientId(int id){
        patientList = selectPatients();

        for (Patients pats:patientList){
            if(pats.getId_pacient() == id){
                return pats;
            }
        }
        return null;
    }
}
