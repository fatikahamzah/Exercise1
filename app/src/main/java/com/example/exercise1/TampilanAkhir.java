package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TampilanAkhir extends AppCompatActivity {

    TextView txTask,txJenis,txWaktu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_akhir);

        txTask=findViewById(R.id.hsl_task);
        txJenis=findViewById(R.id.hsl_jenis2);
        txWaktu=findViewById(R.id.hsl_time);
        Bundle bundle=getIntent().getExtras();
        String tgs=bundle.getString("Task");
        String jns=bundle.getString("jns");
        String wkt=bundle.getString("wkt");
        txTask.setText(tgs);
        txJenis.setText(jns);
        txWaktu.setText(wkt);
    }
}