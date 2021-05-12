package com.example.myfood.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood.DBHelper;
import com.example.myfood.Models.MainModel;
import com.example.myfood.Models.commandesModel;
import com.example.myfood.R;

import java.util.ArrayList;

public class commandesAdapter extends RecyclerView.Adapter<commandesAdapter.viewHolder> {

    ArrayList<commandesModel> list;
    Context context;

    public commandesAdapter(ArrayList<commandesModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.echantillon_commande,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final commandesModel model =list.get(position);
        holder.imageCommande.setImageResource(model.getImageCommande());
        holder.nomcommande.setText(model.getNomcommande());
        holder.numcommande.setText(model.getNumcommande());
        holder.prix.setText(model.getPrix());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    DBHelper helper =new DBHelper(context);
                    if(helper.supprimecommande(model.getNumcommande())>0){
                        Toast.makeText(context,"commande supprimée",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(context,"erreur",Toast.LENGTH_LONG).show();}

            }



        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageCommande;
        TextView nomcommande, numcommande, prix;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageCommande=itemView.findViewById(R.id.imageView);
            nomcommande=itemView.findViewById(R.id.name);
            numcommande=itemView.findViewById(R.id.numcommande);
            prix=itemView.findViewById(R.id.textView7);
        }
    }
}


