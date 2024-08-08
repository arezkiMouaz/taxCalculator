package com.up.taxes.service;

import com.up.taxes.entite.Commande;
import com.up.taxes.entite.Produit;
import java.util.List;

public class AfficheurService {


    public String afficherProduits(Commande commande) {
        StringBuilder sb = new StringBuilder();
        double totalTaxes = 0.0;
        double totalPrice = 0.0;
        List<Produit> produits = commande.getProduits();

        for (Produit produit : produits) {
            double prixAvecTaxe = produit.getPrixAvecTaxe();

            sb.append(produit.getQuantity()).append(" ")
                    .append(produit.getLibelle()).append(" : ")
                    .append(String.format("%.2f", prixAvecTaxe)).append("\n");

            totalTaxes += produit.getTaxe() * produit.getQuantity();
            totalPrice += prixAvecTaxe * produit.getQuantity();
        }

        sb.append("Montant des taxes : ")
                .append(String.format("%.2f", totalTaxes)).append("\n")
                .append("Total : ")
                .append(String.format("%.2f", totalPrice));

        return sb.toString();
    }

}
