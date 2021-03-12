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
import com.example.examenguerrero.Models.articulos;
import com.example.examenguerrero.Models.revistas;
import com.example.examenguerrero.R;

import java.util.ArrayList;

public class AdapterArticulos extends ArrayAdapter<articulos> {
    public AdapterArticulos(Context context, ArrayList<articulos> datos){
        super(context, R.layout.ly_items_articulos,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.ly_items_articulos,null);

        TextView lbltitulo = (TextView)item.findViewById(R.id.lblnamearticulo);
        TextView lbldescription = (TextView)item.findViewById(R.id.lblsection);

        lbltitulo.setText(getItem(position).getTituloart());
        lbldescription.setText(Html.fromHtml(getItem(position).getSection()));

        return item;
    }
}
