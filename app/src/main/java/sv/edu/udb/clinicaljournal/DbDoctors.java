package sv.edu.udb.clinicaljournal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DbDoctors extends DbHelper{

    Context context;
    //SQLiteDatabase sql;
    ArrayList<Doctors> doctorList;

    public DbDoctors(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertDoctors(String doctor_name, String doctor_lastname, String doctor_email, String doctor_pass, String doctor_phone, String doctor_descrip, int doctor_role){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("doctor_name",doctor_name);
            values.put("doctor_lastname",doctor_lastname);
            values.put("doctor_email",doctor_email);
            values.put("doctor_pass",doctor_pass);
            values.put("doctor_phone",doctor_phone);
            values.put("doctor_description",doctor_descrip);
            values.put("doctor_role",doctor_role);

            id = db.insert(TABLE_DOCTORS, null,values);
        }
        catch (Exception ex){
            ex.toString();
        }
        return id;
    }

    public ArrayList<Doctors> selectDoctors(){
        ArrayList<Doctors> doctorsList = new ArrayList<Doctors>();
        doctorsList.clear();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM t_doctors",null);

        if(cr != null && cr.moveToFirst()){
            do{
                Doctors doc = new Doctors();
                doc.setId_doctor(cr.getInt(0));
                doc.setDoctor_name(cr.getString(1));
                doc.setDoctor_lastname(cr.getString(2));
                doc.setDoctor_email(cr.getString(3));
                doc.setDoctor_pass(cr.getString(4));
                doc.setDoctor_phone(cr.getString(5));
                doc.setDoctor_descrip(cr.getString(6));
                doc.setDoctor_role(cr.getInt(7));
                doctorsList.add(doc);

            }while(cr.moveToNext());
        }
        return doctorsList;
    }

    public int doctorLogin(String user, String pass){

        int a = 0;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cr = db.rawQuery("SELECT * FROM t_doctors", null);
        if (cr != null && cr.moveToFirst()) {
            do {
                if(cr.getString(3).equals(user) && cr.getString(4).equals(pass)){
                    a++;
                }
            } while (cr.moveToNext());
        }
        return a;
    }

    public Doctors getDoctor(String u, String p){
        doctorList = selectDoctors();

        for (Doctors docs:doctorList){
            if(docs.getDoctor_email().equals(u) && docs.getDoctor_pass().equals(p)){
                return docs;
            }
        }
        return null;
    }

    public Doctors getDoctorId(int id){
        doctorList = selectDoctors();

        for (Doctors docs:doctorList){
            if(docs.getId_doctor() == id){
                return docs;
            }
        }
        return null;
    }
}
