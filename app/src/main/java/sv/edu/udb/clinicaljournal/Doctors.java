package sv.edu.udb.clinicaljournal;

public class Doctors {

    private int id_doctor;
    private String doctor_name;
    private String doctor_lastname;
    private String doctor_email;
    private String doctor_pass;
    private String doctor_phone;
    private String doctor_descrip;
    private int doctor_role;

    public Doctors() {
    }

    public Doctors(int id_doctor, String doctor_name, String doctor_lastname, String doctor_email, String doctor_pass, String doctor_phone, String doctor_descrip, int doctor_role) {
        this.id_doctor = id_doctor;
        this.doctor_name = doctor_name;
        this.doctor_lastname = doctor_lastname;
        this.doctor_email = doctor_email;
        this.doctor_pass = doctor_pass;
        this.doctor_phone = doctor_phone;
        this.doctor_descrip = doctor_descrip;
        this.doctor_role = doctor_role;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id_doctor=" + id_doctor +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_lastname='" + doctor_lastname + '\'' +
                ", doctor_email='" + doctor_email + '\'' +
                ", doctor_pass='" + doctor_pass + '\'' +
                ", doctor_phone='" + doctor_phone + '\'' +
                ", doctor_descrip='" + doctor_descrip + '\'' +
                ", doctor_role=" + doctor_role +
                '}';
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_lastname() {
        return doctor_lastname;
    }

    public void setDoctor_lastname(String doctor_lastname) {
        this.doctor_lastname = doctor_lastname;
    }

    public String getDoctor_email() {
        return doctor_email;
    }

    public void setDoctor_email(String doctor_email) {
        this.doctor_email = doctor_email;
    }

    public String getDoctor_pass() {
        return doctor_pass;
    }

    public void setDoctor_pass(String doctor_pass) {
        this.doctor_pass = doctor_pass;
    }

    public String getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(String doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public String getDoctor_descrip() {
        return doctor_descrip;
    }

    public void setDoctor_descrip(String doctor_descrip) {
        this.doctor_descrip = doctor_descrip;
    }

    public int getDoctor_role() {
        return doctor_role;
    }

    public void setDoctor_role(int doctor_role) {
        this.doctor_role = doctor_role;
    }
}
