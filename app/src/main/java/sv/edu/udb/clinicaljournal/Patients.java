package sv.edu.udb.clinicaljournal;

public class Patients {

    private int id_pacient;
    private String patient_name;
    private String patient_lastname;
    private String patient_email;
    private String patient_pass;
    private String patient_phone;
    private String patient_descrip;
    private int patient_role;

    public Patients() {
    }

    public Patients(int id_pacient, String patient_name, String patient_lastname, String patient_email, String patient_pass, String patient_phone, String patient_descrip, int patient_role) {
        this.id_pacient = id_pacient;
        this.patient_name = patient_name;
        this.patient_lastname = patient_lastname;
        this.patient_email = patient_email;
        this.patient_pass = patient_pass;
        this.patient_phone = patient_phone;
        this.patient_descrip = patient_descrip;
        this.patient_role = patient_role;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id_pacient=" + id_pacient +
                ", patient_name='" + patient_name + '\'' +
                ", patient_lastname='" + patient_lastname + '\'' +
                ", patient_email='" + patient_email + '\'' +
                ", patient_pass='" + patient_pass + '\'' +
                ", patient_phone='" + patient_phone + '\'' +
                ", patient_descrip='" + patient_descrip + '\'' +
                ", patient_role=" + patient_role +
                '}';
    }

    public boolean isNull(){
        if (patient_name.equals("") && patient_lastname.equals("") && patient_email.equals("") && patient_pass.equals("") && patient_phone.equals("") && patient_descrip.equals("")){
            return false;
        }else {
            return true;
        }
    }

    public int getId_pacient() {
        return id_pacient;
    }

    public void setId_pacient(int id_pacient) {
        this.id_pacient = id_pacient;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_lastname() {
        return patient_lastname;
    }

    public void setPatient_lastname(String patient_lastname) {
        this.patient_lastname = patient_lastname;
    }

    public String getPatient_email() {
        return patient_email;
    }

    public void setPatient_email(String patient_email) {
        this.patient_email = patient_email;
    }

    public String getPatient_pass() {
        return patient_pass;
    }

    public void setPatient_pass(String patient_pass) {
        this.patient_pass = patient_pass;
    }

    public String getPatient_phone() {
        return patient_phone;
    }

    public void setPatient_phone(String patient_phone) {
        this.patient_phone = patient_phone;
    }

    public String getPatient_descrip() {
        return patient_descrip;
    }

    public void setPatient_descrip(String patient_descrip) {
        this.patient_descrip = patient_descrip;
    }

    public int getPatient_role() {
        return patient_role;
    }

    public void setPatient_role(int patient_role) {
        this.patient_role = patient_role;
    }
}
