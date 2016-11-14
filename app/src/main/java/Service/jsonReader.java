package Service; /**
 * Created by antonio.d on 26/09/2016.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;

import com.example.antoniod.nolark_appli.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Entity.Casque;


public class jsonReader {

    public static ArrayList<Casque> setCasques() {

        ArrayList<Casque> casques = new ArrayList<Casque>();

        try {

            //Connection à l'API
            String typeCasque = convertView.findViewById(R.id.etatDispo);
            String myurl= "http://nolark.sevenn.fr/casque/" +typeCasque+".json";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
            * Elle contient une méthode InputStreamToString.
                    */
            String result = InputStreamOperations.InputStreamToString(inputStream);



            /////////////////////////


            //Parse des vahttp://nolark.sevenn.fr/casque/cross.jsonleurs provenant de l'API en JSONs


            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);


            // On récupère le tableau d'objets qui nous concernent
                JSONArray array = new JSONArray(jsonObject.getString("casques"));
            // Pour tous les objets on récupère les infos




            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));

                //Conversion URL de l'image en Image
                String photo_url_str = "http://nolark.sevenn.fr/bundles/nolark/images/casques/" + typeCasque + "/" + obj.getString("img");
                URL newurl = new URL(photo_url_str);
                Bitmap mIcon_val = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());

                // On fait le lien Casque - Objet JSON
                Casque casque = new Casque(mIcon_val,obj.getDouble("prix"), obj.getString("marque"),obj.getString("modele"),obj.getInt("stock"),obj.getInt("classement"));

                      //
                // On ajoute le casque à la liste
                casques.add(casque);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des casques
        return casques;
    }
}
