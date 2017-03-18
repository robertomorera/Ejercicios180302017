package com.example.cice.myrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Libro> datos;
    private AdapterLibros adapterLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Libro libro_aux;
        datos=new ArrayList<Libro>(20);
        //Creo libros.
        for(int i=0;i<20;i++){
            libro_aux=new Libro("Autor " +i,"Libro "+i);
            datos.add(libro_aux);
        }

        recyclerView=(RecyclerView)findViewById(R.id.recView);
        adapterLibros=new AdapterLibros(datos);
        recyclerView.setAdapter(adapterLibros);
        //Como se muestran los datos.
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //El número de columnas es el segundo parámetro.
        //GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void anadir(View v){
         Libro libro_nuevo=new Libro("Cholo","Partido a partido");
         datos.add(0,libro_nuevo);
         adapterLibros.notifyItemInserted(0);
    }

    public void eliminar(View v){
         if(datos.size()!=0) {
             datos.remove(0);
             adapterLibros.notifyItemRemoved(0);
         }else{
             Toast.makeText(this, "No hay elementos para borrar", Toast.LENGTH_LONG).show();
         }
    }



}
