package com.example.cice.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;

/**
 * Created by cice on 18/3/17.
 */

public class AdapterLibros extends RecyclerView.Adapter<LibroViewHolder> {

    private ArrayList<Libro> datos;

    public AdapterLibros(ArrayList<Libro> datos){
        this.datos=datos;
    }

    //Se crea el item cuando lo tengamos que inflar.
    @Override
    public LibroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LibroViewHolder libroViewHolder=null;
        //Obtenemos el contexto del parent (RecyclerView).
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View viewItem=inflater.inflate(R.layout.layout_libro_item,parent,false);
        libroViewHolder=new LibroViewHolder(viewItem);
        return libroViewHolder;
    }

    //Se actualiza la lista(reciclaje de items).
    @Override
    public void onBindViewHolder(LibroViewHolder holder, int position) {
        Libro libro=(Libro)datos.get(position);
        //Asignamos los datos al holder.
        holder.cargarLibroEnHolder(libro);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
