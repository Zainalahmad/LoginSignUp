package com.example.bismilah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class isiannama extends AppCompatActivity {
    private Button btnLogout;
    private Button btndetail;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isiannama);

        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);
        btndetail = (Button)findViewById(R.id.btndetail);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }

        });

      btndetail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                detail();
                finish();
            }
        });
    }

    private void detail() {
        startActivity(new Intent(isiannama.this, DetailUser.class));
    }

    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(isiannama.this,MainActivity.class));
    }

}