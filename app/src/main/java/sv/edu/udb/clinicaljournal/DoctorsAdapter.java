package sv.edu.udb.clinicaljournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.ViewHolder> {

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView doctorName, doctorLastname, doctorEmail, doctorPhone, doctorDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            doctorName = (TextView)itemView.findViewById(R.id.txtvShowDoctorsName);
            doctorLastname = (TextView)itemView.findViewById(R.id.txtvShowDoctorLastname);
            doctorEmail = (TextView)itemView.findViewById(R.id.txtvShowDoctorEmail);
            doctorPhone = (TextView)itemView.findViewById(R.id.txtvShowDoctorPhone);
            doctorDescription = (TextView)itemView.findViewById(R.id.txtvShowDoctorDescrip);
        }
    }

    public List<Doctors> showDoctorsList;

    public DoctorsAdapter(List<Doctors> showDoctorsList) {
        this.showDoctorsList = showDoctorsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_showdoctors,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.doctorName.setText(showDoctorsList.get(position).getDoctor_name());
        holder.doctorLastname.setText(showDoctorsList.get(position).getDoctor_lastname());
        holder.doctorEmail.setText(showDoctorsList.get(position).getDoctor_email());
        holder.doctorPhone.setText(showDoctorsList.get(position).getDoctor_phone());
        holder.doctorDescription.setText(showDoctorsList.get(position).getDoctor_descrip());
    }

    @Override
    public int getItemCount() {
        return showDoctorsList.size();
    }
}
