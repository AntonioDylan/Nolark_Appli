package Service; /**
 * Created by antonio.d on 26/09/2016.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import Entity.Casque;


public class jsonReader {

    public static ArrayList<Casque> setPersonnes() {

        ArrayList<Casque> casques = new ArrayList<Casque>();

        try {

            //Connection à l'API

            String myurl= "http://www.exemple.com/getPersonnes";

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


            //Parse des valeurs provenant de l'API en JSON


            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);


            // On récupère le tableau d'objets qui nous concernent
                JSONArray array = new JSONArray(jsonObject.getString("casques"));
            // Pour tous les objets on récupère les infos




            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));

                // On fait le lien Casque - Objet JSON
                Casque casque = new Casque(obj.getString("img"),obj.getDouble("prix"), obj.getString("marque"),obj.getString("reference"),obj.getInt("dispo"),obj.getInt("classement"));

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
