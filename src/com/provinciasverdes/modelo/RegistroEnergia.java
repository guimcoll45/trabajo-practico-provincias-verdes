package com.provinciasverdes.modelo;

import java.sql.Timestamp;

public class RegistroEnergia extends EntidadBase {
    private Timestamp fechaHora; // Fecha y hora exacta
    private double energiaGen;   // kWh generados
    private double energiaCon;   // kWh consumidos
    private double voltaje;
    private double corriente;

    public RegistroEnergia() {
        super();
    }

    public RegistroEnergia(int id, Timestamp fechaHora, double energiaGen, double energiaCon, double voltaje, double corriente) {
        super(id);
        this.fechaHora = fechaHora;
        this.energiaGen = energiaGen;
        this.energiaCon = energiaCon;
        this.voltaje = voltaje;
        this.corriente = corriente;
    }

    // Getters y Setters con validación
    public Timestamp getFechaHora() { return fechaHora; }
    public void setFechaHora(Timestamp fechaHora) { this.fechaHora = fechaHora; }
    public double getEnergiaGen() { return energiaGen; }
    public void setEnergiaGen(double energiaGen) { 
        if(energiaGen >= 0) this.energiaGen = energiaGen; 
    }
    public double getEnergiaCon() { return energiaCon; }
    public void setEnergiaCon(double energiaCon) { 
        if(energiaCon >= 0) this.energiaCon = energiaCon; 
    }
    public double getVoltaje() { return voltaje; }
    public void setVoltaje(double voltaje) { this.voltaje = voltaje; }
    public double getCorriente() { return corriente; }
    public void setCorriente(double corriente) { this.corriente = corriente; }

    // Lógica principal: Balance Energético
    public double calcularBalance() {
        return this.energiaGen - this.energiaCon;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("📊 REGISTRO: " + fechaHora);
        System.out.println("Generado: " + energiaGen + " kWh");
        System.out.println("Consumido: " + energiaCon + " kWh");
        System.out.println("BALANCE: " + calcularBalance() + " kWh");
        System.out.println("Voltaje: " + voltaje + " V | Corriente: " + corriente + " A");
        System.out.println("──────────────────────────");
    }
}
