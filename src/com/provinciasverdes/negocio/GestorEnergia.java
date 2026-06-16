package com.provinciasverdes.negocio;

import com.provinciasverdes.modelo.Ubicacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorEnergia {

    // ALGORITMO DE ORDENACIÓN: Ordenar por Provincia
    public void ordenarUbicacionesPorProvincia(List<Ubicacion> lista) {
        // Usamos Collections.sort + Comparator (tal como lo diseñamos)
        Collections.sort(lista, new Comparator<Ubicacion>() {
            @Override
            public int compare(Ubicacion u1, Ubicacion u2) {
                return u1.getProvincia().compareToIgnoreCase(u2.getProvincia());
            }
        });
        // Versión Lambda Java 8+: Collections.sort(lista, (u1,u2) -> u1.getProvincia().compareTo...);
    }

    // ALGORITMO DE BÚSQUEDA: Búsqueda Lineal
    public List<Ubicacion> buscarUbicacionPorProvincia(String texto, List<Ubicacion> lista) {
        List<Ubicacion> resultados = new ArrayList<>();
        for (Ubicacion ubi : lista) {
            // Contiene el texto (búsqueda parcial)
            if (ubi.getProvincia().toLowerCase().contains(texto.toLowerCase())) {
                resultados.add(ubi);
            }
        }
        return resultados;
    }
}
