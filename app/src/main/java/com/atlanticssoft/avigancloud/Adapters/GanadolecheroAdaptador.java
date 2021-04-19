package com.atlanticssoft.avigancloud.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atlanticssoft.avigancloud.Modelos.Animal;
import com.atlanticssoft.avigancloud.R;

import java.util.ArrayList;

public class GanadolecheroAdaptador extends RecyclerView.Adapter <GanadolecheroAdaptador.GanadoLecheroViewHolder> {

    // Construyo la lista de ganado lechero
    public GanadolecheroAdaptador(ArrayList<Animal> animales, Activity activity)
    {
        this.animales = animales;
        this.activity = activity;
    }

    ArrayList<Animal> animales;
    Activity activity;

    // Infla el layout y lo pasará al viewHolder para que el obtenga los views
    @NonNull
    @Override
    public GanadoLecheroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Le estoy dando vida al cardview_mascota
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_ganadolechero, parent, false);
        return new GanadoLecheroViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GanadoLecheroViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        // Cantidad de elementos que tiene mi lista de animales
        return animales.size();
    }

    public static class GanadoLecheroViewHolder extends  RecyclerView.ViewHolder{

        // Declaro todos los view que tengo en el cardview_ganadolechero.xml
        private TextView tvCodigoCv, tvNombreCv, ;

        public GanadoLecheroViewHolder(View itemView) {
            super(itemView);

            // Enlazo la parte de grafica con la parte logica
            tvNombreCv    = (TextView) itemView.findViewById(R.id.tvNombreCv);
            tvCodigoCv  = (TextView) itemView.findViewById(R.id.tvCodigoCv);

        }
    }
}
