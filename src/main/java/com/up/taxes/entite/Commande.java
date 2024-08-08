package com.up.taxes.entite;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    private List<Produit> produits = new ArrayList<Produit>();

    public Commande(List<Produit> produits) {
        this.produits = produits;
    }

    public List<Produit> getProduits() {
        return new ArrayList<Produit>(produits);
    }
}
