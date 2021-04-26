package com.example.gk_ao_06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Ao_Onclick {

    private RecyclerView rcv_Ao;
    private ArrayList<Ao> aoArrayList;
    private Ao_Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_Ao = findViewById(R.id.rcv_Ao);

        aoArrayList = new ArrayList<>();
        aoArrayList.add(new Ao("Ao 1", 10, R.drawable.code1,1,"S"));
        aoArrayList.add(new Ao("Ao 2", 20, R.drawable.google1,1,"S"));
        aoArrayList.add(new Ao("Ao 3", 30, R.drawable.google2,1,"S"));
        aoArrayList.add(new Ao("Ao 4", 40, R.drawable.images,1,"S"));

        adapter = new Ao_Adapter(this, aoArrayList, this);
        rcv_Ao.setAdapter(adapter);
        rcv_Ao.setHasFixedSize(true);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcv_Ao.setLayoutManager(gridLayoutManager);





    }

    @Override
    public void itemClick(Ao ao) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("key1", ao);
        startActivity(intent);
    }

    @Override
    public void imgbtnPlus(Ao ao, int position) {

    }

    @Override
    public void imgbtnMinus(Ao ao, int position) {

    }


}