package com.example.myfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myfood.Adapters.commandesAdapter;
import com.example.myfood.Models.commandesModel;
import com.example.myfood.databinding.ActivityMainBinding;
import com.example.myfood.databinding.ActivityMainCommandeBinding;

import java.util.ArrayList;

public class Main_commande extends AppCompatActivity {
    ActivityMainCommandeBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainCommandeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper commandedatabase = new DBHelper(this);
        ArrayList<commandesModel> list = commandedatabase.getCommandes();


        commandesAdapter adapter = new commandesAdapter(list,this);
        binding.recylecommande.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recylecommande.setLayoutManager(layoutManager);
    }
}