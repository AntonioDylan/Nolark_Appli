package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by antonio.d on 26/09/2016.
 */
public class Panier {


    private float prixTotal = 0;
    private ArrayList<Casque> listPanier = new ArrayList<Casque>();



    public Panier(float p_prixTotal) {
        this.prixTotal = prixTotal;
    }



    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public List<Casque> getListPanier() {
        return listPanier;
    }

    public void setListPanier(ArrayList<Casque> listPanier) {
        this.listPanier = listPanier;
    }

    public void addCasque(Casque p_Casque)
    {
        this.listPanier.add(p_Casque);
        prixTotal += p_Casque.getPrix();
    }

    public void suppCasque(int p_Id,Casque p_Casque)
    {
        this.listPanier.remove(p_Id);
        prixTotal -= p_Casque.getPrix();
    }


}

