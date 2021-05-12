package com.example.myfood.Models;

public class MainModel {
    int image;
    String nom,prix,descreption;

    public MainModel(int image, String nom, String prix, String descreption) {
        this.image = image;
        this.nom = nom;
        this.prix = prix;
        this.descreption = descreption;
    }

    public int getImage() {
        return image;
    }

    public String getNom() {
        return nom;
    }

    public String getPrix() {
        return prix;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
}
