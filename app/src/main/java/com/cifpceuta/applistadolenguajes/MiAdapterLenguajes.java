package com.cifpceuta.applistadolenguajes;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MiAdapterLenguajes extends ArrayAdapter<Lenguaje> {
    private Activity context;
    private ArrayList<Lenguaje> lenguajes;

    public MiAdapterLenguajes(Activity context, ArrayList<Lenguaje> lenguajes) {
        super(context,R.layout.lenguaje_item, lenguajes);
        this.context=context;
        this.lenguajes=lenguajes;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.lenguaje_item, parent,false);

        Lenguaje lenguaje = lenguajes.get(position);

        TextView nombre;
        ImageButton iconoBorrar;

        nombre = rowView.findViewById(R.id.tv_lenguaje_lista);
        iconoBorrar = rowView.findViewById(R.id.ib_delete_lenguaje);

        nombre.setText(lenguaje.getNombre());
        iconoBorrar.setImageResource(lenguaje.getImagenBorrar());

        iconoBorrar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                removeLenguaje(v,position);
                return false;
            }
        });

        return rowView;
    }
    public void removeLenguaje(View v, int pos){
        lenguajes.remove(pos);
        notifyDataSetChanged();
    }
}
