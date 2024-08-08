package com.up.taxes.entite;

import com.up.taxes.enumeration.TypeProduit;

import java.util.Arrays;

public class Taxe {

    public static final double TVA = 0.1;
    public static final double TAXE_SUPPLEMENTARE = 0.05;
    public static final double TAXE_ZERO = 0.0;

    private TypeProduit[] produitsNonTaxes = {TypeProduit.LIVRE, TypeProduit.NOURRITURE, TypeProduit.MEDICAMENT};

    public double calculateTaxe(Produit produit) {
        double tva = (Arrays.asList(produitsNonTaxes).contains(produit.getTypeProduit())) ? TAXE_ZERO : TVA;
        double taxe = produit.getPrix() * tva;
        if (produit.isImporte()) taxe += produit.getPrix() * TAXE_SUPPLEMENTARE;
        return arrondirAuFiveCents(taxe);
    }

    public static  double arrondirAuFiveCents(double montant) {
        return Math.ceil(montant * 20) / 20.0;
    }
}
