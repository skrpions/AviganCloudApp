package com.atlanticssoft.avigancloud.VistaFragments;

import com.atlanticssoft.avigancloud.Adapters.GanadolecheroAdaptador;
import com.atlanticssoft.avigancloud.Modelos.Animal;

import java.util.ArrayList;

public interface IGanadoLecheroFragment {

    // En esta Interfaz irán todos los métodos del GanadoLecheroFragment que no interactuán directamente con la interfaz de usuario,
    // es decir, aquellos métodos que son independientes del fragment_ganadolechero.xml.
    // Esto con el fin de implementar el patrón de diseño (MVP)

    public void generarLinearLayoutVertical();

    public GanadolecheroAdaptador crearAdaptador (ArrayList<Animal> mascotas);

    public void inicializarAdaptadorRV (GanadolecheroAdaptador adaptador);

}
