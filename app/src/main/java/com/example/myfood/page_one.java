package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class page_one extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_one);
        Thread thread=new Thread(){
            @Override
            public void run(){
                try{
                    sleep(7000);
                }catch (Exception e ){
                    e.printStackTrace();
                }finally {
                    Intent mainIntent= new Intent(page_one.this, login.class);
                    startActivity(mainIntent);
                }

            }
        };
        thread.start();
    }
    protected  void onPause(){
        super.onPause();
        finish();
    }
}