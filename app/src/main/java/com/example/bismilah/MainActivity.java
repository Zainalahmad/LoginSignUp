package com.example.bismilah;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button login, register;
    private EditText etUsername, etPass;
    private DbHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DbHelper(this);
        session = new Session(this);
        login = (Button)findViewById(R.id.btnLogin);
        register = (Button)findViewById(R.id.btnReg);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPass = (EditText)findViewById(R.id.etPass);
        login.setOnClickListener(this);
        register.setOnClickListener(this);

        if (session.loggedin()){
            startActivity(new Intent(MainActivity.this,isiannama.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnReg:
                startActivity(new Intent(MainActivity.this,SiqnUp.class));
                break;
            default:

        }
    }

    private void login(){
        String user = etUsername.getText().toString();
        String pass = etPass.getText().toString();

        if(db.getUser(user,pass)){
            session.setLoggedin(true);
            startActivity(new Intent(MainActivity.this, isiannama.class));
            finish();
            Toast.makeText(MainActivity.this, "Selamat datang " + user.toString(), Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(MainActivity.this, "Gagal " + user.toString(), Toast.LENGTH_LONG).show();

        }
    }
}