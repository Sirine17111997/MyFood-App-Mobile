package com.example.myfood.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood.Models.MainModel;
import com.example.myfood.R;
import com.example.myfood.passe_commande;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{
    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.echantillon_main,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
     final MainModel model =list.get(position);
     holder.foodimage.setImageResource(model.getImage());
     holder.nom.setText(model.getNom());
     holder.prix.setText(model.getPrix());
     holder.description.setText(model.getDescreption());
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(context, passe_commande.class);
             intent.putExtra("image",model.getImage());
             intent.putExtra("prix",model.getPrix());
             intent.putExtra("descreption",model.getDescreption());
             intent.putExtra("nom",model.getNom());
             context.startActivity(intent);
         }


        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView foodimage;
        TextView nom , prix  , description;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            foodimage = itemView.findViewById(R.id.imageView5);
            nom= itemView.findViewById(R.id.name);
            prix= itemView.findViewById(R.id.Prix);
            description=itemView.findViewById(R.id.desc);

        }
    }
}
