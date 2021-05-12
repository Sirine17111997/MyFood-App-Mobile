package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText username,password;
    Button signin ,signup;
    final DBHelper db = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText)findViewById(R.id.usernameconnexion);
        password=(EditText)findViewById(R.id.password);
        signin=(Button)findViewById(R.id.connexion);
        signup=(Button)findViewById(R.id.register);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String user=username.getText().toString();
               String pass =password.getText().toString();
               if(user.equals("")||pass.equals("")){
                   Toast.makeText(login.this,"il ya des champs vides",Toast.LENGTH_LONG).show();
               }else{
                   boolean checkuserpass =db.trouverusernamepassword(user,pass);
                   if(checkuserpass==true){
                       Toast.makeText(login.this,"connexion sucess",Toast.LENGTH_LONG).show();
                       Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                       startActivity(intent);
                   }else{
                       Toast.makeText(login.this ,"password incorret",Toast.LENGTH_LONG).show();

                   }
               }

            }
        });
    }
}