package com.example.gk_ao_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvName_02, tvGia_02, tvSoLuong;
    private ImageView imageView_02;
    private ImageButton imageButton_Minus, imageButton_Add;
    private Button btn_add;
    private Button btnS, btnM, btnL,btnXL;


    ///////////////////////////////////////////////////////////////////////////////////////////////////Total
    static int tong ;

    Ao ao;

    static ArrayList<Ao> aos;
    static {
        aos = new ArrayList<>();
        ////////////////////////////////////////////////////////////////////////tong
        tong = 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvGia_02 = findViewById(R.id.tvGia_02);
        tvName_02 = findViewById(R.id.tvName_02);
        imageView_02 = findViewById(R.id.imageView_02);
        btnS = findViewById(R.id.btnS);
        btnM = findViewById(R.id.btnM);
        btnL = findViewById(R.id.btnL);
        btnXL = findViewById(R.id.btnXL);

        btn_add = findViewById(R.id.btn_add);

        tvSoLuong = findViewById(R.id.tvSoLuong);
        imageButton_Add = findViewById(R.id.imageButton_Add);
        imageButton_Minus = findViewById(R.id.imageButton_Minus);

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ao.setSize("M");
            }
        });
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ao.setSize("S");
            }
        });
        btnL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ao.setSize("L");
            }
        });
        btnXL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ao.setSize("XL");
            }
        });

        Intent intent =  getIntent();
        if(intent !=  null){
            ao = (Ao) intent.getSerializableExtra("key1");
            tvName_02.setText(ao.getTvName_01());
            tvGia_02.setText(ao.getTvGia_01()+"");
            imageView_02.setImageResource(ao.getImageView_01());

        }


        imageButton_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuong = Integer.parseInt(tvSoLuong.getText().toString());
                soLuong++;
                tvSoLuong.setText(soLuong+"");
                ao.setSoLuong(soLuong);

            }
        });

        imageButton_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soLuong = Integer.parseInt(tvSoLuong.getText().toString());
                if(soLuong > 1){
                    soLuong--;
                    tvSoLuong.setText(soLuong+"");
                    ao.setSoLuong(soLuong);

                }


            }
        });




        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                aos.add(ao);
                //ao name:..,.., soLuong=1,size =XL

                ////////////////////////////////////////////////////////////////////////tong
                tong = 0;
                for(Ao a:aos){
                    tong+=a.getSoLuong()*a.getTvGia_01();
                }
                ////////////////////////////////////////////////////////////////////////tong
                startActivity(intent1);
            }
        });



    }
}