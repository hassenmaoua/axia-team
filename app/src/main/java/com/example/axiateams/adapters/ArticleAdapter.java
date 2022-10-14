package com.example.axiateams.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.axiateams.R;
import com.example.axiateams.objects.facture.Article;
import com.example.axiateams.objects.tache.Tache;

import java.sql.Array;
import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, int resource, List<Article> ligne) {
        super(context, resource, ligne);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Article article = getItem(position);

        if (view == null)
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_article, parent, false);

        TextView num = view.findViewById(R.id.num_article);
        TextView designation = view.findViewById(R.id.designation_article);
        TextView quantite = view.findViewById(R.id.quantite_article);
        TextView prixUnitaire = view.findViewById(R.id.prixUnitaire_article);
        TextView montantTVA = view.findViewById(R.id.montantTVA_article);
        TextView montantHT = view.findViewById(R.id.montantHT_article);



        num.setText(article.getNum());
        designation.setText(article.getDesignation());
        quantite.setText("" + article.getQuantite());
        prixUnitaire.setText(Double.toString(article.getPrixUnitaire()));
        montantTVA.setText(article.getMontantTVA());
        montantHT.setText(article.getMontantHT());

        return view;
    }
}
