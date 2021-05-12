package com.example.myfood.Models;

public class commandesModel {
    int imageCommande;
    String nomcommande, numcommande, prix;

    public commandesModel(int imageCommande, String nomcommande, String numcommande, String prix) {
        this.imageCommande = imageCommande;
        this.nomcommande = nomcommande;
        this.numcommande = numcommande;
        this.prix = prix;
    }

    public commandesModel() {

    }


    public int getImageCommande() {
        return imageCommande;
    }

    public void setImageCommande(int imageCommande) {
        this.imageCommande = imageCommande;
    }

    public String getNomcommande() {
        return nomcommande;
    }

    public void setNomcommande(String nomcommande) {
        this.nomcommande = nomcommande;
    }

    public String getNumcommande() {
        return numcommande;
    }

    public void setNumcommande(String numcommande) {
        this.numcommande = numcommande;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }
}