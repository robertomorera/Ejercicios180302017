package com.example.cice.myrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by cice on 18/3/17.
 */

public class LibroViewHolder extends RecyclerView.ViewHolder {

    private TextView caja_autor;

    private TextView caja_libro;


    public LibroViewHolder(View itemView) {
        super(itemView);
        //TODO setear atributos.
        caja_autor=(TextView)itemView.findViewById(R.id.tvautor);
        caja_libro=(TextView)itemView.findViewById(R.id.tvtitulo);
    }

    public void cargarLibroEnHolder(Libro libro){
        this.caja_libro.setText(libro.getLibro());
        this.caja_autor.setText(libro.getAutor());
    }

}
