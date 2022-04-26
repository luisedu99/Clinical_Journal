package sv.edu.udb.clinicaljournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientsAdapter extends RecyclerView.Adapter<PatientsAdapter.ViewHolder>{


    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView patientName, patientLastname, patientEmail, patientPhone, patientDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            patientName = (TextView)itemView.findViewById(R.id.txtvShowPatientName);
            patientLastname = (TextView)itemView.findViewById(R.id.txtvShowPatientLastname);
            patientEmail = (TextView)itemView.findViewById(R.id.txtvShowPatientEmail);
            patientPhone = (TextView)itemView.findViewById(R.id.txtvShowPatientPhone);
            patientDescription = (TextView)itemView.findViewById(R.id.txtvShowPatientDescrip);
        }
    }

    public List<Patients> showPatientsList;

    public PatientsAdapter(List<Patients> showPatientsList) {
        this.showPatientsList = showPatientsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showpatients,parent,false);
        PatientsAdapter.ViewHolder viewHolder = new PatientsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.patientName.setText(showPatientsList.get(position).getPatient_name());
        holder.patientLastname.setText(showPatientsList.get(position).getPatient_lastname());
        holder.patientEmail.setText(showPatientsList.get(position).getPatient_email());
        holder.patientPhone.setText(showPatientsList.get(position).getPatient_phone());
        holder.patientDescription.setText(showPatientsList.get(position).getPatient_descrip());
    }

    @Override
    public int getItemCount() {
        return showPatientsList.size();
    }
}
