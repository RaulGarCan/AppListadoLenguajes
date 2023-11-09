package com.cifpceuta.applistadolenguajes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lvLenguajes;
    private Button btnAdd;
    private EditText etNewLenguaje;
    private ArrayList<String> listaLenguajes;
    private ArrayAdapter<String> adapterLenguajes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLenguajes = findViewById(R.id.lv_lista_lenguajes);
        btnAdd = findViewById(R.id.btn_add_lenguaje);
        etNewLenguaje = findViewById(R.id.et_new_lenguaje);

        listaLenguajes = new ArrayList<>();
        listaLenguajes.add("C++");
        listaLenguajes.add("Python");
        adapterLenguajes = new ArrayAdapter<>(this, R.layout.lenguaje_item,R.id.tv_lenguaje_lista,listaLenguajes);
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
            listaLenguajes.add(etNewLenguaje.getText().toString());
            adapterLenguajes.notifyDataSetChanged();

        }
    }
}