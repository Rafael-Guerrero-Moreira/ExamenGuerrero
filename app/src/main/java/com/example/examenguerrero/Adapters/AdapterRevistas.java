package com.example.examenguerrero.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examenguerrero.Models.revistas;
import com.example.examenguerrero.R;

import java.util.ArrayList;

public class AdapterRevistas extends ArrayAdapter<revistas>{
    public AdapterRevistas(Context context, ArrayList<revistas> datos){
        super(context, R.layout.ly_items_revistas,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_items_revistas,null);

        TextView lbltitulo = (TextView)item.findViewById(R.id.lblnamerevista);
        TextView lbldescription = (TextView)item.findViewById(R.id.lbldescription);
        ImageView imageView = (ImageView) item.findViewById(R.id.imgRevista);

        Glide.with(this.getContext()).load(getItem(position).getUrlRevista()).into(imageView);

        lbltitulo.setText("Título: "+getItem(position).getName());
        lbldescription.setText("Título: "+getItem(position).getDescription());

        return item;
    }
}
