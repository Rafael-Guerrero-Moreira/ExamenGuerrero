package com.example.examenguerrero.Adapters;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.examenguerrero.Models.revistas;
import com.example.examenguerrero.Models.volumenes;
import com.example.examenguerrero.R;

import java.util.ArrayList;

public class AdapterVolumen extends ArrayAdapter<volumenes> {
    public AdapterVolumen(Context context, ArrayList<volumenes> datos){
        super(context, R.layout.ly_items_volumenes,datos);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_items_volumenes,null);

        TextView lblid = (TextView)item.findViewById(R.id.lblidvolumen);
        TextView lbltitulo = (TextView)item.findViewById(R.id.lblnamevol);
        TextView lblfecha = (TextView)item.findViewById(R.id.lblfechapublish);
        ImageView imageView = (ImageView) item.findViewById(R.id.imgvolumen);

        Glide.with(this.getContext()).load(getItem(position).getUrlvolumen()).into(imageView);

        lblid.setText(getItem(position).getIdvol());
        lbltitulo.setText(getItem(position).getTitulo());
        lblfecha.setText(getItem(position).getFecha());

        return item;
    }

}
