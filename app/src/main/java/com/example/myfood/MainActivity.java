package com.example.myfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.myfood.Adapters.MainAdapter;
import com.example.myfood.Models.MainModel;
import com.example.myfood.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Objects;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
       ActivityMainBinding binding ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel> list =new ArrayList<>();
        list.add(new MainModel(R.drawable.sandwitech , "burger" , "5.00" ,"2 Tranches de pain, entre lesquelles on met une tranche de jambon, de fromage,de escalope  "));
        list.add(new MainModel(R.drawable.pizza1 , "Pizza" , "6.50" ," Galette italienne en pâte à pain garnie de mozzarelle, de tomates, d'anchois, d'olives, etc"));
        list.add(new MainModel(R.drawable.bagette_facie , "Baguette farcie " , "10.00" ,"Une baguette apéritive fourrée au jambon, fromage et aux œufs durs"));
        list.add(new MainModel(R.drawable.spagitti, "Spaghetti" , "4.00" ,"l'offre de remise  se termine dimanche 14 décembre"));
        list.add(new MainModel(R.drawable.sandwitech , "burger" , "5.00" ,"2 Tranches de pain, entre lesquelles on met une tranche de jambon, de fromage,de escalope  "));
        list.add(new MainModel(R.drawable.pizza1 , "Pizza" , "6.50" ," Galette italienne en pâte à pain garnie de mozzarelle, de tomates, d'anchois, d'olives, etc"));
        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyler.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyler.setLayoutManager(layoutManager);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.MESCommandes:
                startActivity( new Intent(MainActivity.this,Main_commande.class));
        }
        return super.onOptionsItemSelected(item);
    }
}