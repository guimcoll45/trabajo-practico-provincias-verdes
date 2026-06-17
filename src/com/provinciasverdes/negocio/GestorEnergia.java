package com.provinciasverdes.negocio;

import com.provinciasverdes.modelo.RegistroEnergia;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de la lógica de negocio relacionada con la energía y cálculos
 */
public class GestorEnergia {

    // Simulamos la lista de registros (luego se conecta a la BD)
    private List<RegistroEnergia> listaRegistros = new ArrayList<>();

    // ✅ MÉTODO PARA MOSTRAR EL BALANCE DE UN REGISTRO
    public void mostrarBalance(RegistroEnergia registro) {
        if (registro != null) {
            System.out.println("\n📊 ===== CÁLCULO DE BALANCE ENERGÉTICO =====");
            System.out.println("🔌 Energía Generada: " + registro.getEnergiaGeneradaKwh() + " kWh");
            System.out.println("🔋 Energía Consumida: " + registro.getEnergiaConsumidaKwh() + " kWh");
            System.out.println("📈 Resultado: " + registro.obtenerEstadoBalance());
            System.out.println("===========================================\n");
        } else {
            System.out.println("❌ Error: El registro de energía no es válido.");
        }
    }

    // ✅ MÉTODO PARA CALCULAR BALANCE TOTAL DE UN PERIODO
    public double calcularBalanceTotal() {
        double totalGenerado = 0;
        double totalConsumido = 0;

        for (RegistroEnergia r : listaRegistros) {
            totalGenerado += r.getEnergiaGeneradaKwh();
            totalConsumido += r.getEnergiaConsumidaKwh();
        }
        return totalGenerado - totalConsumido;
    }

    // ✅ MÉTODO PARA AGREGAR UN REGISTRO NUEVO
    public void agregarRegistro(RegistroEnergia registro) {
        listaRegistros.add(registro);
        System.out.println("✅ Registro de energía agregado correctamente.");
    }

    // ✅ MÉTODO PARA BUSCAR POR ID
    public RegistroEnergia buscarRegistroPorId(long id) {
        for (RegistroEnergia r : listaRegistros) {
            if (r.getId() == id) {
                return r;
            }
        }
        return null;
    }

    // ✅ MÉTODO PARA LISTAR TODOS
    public void listarTodosLosRegistros() {
        if (listaRegistros.isEmpty()) {
            System.out.println("📭 No hay registros cargados.");
            return;
        }
        System.out.println("\n📋 LISTA DE REGISTROS:");
        for (RegistroEnergia r : listaRegistros) {
            System.out.println(r);
        }
    }
}