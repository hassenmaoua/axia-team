package com.example.axiateams.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;

import com.example.axiateams.R;
import com.example.axiateams.objects.facture.Facture;

import java.util.List;

public class FactureAdapter extends ArrayAdapter<Facture> {
    public FactureAdapter(Context context, int resource, List<Facture> factureList) {
        super(context, resource, factureList);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Facture facture = getItem(position);

        if(view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_facture, parent, false);


        ImageView etat = (ImageView) view.findViewById(R.id.etat_icon);

        switch (facture.getEtat().getStyle()) {
            case "primary":
                etat.setImageResource(R.drawable.ic_nouveau);
                break;
            case "danger":
                etat.setImageResource(R.drawable.ic_annuler);
                break;
            case "success":
                etat.setImageResource(R.drawable.ic_valide);
                break;
        }


        TextView reference = (TextView) view.findViewById(R.id.reference);
        reference.setText(facture.getReference());

        TextView intituleTiers = (TextView) view.findViewById(R.id.intituleTiers);
        intituleTiers.setText(facture.getIntituleTiers());

        TextView montantTTC = (TextView) view.findViewById(R.id.montantTTC);
        montantTTC.setText(facture.getMontantTTC() + " " + facture.getDevise().getLabel());


        return view;
    }
}
