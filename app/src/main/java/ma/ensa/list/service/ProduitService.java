package ma.ensa.list.service;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.list.beans.Produit;
import ma.ensa.list.dao.IDao;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;

    public ProduitService(List<Produit> listePizza) {
        this.produits = new ArrayList<>(listePizza);
    }
    @Override
    public boolean create(Produit produit) {
        return produits.add(produit);
    }

    @Override
    public Produit findById(int id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public boolean delete(Produit produit) {
        return produits.remove(produit);
    }

    @Override
    public boolean update(Produit produit) {
        Produit existingProduit = findById(produit.getId());
        if (existingProduit != null) {
            existingProduit.setNom(produit.getNom());
            existingProduit.setNbrIngredients(produit.getNbrIngredients());
            existingProduit.setPhoto(produit.getPhoto());
            existingProduit.setDuree(produit.getDuree());
            existingProduit.setDetailsIngredients(produit.getDetailsIngredients());
            existingProduit.setDescription(produit.getDescription());
            existingProduit.setPreparation(produit.getPreparation());
            return true;
        }
        return false;
    }
}
