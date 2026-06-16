package com.provinciasverdes.modelo;

import com.provinciasverdes.enumeraciones.TipoReporte;
import java.util.Date;
import java.util.List;

public class Reporte extends EntidadBase {
    private TipoReporte tipoRep;
    private String contenido;
    private Date fechaGen;
    private List<RegistroEnergia> registrosBase; // Datos usados para generarlo

    public Reporte() {
        super();
    }

    public Reporte(int id, TipoReporte tipoRep, Date fechaGen, List<RegistroEnergia> registrosBase) {
        super(id);
        this.tipoRep = tipoRep;
        this.fechaGen = fechaGen;
        this.registrosBase = registrosBase;
        generarContenido(); // Genera automáticamente al crear
    }

    // Getters y Setters
    public TipoReporte getTipoRep() { return tipoRep; }
    public void setTipoRep(TipoReporte tipoRep) { this.tipoRep = tipoRep; }
    public String getContenido() { return contenido; }
    public Date getFechaGen() { return fechaGen; }

    // Lógica para armar el reporte
    private void generarContenido() {
        double totalGen = 0, totalCon = 0;
        for(RegistroEnergia r : registrosBase) {
            totalGen += r.getEnergiaGen();
            totalCon += r.getEnergiaCon();
        }
        double balanceTotal = totalGen - totalCon;
        this.contenido = String.format(
            "Reporte %s | Total Generado: %.2f kWh | Total Consumido: %.2f kWh | Balance: %.2f kWh",
            tipoRep, totalGen, totalCon, balanceTotal
        );
    }

    public void exportarPDF() {
        System.out.println("📄 Exportando reporte " + tipoRep + " a PDF... [Simulado]");
    }

    public String mostrarResumen() {
        return "Reporte " + tipoRep + " generado el: " + fechaGen;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("📈 " + mostrarResumen());
        System.out.println("Detalle: " + contenido);
        System.out.println("──────────────────────────");
    }
}
