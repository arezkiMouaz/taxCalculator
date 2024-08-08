package com.up.taxes;

import com.up.taxes.entite.Commande;
import com.up.taxes.entite.Produit;
import com.up.taxes.enumeration.TypeProduit;
import com.up.taxes.service.AfficheurService;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


    public static void main(String[] args) {

        //INPUT 1
        Produit produit1 = new Produit("livre", 12.49, 1, TypeProduit.LIVRE, false);
        Produit produit2 = new Produit("CD", 14.99, 1, TypeProduit.CD, false);
        Produit produit3 = new Produit("Barre de chocolat", 0.85, 1, TypeProduit.NOURRITURE, false);
        List<Produit> produits = new ArrayList<Produit>();
        produits.add(produit1);
        produits.add(produit2);
        produits.add(produit3);
        Commande commande = new Commande(produits);
        AfficheurService afficheur = new AfficheurService();
        String prouitsAvecTaxe = afficheur.afficherProduits(commande);
        //OUTPUT 1
        System.out.println("#### Output 1");
        System.out.println(prouitsAvecTaxe);

        //INPUT 2
        Produit produit4 = new Produit("Boite de chocolat importée", 10.00, 1, TypeProduit.NOURRITURE, true);
        Produit produit5 = new Produit("flacon de parfum importé", 47.50, 1, TypeProduit.COSMETIQUE, true);

        List<Produit> produits2 = new ArrayList<Produit>();
        produits2.add(produit4);
        produits2.add(produit5);

        Commande commande2 = new Commande(produits2);
        AfficheurService afficheur2 = new AfficheurService();
        String prouitsAvecTaxe2 = afficheur2.afficherProduits(commande2);
        //OUTPUT 2
        System.out.println("#### Output 2");
        System.out.println(prouitsAvecTaxe2);

        //INPUT 3
        //1 flacon de parfum importÈ à 27.99 1 flacon de parfum à 18.99 1 boîte de pilules contre la migraine à 9.75 1 boîte de chocolats importÈs à 11.25
        Produit produit6 = new Produit("flacon de parfum importé", 27.99, 1, TypeProduit.COSMETIQUE, true);
        Produit produit7 = new Produit("flacon de parfum", 18.99, 1, TypeProduit.COSMETIQUE, false);
        Produit produit8 = new Produit("boite pillule contre la migraine", 9.75, 1, TypeProduit.MEDICAMENT, false);
        Produit produit9 = new Produit("boile de chocolat importé", 11.25, 1, TypeProduit.NOURRITURE, true);

        List<Produit> produits3 = new ArrayList<Produit>();
        produits3.add(produit6);
        produits3.add(produit7);
        produits3.add(produit8);
        produits3.add(produit9);

        Commande commande3 = new Commande(produits3);
        AfficheurService afficheur3 = new AfficheurService();
        String prouitsAvecTaxe3 = afficheur3.afficherProduits(commande3);
        //OUTPUT 3
        System.out.println("#### Output 3");
        System.out.println(prouitsAvecTaxe3);


    }
}
