package Entity; /**
 * Created by antonio.d on 21/09/2016.
 */
import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

public class Casque {


  // private String type;
    private Bitmap img ;
    private Double prix;
    private String marque;
    private String modele;
    private int dispo;
    private int note;

    public Casque( Bitmap p_img, Double p_prix, String p_marque, String p_modele, int p_dispo, int p_note) {
        this.img = p_img;
        this.prix = p_prix;
        this.marque = p_marque;
        this.modele = p_modele;
        this.dispo = p_dispo;
        this.note = p_note;

   }




 /*  public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
*/
    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
