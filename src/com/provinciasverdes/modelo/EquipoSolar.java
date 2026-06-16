package com.provinciasverdes.modelo;

import com.provinciasverdes.enumeraciones.TipoEquipo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipoSolar extends EntidadBase {
    private TipoEquipo tipo;
    private int cantidad;
    private double potencia; // Potencia por unidad
    private Date fechaInstalacion;

    // Relación: Un Equipo tiene MUCHOS Registros (1..*)
    private List<RegistroEnergia> registros;

    public EquipoSolar() {
        super();
        this.registros = new ArrayList<>();
    }

    public EquipoSolar(int id, TipoEquipo tipo, int cantidad, double potencia, Date fechaInstalacion) {
        super(id);
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.potencia = potencia;
        this.fechaInstalacion = fechaInstalacion;
        this.registros = new ArrayList<>();
    }

    // Getters y Setters
    public TipoEquipo getTipo() { return tipo; }
    public void setTipo(TipoEquipo tipo) { this.tipo = tipo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { 
        if(cantidad > 0) this.cantidad = cantidad; 
    }
    public double getPotencia() { return potencia; }
    public void setPotencia(double potencia) { 
        if(potencia > 0) this.potencia = potencia; 
    }
    public Date getFechaInstalacion() { return fechaInstalacion; }
    public void setFechaInstalacion(Date fechaInstalacion) { this.fechaInstalacion = fechaInstalacion; }
    public List<RegistroEnergia> getRegistros() { return registros; }

    // Método clave de negocio
    public double calcularCapacidadTotal() {
        return this.cantidad * this.potencia; // kWp total
    }

    @Override
    public void mostrarDatos() {
        System.out.println("🔧 EQUIPO SOLAR ID: " + getId());
        System.out.println("Tipo: " + tipo);
        System.out.println("Cantidad: " + cantidad + " u.");
        System.out.println("Potencia unidad: " + potencia + " kW");
        System.out.println("CAPACIDAD TOTAL: " + calcularCapacidadTotal() + " kW");
        System.out.println("Instalado: " + fechaInstalacion);
        System.out.println("──────────────────────────");
    }
}
