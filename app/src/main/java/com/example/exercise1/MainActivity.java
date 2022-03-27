package com.example.exercise1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText edemail, edpassword;
    Button btnLgn, btnRgs;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLgn=findViewById(R.id.btsignin);
        btnRgs=findViewById(R.id.button);
        edemail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);

        btnRgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),Registrasi.class);
                startActivity(it);
            }
        });

        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String Nama = "Fatika";
                String Pass = "iniFatika";

                if (nama.equals(Nama)&&password.equals(Pass)){
                    Toast t = Toast.makeText(getApplicationContext(),"Login Sukses",Toast.LENGTH_LONG);
                    t.show();

                    Bundle b = new Bundle();
                    b.putString("x",nama.trim());

                    Intent i = new Intent(getApplicationContext(),MainMenu.class);
                    i.putExtras(b);
                    startActivity(i);
                }
                else {
                    Toast t = Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG);
                    t.show();
                }
            }
        });

    }
}


