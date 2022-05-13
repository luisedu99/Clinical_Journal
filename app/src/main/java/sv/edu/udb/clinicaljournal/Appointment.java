package sv.edu.udb.clinicaljournal;

public class Appointment {
    private int id_appointment;
    private int id_patientFK;
    private int id_doctorFK;
    private String appointment_date;
    private String appointment_hour;
    private String appointment_detail;

    public Appointment(){
    }
    public Appointment(int id_appointment, int id_patientFK,int id_doctorFK, String appointment_date,String appointment_hour, String appointment_detail){
        this.id_appointment=id_appointment;
        this.id_doctorFK=id_doctorFK;
        this.id_patientFK=id_patientFK;
        this.appointment_date=appointment_date;
        this.appointment_hour=appointment_hour;
        this.appointment_detail=appointment_detail;
    }
    @Override
    public String toString(){
        return "Appointment{"+
                "id_appointment"+id_appointment+
                ", id_patientFK" +id_patientFK+ '\''+
                ", id_doctor_FK" + id_doctorFK +'\''+
                ", appointment_date" +appointment_date +'\''+
                ", appointment_hout" +appointment_hour +'\''+
                ", appointment_detail"+appointment_detail+
                '}';
    }


    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
    }

    public int getId_patientFK() {
        return id_patientFK;
    }

    public void setId_patientFK(int id_patientFK) {
        this.id_patientFK = id_patientFK;
    }

    public int getId_doctorFK() {
        return id_doctorFK;
    }

    public void setId_doctorFK(int id_doctorFK) {
        this.id_doctorFK = id_doctorFK;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_hour() {
        return appointment_hour;
    }

    public void setAppointment_hour(String appointment_hour) {
        this.appointment_hour = appointment_hour;
    }

    public String getAppointment_detail() {
        return appointment_detail;
    }

    public void setAppointment_detail(String appointment_detail) {
        this.appointment_detail = appointment_detail;
    }
}
