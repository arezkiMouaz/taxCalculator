package com.up.taxes.entite;
import com.up.taxes.enumeration.TypeProduit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaxesTest {

    private final Taxe taxe = new Taxe();

    @Test
    void testCalculerTaxeProduitNonExempt() {
        Produit produit = new Produit("CD musical", 14.99, 1, TypeProduit.CD, false);
        double taxeAttendue = Taxe.arrondirAuFiveCents(14.99 * Taxe.TVA); // 10% TVA
        double resultat = taxe.calculateTaxe(produit);
        assertEquals(taxeAttendue, resultat, "La taxe devrait être de 10% du prix du produit, arrondie au 5 centimes supérieur.");
    }

    @Test
    void testCalculerTaxeProduitImporte() {
        Produit produit = new Produit("livre importé", 12.49, 1, TypeProduit.LIVRE, true);
        double taxeAttendue = Taxe.arrondirAuFiveCents(12.49 * Taxe.TAXE_SUPPLEMENTARE); // 5% de taxe supplémentaire pour les produits importés
        double resultat = taxe.calculateTaxe(produit);
        assertEquals(taxeAttendue, resultat, "La taxe devrait être de 5% du prix du produit pour les produits importés, arrondie au 5 centimes supérieur.");
    }

    @Test
    void testCalculerTaxeProduitExempt() {
        Produit produit = new Produit("livre", 9.99, 1, TypeProduit.LIVRE, false);
        double taxeAttendue = 0.0; // Pas de taxe pour les livres
        double resultat = taxe.calculateTaxe(produit);
        assertEquals(taxeAttendue, resultat, "Les livres devraient être exemptés de taxe.");
    }

    @Test
    void testCalculerTaxeProduitImporteExempt() {
        Produit produit = new Produit("nourriture importée", 5.99, 1, TypeProduit.NOURRITURE, true);
        double taxeAttendue = Taxe.arrondirAuFiveCents(5.99 * Taxe.TAXE_SUPPLEMENTARE); // 5% de taxe supplémentaire pour les aliments importés
        double resultat = taxe.calculateTaxe(produit);
        assertEquals(taxeAttendue, resultat, "La nourriture importée devrait avoir une taxe de 5%, arrondie au 5 centimes supérieur.");
    }

    @Test
    void testArrondirAuFiveCents() {
        assertEquals(0.20, Taxe.arrondirAuFiveCents(0.19), "Le montant devrait être arrondi au 5 centimes supérieur.");
        assertEquals(0.25, Taxe.arrondirAuFiveCents(0.22), "Le montant devrait être arrondi au 5 centimes supérieur.");
        assertEquals(0.30, Taxe.arrondirAuFiveCents(0.27), "Le montant devrait être arrondi au 5 centimes supérieur.");
        assertEquals(0.35, Taxe.arrondirAuFiveCents(0.34), "Le montant devrait être arrondi au 5 centimes supérieur.");
    }
}