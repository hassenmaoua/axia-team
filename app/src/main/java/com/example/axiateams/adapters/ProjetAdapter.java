package com.example.axiateams.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.axiateams.R;
import com.example.axiateams.objects.ProjetItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProjetAdapter extends ArrayAdapter<ProjetItem>{


    public ProjetAdapter(Context context, int resource, List<ProjetItem> ProjetItemList) {
        super(context, resource, ProjetItemList);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProjetItem projet = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_projet, parent, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.title_textView);
        TextView state = (TextView) convertView.findViewById(R.id.state_text);
        ImageView image = (ImageView) convertView.findViewById(R.id.grid_image);

        title.setText(projet.getIntitule());


        state.setText(projet.getEtat().getLabel());
        state.setTextColor(Color.parseColor(projet.getEtat().getStyle()));
        Picasso.get().load(projet.getPhoto()).into(image);

        return convertView;
    }

}
