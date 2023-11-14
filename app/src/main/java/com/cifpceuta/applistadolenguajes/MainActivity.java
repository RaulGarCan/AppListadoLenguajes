package com.cifpceuta.applistadolenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private ListView lvLenguajes;
    private Button btnAdd;
    private EditText etNewLenguaje;
    private ArrayList<Lenguaje> listaLenguajes;
    private MiAdapterLenguajes adapterLenguajes;
    private ImageButton ibDeleteElement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLenguajes = findViewById(R.id.lv_lista_lenguajes);
        btnAdd = findViewById(R.id.btn_add_lenguaje);
        etNewLenguaje = findViewById(R.id.et_new_lenguaje);

        listaLenguajes = new ArrayList<>();
        listaLenguajes.add(new Lenguaje("C++", R.drawable.delete_24));
        listaLenguajes.add(new Lenguaje("Python", R.drawable.delete_24));
        adapterLenguajes = new MiAdapterLenguajes(this, listaLenguajes);
        lvLenguajes.setAdapter(adapterLenguajes);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLenguaje(view);
            }
        });
    }
    public void addLenguaje(View v){
        if(!etNewLenguaje.getText().toString().isEmpty()){
            listaLenguajes.add(new Lenguaje(etNewLenguaje.getText().toString(),R.drawable.delete_24));
            ordenarLenguajes();
            adapterLenguajes.notifyDataSetChanged();
        }
    }
    public void ordenarLenguajes(){
        listaLenguajes.sort(new Comparator<Lenguaje>() {
            @Override
            public int compare(Lenguaje o1, Lenguaje o2) {
                return o1.getNombre().compareTo(o2.getNombre());
            }
        });
    }
}