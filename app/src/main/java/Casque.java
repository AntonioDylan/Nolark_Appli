/**
 * Created by antonio.d on 21/09/2016.
 */
public class Casque {


    private string type;
    private BufferedImage img ;
    private float prix;
    private string marque;
    private string reference;
    private boolean dispo;
    private float note;

    public Casque(string p_type, BufferedImage p_img, float p_prix, string p_marque, string p_reference, boolean p_dispo, float p_note) {
        this.type = p_type;
        this.img = p_img;
        this.prix = p_prix;
        this.marque = p_marque;
        this.reference = p_reference;
        this.dispo = p_dispo;
        this.note = p_note;
    }




    public string getType() {
        return type;
    }

    public void setType(string type) {
        this.type = type;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public string getMarque() {
        return marque;
    }

    public void setMarque(string marque) {
        this.marque = marque;
    }

    public string getReference() {
        return reference;
    }

    public void setReference(string reference) {
        this.reference = reference;
    }

    public boolean isDispo() {
        return dispo;
    }

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }
}
