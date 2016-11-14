package Service;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.antoniod.nolark_appli.R;

import java.util.List;

import Entity.Casque;
import Entity.CasqueViewHolder;

/**
 * Created by antonio.d on 07/11/2016.
 */

/**
 *IMAGE URL :
 * http://nolark.sevenn.fr/bundles/nolark/images/casques/ + "route/" + "image.jpg"
 */

public class CasqueAdapter extends ArrayAdapter<Casque> {


    public CasqueAdapter(Context context, List<Casque> casques) {
        super(context, 0, casques);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tweet,parent, false);
        }

        CasqueViewHolder viewHolder = (CasqueViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CasqueViewHolder();
            viewHolder.modele = convertView.findViewById(R.id.modele);
            viewHolder.marque = (TextView) convertView.findViewById(R.id.marque);
            viewHolder.prix = (TextView) convertView.findViewById(R.id.prix);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.etatDispo = (ImageView) convertView.findViewById(R.id.etatDispo);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Casque casque = getItem(position);

        //Remplissage de la vue
        viewHolder.modele.setText(casque.getModele());
        viewHolder.marque.setText(casque.getMarque());
        viewHolder.prix.setText(String.valueOf(casque.getPrix()));
        viewHolder.image.setImageBitmap(casque.getImg());
        viewHolder.etatDispo.setText(casque.getDispo());



        return convertView;
    }


}
