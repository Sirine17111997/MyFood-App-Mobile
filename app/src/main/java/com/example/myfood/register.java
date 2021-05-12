package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    final DBHelper db = new DBHelper(this);
    EditText username,password,passwordconfirm;
    Button  signup;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password1);
        passwordconfirm=(EditText)findViewById(R.id.passwordconfirm);

        signup=(Button)findViewById(R.id.inscrire);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repast= passwordconfirm.getText().toString();

                 if(user.equals("")|pass.equals("")|repast.equals("")){
                    Toast.makeText(register.this,"erreur de saisir",Toast.LENGTH_LONG).show();}
                 else{
                    if(pass.equals(repast)){
                        boolean checker =db.trouveuser(user);
                        if(checker==false){
                            boolean insert =db.insertuser(user,pass);
                            if(insert==true){
                                Toast.makeText(register.this,"inscription validé",Toast.LENGTH_LONG).show();
                                Intent intent =new Intent(getApplicationContext(),login.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(register.this,"inscription invalide",Toast.LENGTH_LONG).show();
                            }}
                        else{
                          Toast.makeText(register.this,"le nom de l'utilisateur est exist",Toast.LENGTH_LONG).show();
                        }}
                    else{
                        Toast.makeText(register.this,"le mot de passe n'est pas valide",Toast.LENGTH_LONG).show();

                        }

                    }


                }


        });

    }
}