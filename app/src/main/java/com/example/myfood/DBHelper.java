package com.example.myfood;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.myfood.Models.commandesModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME="fooddatabase.db";
    final static int INT=4;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, INT);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("create Table commandes" +
             "(id Integer primary key autoincrement,"
             +"nom text,"+
             "phone text,"+
             "prix text,"+
             "image int,"+
             "description text,"+
             "foodname text,"+
             "quantite int )");

     db.execSQL("create Table users "+"(username text primary key ,password text)");}

        @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP table if exists commandes");
    db.execSQL("DROP table if exists users");
    onCreate(db);
    }
    public boolean InsertCommande(String nom , String phone , String prix , int image , String description , String foodname,int quantite){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("nom",nom);
        values.put("phone" ,phone);
        values.put("prix" ,prix);
        values.put("image" ,image);
        values.put("description" ,description);
        values.put ("foodname",foodname);
        values.put("quantite",quantite);
        long id=database.insert("commandes" ,null,values);
        if (id<=0){
            return false;
        }else{
            return true;
        }



    }
    public ArrayList<commandesModel> getCommandes() {
        ArrayList<commandesModel> commande = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image, prix from commandes", null);
        if (cursor.moveToFirst()) {
            while ((cursor.moveToNext())) {
                commandesModel model = new commandesModel();
                model.setNumcommande(cursor.getInt(0) + " ");
                model.setNomcommande(cursor.getString(1));
                model.setImageCommande(cursor.getInt(2));
                model.setPrix(cursor.getInt(3) + "");
                commande.add(model);
            }
            cursor.close();
            database.close();

        }
        return commande;
    }
    public boolean insertuser(String username ,String password){
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        long result = database.insert("users" ,null,contentValues);
        if(result<=0) return false;
        else
            return true;

    }
    public boolean trouveuser(String username){
        SQLiteDatabase database =this.getReadableDatabase();
        Cursor cursor;
        cursor = database.rawQuery( "Select * from users where username=?",
                new String[]{username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }
    public boolean trouverusernamepassword(String username,String password){
        SQLiteDatabase database =this.getWritableDatabase();
        Cursor cursor = database.rawQuery( "Select * from users where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else {
            return false;
        }


    }
    public int supprimecommande(String id){
        SQLiteDatabase database =this.getWritableDatabase();
        return  database.delete("commandes","id=" +id,null);
    }

}
