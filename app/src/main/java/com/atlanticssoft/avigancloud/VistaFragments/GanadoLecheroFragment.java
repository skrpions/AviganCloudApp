package com.atlanticssoft.avigancloud.VistaFragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atlanticssoft.avigancloud.Adapters.GanadolecheroAdaptador;
import com.atlanticssoft.avigancloud.Modelos.Animal;
import com.atlanticssoft.avigancloud.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GanadoLecheroFragment extends Fragment implements IGanadoLecheroFragment {

    private RecyclerView recyclerv_ganadolechero;
    private ArrayList<Animal> animales;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Asociamos la clase Fragment java con el respectivo layout xml
        View v = inflater.inflate(R.layout.fragment_ganadolechero,container,false);

        // Programo el botón el Floating
        FloatingActionButton myfab = v.findViewById(R.id.fabAddGanadoLechero);
        myfab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), BluetoothActivity.class);
                //startActivity(intent);
            }
        });

        myfab.setColorFilter(Color.WHITE);


        // Enlazo el recyclerview grafico con la lógica
        recyclerv_ganadolechero = (RecyclerView) v.findViewById(R.id.recyclerv_ganadolechero);

        // Enlazo el Presentador
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        // Ahora el codigo será en terminos de recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()); // Organizo todas las tarjetas una seguida de otra
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // Orientación en la que mostraré mi lista
        recyclerv_ganadolechero.setLayoutManager(linearLayoutManager);
    }

    @Override
    public GanadolecheroAdaptador crearAdaptador(ArrayList<Animal> mascotas) {
        GanadolecheroAdaptador adaptador = new GanadolecheroAdaptador (animales,getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(GanadolecheroAdaptador adaptador) {
        recyclerv_ganadolechero.setAdapter(adaptador);
    }
}
