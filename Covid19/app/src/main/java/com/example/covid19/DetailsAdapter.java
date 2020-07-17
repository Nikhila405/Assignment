package com.example.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.myHolder> {
    Context Ct;
    List<Details> covid;

    public DetailsAdapter(Context ct, List<Details> mydata) {
        Ct = ct;
        covid = mydata;
    }

    @NonNull
    @Override
    public DetailsAdapter.myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(Ct).inflate(R.layout.display, parent, false);
        myHolder holder = new myHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.myHolder holder, int position) {
        Details C = covid.get(position);
        holder.date.setText(C.getDate());
        holder.active.setText(C.getActive());
        holder.recovered.setText(C.getRecovered());
        holder.death.setText(C.getDeath());
    }


    @Override
    public int getItemCount() {
        return covid.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        TextView active, date, recovered, death;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            active = itemView.findViewById(R.id.Active);
            date = itemView.findViewById(R.id.Date);
            recovered = itemView.findViewById(R.id.Recovered);
            death = itemView.findViewById(R.id.Death);
        }
    }
}

