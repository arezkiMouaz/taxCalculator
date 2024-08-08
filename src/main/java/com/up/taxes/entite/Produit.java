package com.up.taxes.entite;

import com.up.taxes.enumeration.TypeProduit;

public class Produit {

    private final String libelle;
    private double prix;
    private Taxe taxe;
    private final int quantity;
    private final TypeProduit typeProduit;
    private final boolean importe;



    public Produit(String libelle, double prix, int quantity, TypeProduit typeProduit, boolean importe) {
        this.libelle = libelle;
        this.prix = prix;
        this.quantity = quantity;
        this.typeProduit = typeProduit;
        this.importe = importe;
        this.taxe = new Taxe();
    }

    public String getLibelle() {
        return libelle;
    }

    public double getTaxe() {
        return taxe.calculateTaxe(this);
    }

    public double getPrixAvecTaxe() {
        return prix + getTaxe();
    }


    public boolean isImporte() {
        return importe;
    }

    public double getPrix() {
        return prix;
    }

    public TypeProduit getTypeProduit() {
        return typeProduit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrixAvecTaxe(double prix) {
        this.prix = prix;
    }
}
