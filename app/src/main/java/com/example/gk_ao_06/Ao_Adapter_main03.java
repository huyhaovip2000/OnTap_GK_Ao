package com.example.gk_ao_06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Ao_Adapter_main03 extends RecyclerView.Adapter<Ao_Adapter_main03.ThingViewHolder> {
    private Context context;
    private ArrayList<Ao> aoArrayList;
    private Ao_Onclick listener;




    public Ao_Adapter_main03(Context context, ArrayList<Ao> aoArrayList,Ao_Onclick listener) {
        this.context = context;
        this.aoArrayList = aoArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public Ao_Adapter_main03.ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.layout03, parent, false);

        return new ThingViewHolder(view, this);
    }



    @Override
    public int getItemCount() {
        return aoArrayList.size();
    }

    public class ThingViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName_03, tvGia_03, tvSoLuong,tvSize;
        private ImageView imageView_03;
        private ImageButton imageButton_Minus_03, imageButton_Add_03;
        Ao ao1;
        Ao_Adapter_main03 adapterMain03;
        int position;

        public ThingViewHolder(@NonNull View itemView, Ao_Adapter_main03 ao_adapter_main03) {
            super(itemView);

            tvName_03 = itemView.findViewById(R.id.tvName_03);
            tvGia_03 = itemView.findViewById(R.id.tvGia_03);
            imageView_03 = itemView.findViewById(R.id.imageView_03);
            imageButton_Minus_03 = itemView.findViewById(R.id.imageButton_Minus_03);
            imageButton_Add_03 = itemView.findViewById(R.id.imageButton_Add_03);
            tvSoLuong = itemView.findViewById(R.id.tvSoLuong_layout03);
            tvSize = itemView.findViewById(R.id.tvSize_03);

            imageButton_Add_03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.imgbtnPlus(ao1
                    ,position);
                }
            });

            imageButton_Minus_03.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.imgbtnMinus(ao1
                            ,position);
                }
            });



        }
    }


    @Override
    public void onBindViewHolder(@NonNull Ao_Adapter_main03.ThingViewHolder holder, int position) {
            Ao ao = aoArrayList.get(position);

//            holder.ao = aoArrayList.get(position);
            holder.position = position;

            holder.tvName_03.setText(ao.getTvName_01());
            holder.tvGia_03.setText(ao.getTvGia_01()+"");
            holder.imageView_03.setImageResource(ao.getImageView_01());
            holder.tvSoLuong.setText(ao.getSoLuong()+"");
            holder.tvSize.setText(ao.getSize());



    }
}
