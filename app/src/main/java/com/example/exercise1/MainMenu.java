package com.example.exercise1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainMenu extends AppCompatActivity {

    EditText edTask, edJenis,edWaktu;
    TextView edNama,edname;
    String task,jenis,waktu,nama,nm;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        edTask=findViewById(R.id.inputtask);
        edJenis=findViewById(R.id.inputjenis);
        edWaktu=findViewById(R.id.inputwaktu);

        fab=findViewById(R.id.simpan);
        edNama = findViewById(R.id.idnama);
        edname = findViewById(R.id.idname);

        Bundle sg = getIntent().getExtras();
        nama = sg.getString("x");
        edNama.setText(nama);

        Bundle sc = getIntent().getExtras();
        nm = sc.getString("a");
        edname.setText(nm);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                task = edTask.getText().toString();
                jenis = edJenis.getText().toString();
                waktu = edWaktu.getText().toString();

                if (jenis.length()==0){
                    edTask.setError("Jenis task");

                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else if (waktu.length()==0){
                    edTask.setError("waktu task");

                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else if (task.isEmpty()){
                    Toast.makeText(getApplicationContext(),"masukan semua data",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_LONG).show();

                    Bundle bd = new Bundle();

                    bd.putString("Task",task.trim());
                    bd.putString("jns",jenis.trim());
                    bd.putString("wkt",waktu.trim());

                    Intent dt = new Intent(getApplicationContext(), TampilanAkhir.class);

                    dt.putExtras(bd);
                    startActivity(dt);

                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.itSubmit) {
            edTask = findViewById(R.id.inputtask);
            edJenis = findViewById(R.id.inputjenis);
            edWaktu = findViewById(R.id.inputwaktu);

            task = edTask.getText().toString();
            jenis = edJenis.getText().toString();
            waktu = edWaktu.getText().toString();
            if (jenis.length() == 0) {
                edTask.setError("Jenis task");

                Toast.makeText(getApplicationContext(), "masukan semua data", Toast.LENGTH_LONG).show();
            } else if (waktu.length() == 0) {
                edTask.setError("waktu task");

                Toast.makeText(getApplicationContext(), "masukan semua data", Toast.LENGTH_LONG).show();
            } else if (task.isEmpty()) {
                Toast.makeText(getApplicationContext(), "masukan semua data", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();

                Bundle bd = new Bundle();

                bd.putString("Task", task.trim());
                bd.putString("jns", jenis.trim());
                bd.putString("wkt", waktu.trim());

                Intent dt = new Intent(getApplicationContext(), TampilanAkhir.class);

                dt.putExtras(bd);
                startActivity(dt);

            }

        }
        else{
            Intent out = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(out);
        }
        return super.onOptionsItemSelected(item);
    }
}