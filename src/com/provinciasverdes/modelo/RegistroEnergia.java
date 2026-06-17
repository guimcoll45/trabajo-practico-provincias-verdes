package com.provinciasverdes.modelo;

import java.time.LocalDateTime;

/**
 * Clase que representa el registro de mediciones de energía en un momento dado
 */
public class RegistroEnergia extends EntidadBase {

    private LocalDateTime fechaHora;
    private double energiaGeneradaKwh;
    private double energiaConsumidaKwh;
    private double voltaje;
    private double corriente;
    private EquipoSolar equipoAsociado;

    // Constructor vacío
    public RegistroEnergia() {
    }

    // Constructor con parámetros
    public RegistroEnergia(LocalDateTime fechaHora, double energiaGeneradaKwh, double energiaConsumidaKwh, 
                           double voltaje, double corriente, EquipoSolar equipoAsociado) {
        this.fechaHora = fechaHora;
        this.energiaGeneradaKwh = energiaGeneradaKwh;
        this.energiaConsumidaKwh = energiaConsumidaKwh;
        this.voltaje = voltaje;
        this.corriente = corriente;
        this.equipoAsociado = equipoAsociado;
    }

    // Getters y Setters
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getEnergiaGeneradaKwh() {
        return energiaGeneradaKwh;
    }

    public void setEnergiaGeneradaKwh(double energiaGeneradaKwh) {
        this.energiaGeneradaKwh = energiaGeneradaKwh;
    }

    public double getEnergiaConsumidaKwh() {
        return energiaConsumidaKwh;
    }

    public void setEnergiaConsumidaKwh(double energiaConsumidaKwh) {
        this.energiaConsumidaKwh = energiaConsumidaKwh;
    }

    public double getVoltaje() {
        return voltaje;
    }

    public void setVoltaje(double voltaje) {
        this.voltaje = voltaje;
    }

    public double getCorriente() {
        return corriente;
    }

    public void setCorriente(double corriente) {
        this.corriente = corriente;
    }

    public EquipoSolar getEquipoAsociado() {
        return equipoAsociado;
    }

    public void setEquipoAsociado(EquipoSolar equipoAsociado) {
        this.equipoAsociado = equipoAsociado;
    }

    // ✅ MÉTODOS DE CÁLCULO DEL BALANCE (LO QUE AGREGAMOS)
    /**
     * Calcula la diferencia entre lo generado y lo consumido
     * @return valor positivo = excedente, negativo = déficit
     */
    public double calcularBalanceEnergetico() {
        return this.energiaGeneradaKwh - this.energiaConsumidaKwh;
    }

    /**
     * Devuelve un mensaje descriptivo del estado del balance
     */
    public String obtenerEstadoBalance() {
        double balance = calcularBalanceEnergetico();
        if (balance > 0) {
            return "✅ EXCEDENTE: Se generó " + String.format("%.2f", balance) + " kWh más de lo consumido.";
        } else if (balance < 0) {
            return "⚠️ DÉFICIT: Faltaron " + String.format("%.2f", Math.abs(balance)) + " kWh (se usó energía de red/batería).";
        } else {
            return "⚖️ EQUILIBRIO: Generación y consumo son iguales.";
        }
    }

    @Override
    public String toString() {
        return "RegistroEnergia{" +
                "id=" + getId() +
                ", fechaHora=" + fechaHora +
                ", generado=" + energiaGeneradaKwh + " kWh" +
                ", consumido=" + energiaConsumidaKwh + " kWh" +
                '}';
    }
}