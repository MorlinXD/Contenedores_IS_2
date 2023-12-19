package com.example.contenedores_is_2.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.contenedores_is_2.R;
import com.example.contenedores_is_2.modelos.Noticia;

class AdaptadorNoticias extends ArrayAdapter<Noticia> {
    public AdaptadorNoticias(Context context, Noticia[] datos) {
        super(context, R.layout.activity_ly_itemnoticias, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.activity_ly_itemnoticias, null);
        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(getItem(position).getTitulo());
        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(getItem(position).getSubtitulo());
        return(item);
    }
}

