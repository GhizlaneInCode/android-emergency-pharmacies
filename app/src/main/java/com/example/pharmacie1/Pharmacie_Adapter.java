package com.example.pharmacie1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Pharmacie_Adapter extends RecyclerView.Adapter<Pharmacie_Adapter.Holder> {
    Context ct;
    ArrayList<Pharmacie> Pharmacies;

    public Pharmacie_Adapter(Context ct, ArrayList<Pharmacie> Pharmacies) {
        this.ct = ct;
        this.Pharmacies = Pharmacies;
    }

    @NonNull
    @Override
    public Pharmacie_Adapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        LayoutInflater inflater = LayoutInflater.from(ct);
        View v = inflater.inflate(R.layout.pharmacie_item, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Pharmacie_Adapter.Holder holder, @SuppressLint("RecyclerView") int position) {

        holder.tvname.setText(Pharmacies.get(position).getName());
        holder.tvadress.setText(Pharmacies.get(position).getAdress());
        holder.tvtel.setText(Pharmacies.get(position).getTelephone());


    }

    @Override
    public int getItemCount() {
        return Pharmacies.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        TextView tvname;
        TextView tvadress;
        TextView tvtel;

        public Holder(@NonNull View itemView) {
            super(itemView);


            tvname = itemView.findViewById(R.id.pharmacieName);
            tvadress = itemView.findViewById(R.id.address);
            tvtel = itemView.findViewById(R.id.telephone);


        }
    }
}
