package Entity; /**
 * Created by antonio.d on 21/09/2016.
 */
import android.widget.ImageView;

public class Casque {


  // private String type;
    private String img ;
    private Double prix;
    private String marque;
    private String reference;
    private int dispo;
    private int note;

    public Casque( /*String p_type ,*/ String p_img, Double p_prix, String p_marque, String p_reference, int p_dispo, int p_note) {
       // this.type = p_type;
        this.img = p_img;
        this.prix = p_prix;
        this.marque = p_marque;
        this.reference = p_reference;
        this.dispo = p_dispo;
        this.note = p_note;
    }




   /* public String getType() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int isDispo() {
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
