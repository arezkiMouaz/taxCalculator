package com.up.taxes.entite;

import com.up.taxes.enumeration.TypeProduit;
import com.up.taxes.service.AfficheurService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AfficheurServiceTest {

    private final AfficheurService afficheurService = new AfficheurService();

    @Test
    void testAfficherProduitsCommandeAvecUnSeulProduit() {
        Produit produit = new Produit("CD musical", 14.99, 1, TypeProduit.CD, false);
        double prixAvecTaxe = produit.getPrixAvecTaxe();
        double taxe = produit.getTaxe();

        Commande commande = new Commande(Arrays.asList(produit));
        String resultat = afficheurService.afficherProduits(commande);

        String resultatAttendu = "1 CD musical : " + String.format("%.2f", prixAvecTaxe) + "\n" +
                "Montant des taxes : " + String.format("%.2f", taxe) + "\n" +
                "Total : " + String.format("%.2f", prixAvecTaxe);

        assertEquals(resultatAttendu, resultat);
    }

    @Test
    void testAfficherProduitsCommandeAvecProduitExemptEtImporte() {
        Produit produit = new Produit("boîte de chocolat importée", 10.00, 1, TypeProduit.NOURRITURE, true);
        double prixAvecTaxe = produit.getPrixAvecTaxe();
        double taxe = produit.getTaxe();

        Commande commande = new Commande(Arrays.asList(produit));
        String resultat = afficheurService.afficherProduits(commande);

        String resultatAttendu = "1 boîte de chocolat importée : " + String.format("%.2f", prixAvecTaxe) + "\n" +
                "Montant des taxes : " + String.format("%.2f", taxe) + "\n" +
                "Total : " + String.format("%.2f", prixAvecTaxe);

        assertEquals(resultatAttendu, resultat);
    }

    @Test
    void testAfficherProduitsCommandeAvecProduitsMultiples() {
        Produit produit1 = new Produit("livre", 12.49, 1, TypeProduit.LIVRE, false);
        Produit produit2 = new Produit("CD musical", 14.99, 1, TypeProduit.CD, false);
        Produit produit3 = new Produit("chocolat importé", 10.00, 1, TypeProduit.NOURRITURE, true);

        double taxe1 = produit1.getTaxe();
        double prixAvecTaxe1 = produit1.getPrixAvecTaxe();

        double taxe2 = produit2.getTaxe();
        double prixAvecTaxe2 = produit2.getPrixAvecTaxe();

        double taxe3 = produit3.getTaxe();
        double prixAvecTaxe3 = produit3.getPrixAvecTaxe();

        Commande commande = new Commande(Arrays.asList(produit1, produit2, produit3));
        String resultat = afficheurService.afficherProduits(commande);

        String resultatAttendu = "1 livre : " + String.format("%.2f", prixAvecTaxe1) + "\n" +
                "1 CD musical : " + String.format("%.2f", prixAvecTaxe2) + "\n" +
                "1 chocolat importé : " + String.format("%.2f", prixAvecTaxe3) + "\n" +
                "Montant des taxes : " + String.format("%.2f", (taxe1 + taxe2 + taxe3)) + "\n" +
                "Total : " + String.format("%.2f", (prixAvecTaxe1 + prixAvecTaxe2 + prixAvecTaxe3));

        assertEquals(resultatAttendu, resultat);
    }

    @Test
    void testAfficherProduitsCommandeVide() {
        Commande commande = new Commande(Arrays.<Produit>asList());
        String resultat = afficheurService.afficherProduits(commande);

        String resultatAttendu = String.format(Locale.FRANCE, "Montant des taxes : %.2f\nTotal : %.2f", 0.00, 0.00);

        assertEquals(resultatAttendu, resultat);
    }
}
