package com.example.gk_ao_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements Ao_Onclick{
    private RecyclerView rcv_Ao_main_03;
//    private ArrayList<Ao> aoArrayList;
    private Ao_Adapter_main03 adapterMain03;
    private TextView tvSub,tvTotal;//tong




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

//        aoArrayList = new ArrayList<>();

        rcv_Ao_main_03 = findViewById(R.id.rcv_Ao_main_03);
        tvSub = findViewById(R.id.tvSub);
        tvTotal = findViewById(R.id.tvTotal);

        tvSub.setText(MainActivity2.tong+"");//tong
        tvTotal.setText(MainActivity2.tong+"");

        adapterMain03 = new Ao_Adapter_main03(this, MainActivity2.aos,this);
        rcv_Ao_main_03.setAdapter(adapterMain03);
        rcv_Ao_main_03.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL
        ,false));



    }

    @Override
    public void itemClick(Ao ao) {

    }

    @Override
    public void imgbtnPlus(Ao ao, int position) {
        int soLuong = MainActivity2.aos.get(position).getSoLuong()+1;
        MainActivity2.aos.get(position).setSoLuong(soLuong);

        MainActivity2.tong = 0;
        for(Ao a:MainActivity2.aos){
            MainActivity2.tong+=a.getSoLuong()*a.getTvGia_01();
        }
        tvSub.setText(MainActivity2.tong+"");//tong
        tvTotal.setText(MainActivity2.tong+"");



        adapterMain03 = new Ao_Adapter_main03(this, MainActivity2.aos,this);
        rcv_Ao_main_03.setAdapter(adapterMain03);
        rcv_Ao_main_03.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void imgbtnMinus(Ao ao, int position) {
        int soLuong = MainActivity2.aos.get(position).getSoLuong()-1;//2

        if(soLuong >  0){
//            soLuong--;
            MainActivity2.aos.get(position).setSoLuong(soLuong);

            MainActivity2.tong = 0;
            for(Ao a:MainActivity2.aos){
                MainActivity2.tong+=a.getSoLuong()*a.getTvGia_01();
            }
            tvSub.setText(MainActivity2.tong+"");//tong
            tvTotal.setText(MainActivity2.tong+"");

            adapterMain03 = new Ao_Adapter_main03(this, MainActivity2.aos,this);
            rcv_Ao_main_03.setAdapter(adapterMain03);
            rcv_Ao_main_03.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        }

    }


}