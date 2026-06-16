package com.provinciasverdes.negocio;

import com.provinciasverdes.modelo.Ubicacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GestorEnergia {

    // ALGORITMO DE ORDENACIÓN: Ordenar por Provincia (Ascendente)
    public void ordenarUbicacionesPorProvincia(List<Ubicacion> lista) {
        // Usamos Collections.sort + Comparator
        Collections.sort(lista, new Comparator<Ubicacion>() {
            @Override
            public int compare(Ubicacion u1, Ubicacion u2) {
                return u1.getProvincia().compareToIgnoreCase(u2.getProvincia());
            }
        });
    }

    // ALGORITMO DE BÚSQUEDA: Búsqueda Lineal por texto
    public List<Ubicacion> buscarUbicacionPorProvincia(String texto, List<Ubicacion> lista) {
        List<Ubicacion> resultados = new ArrayList<>();
        for (Ubicacion ubi : lista) {
            // Contiene el texto (búsqueda parcial, no estricta)
            if (ubi.getProvincia().toLowerCase().contains(texto.toLowerCase())) {
                resultados.add(ubi);
            }
        }
        return resultados;
    }

    // Cálculo de eficiencia
    public double calcularEficiencia(double generado, double capacidadTotal) {
        if (capacidadTotal <= 0) return 0;
        return (generado / capacidadTotal) * 100;
    }
}
