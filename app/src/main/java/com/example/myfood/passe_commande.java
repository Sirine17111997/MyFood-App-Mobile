package com.example.myfood;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myfood.databinding.ActivityPasseCommandeBinding;

import java.util.Objects;

import static java.util.Objects.*;

public class passe_commande extends AppCompatActivity {
    ActivityPasseCommandeBinding binding;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPasseCommandeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image", 0);
        final String prix = getIntent().getStringExtra("prix");
        final String nom = getIntent().getStringExtra("nom");
        final String description = getIntent().getStringExtra("descreption");
        binding.imageView2.setImageResource(image);
        binding.valeur.setText(prix);
        binding.foodname.setText(nom);
        binding.textpass.setText(description);
        final DBHelper db = new DBHelper(this);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ins = db.InsertCommande(binding.yourName.getText().toString(), binding.phone.getText().toString(), prix, image, description, nom, Integer.parseInt(binding.quantite.getText().toString()));

                if (ins)
                    Toast.makeText(passe_commande.this, "commande validée", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(passe_commande.this, "echec ,la commande n'est pas valide", Toast.LENGTH_LONG).show();
            }


        });
    }
}