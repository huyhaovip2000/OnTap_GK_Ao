package com.example.gk_ao_06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ao_Adapter  extends RecyclerView.Adapter<Ao_Adapter.ThingViewHolder> {

    private Context context;
    private ArrayList<Ao> aoArrayList;
    private Ao_Onclick ao_onclick;

    public Ao_Adapter(Context context, ArrayList<Ao> aoArrayList, Ao_Onclick ao_onclick) {
        this.context = context;
        this.aoArrayList = aoArrayList;
        this.ao_onclick = ao_onclick;
    }

    @NonNull
    @Override
    public Ao_Adapter.ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout01, parent,false);

        return new ThingViewHolder(view, this);
    }



    @Override
    public int getItemCount() {
        return aoArrayList.size();
    }

    public class ThingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName_01, tvGia_01;
        private ImageView imageView_01;
        private Button btn_ADD;

        Ao ao;
        Ao_Adapter adapter;


        public ThingViewHolder(@NonNull View itemView, Ao_Adapter ao_adapter) {
            super(itemView);
            tvName_01 = itemView.findViewById(R.id.tvName_01);
            tvGia_01 = itemView.findViewById(R.id.tvGia_01);
            imageView_01 = itemView.findViewById(R.id.imageView_01);
            btn_ADD = itemView.findViewById(R.id.btn_add);
            this.adapter = ao_adapter;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ao_onclick.itemClick(ao);
                }
            });




        }
    }

    @Override
    public void onBindViewHolder(@NonNull Ao_Adapter.ThingViewHolder holder, int position) {
        Ao ao = aoArrayList.get(position);
        holder.ao = aoArrayList.get(position);

        holder.tvName_01.setText(ao.getTvName_01());
        holder.tvGia_01.setText(ao.getTvGia_01()+"");
        holder.imageView_01.setImageResource(ao.getImageView_01());



    }
}
