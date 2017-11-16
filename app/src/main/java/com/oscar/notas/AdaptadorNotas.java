package com.oscar.notas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.oscar.notas.BaseDatos.Notas;

import java.util.List;

/**
 * Created by oemy9 on 11/11/2017.
 */

public class AdaptadorNotas extends BaseAdapter {
    private Context ctx;
    private List <Notas> list;

    public AdaptadorNotas(Context ctx, List<Notas> list) {
        this.ctx = ctx;
        this.list = list;
    }

    public AdaptadorNotas(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Notas getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater Inflater=LayoutInflater.from(ctx);
           convertView=Inflater.inflate(R.layout.item_nota,parent,false);

        TextView tvTitulo=(TextView)convertView.findViewById(R.id.tvTitulo);

        TextView tvDescripcion=(TextView)convertView.findViewById(R.id.tvDescripcion);
        Notas n=getItem(position);
        tvTitulo.setText(n.getTitulo());
        tvDescripcion.setText(n.getDescripcion());
        return convertView;

    }
}



















