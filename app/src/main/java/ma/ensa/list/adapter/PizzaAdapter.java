package ma.ensa.list.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ma.ensa.list.R;
import ma.ensa.list.beans.Produit;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> pizzas;
    private LayoutInflater inflater;

    public PizzaAdapter(List<Produit> pizzas, Activity activity) {
        this.pizzas = pizzas;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item, null);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        ImageView photo = convertView.findViewById(R.id.photo);
        TextView id = convertView.findViewById(R.id.id);
        TextView nbr = convertView.findViewById(R.id.nbrIngredient);

        nom.setText(pizzas.get(position).getNom());
        duree.setText(pizzas.get(position).getDuree()+"");
        photo.setImageResource(pizzas.get(position).getPhoto());
        id.setText(String.valueOf(pizzas.get(position).getId()));
        nbr.setText(String.valueOf(pizzas.get(position).getNbrIngredients()));

        return convertView;
    }

}
