package com.provinciasverdes.modelo;

public class Ubicacion extends EntidadBase {
    private String provincia;
    private String direccion;
    private double latitud;
    private double longitud;
    private double altitud;

    // Relación: Una Ubicacion tiene UN EquipoSolar (1:1 - Composición)
    private EquipoSolar equipo;

    public Ubicacion() {
        super();
    }

    public Ubicacion(int id, String provincia, String direccion, double latitud, double longitud, double altitud) {
        super(id);
        this.provincia = provincia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.altitud = altitud;
    }

    // Getters y Setters
    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
    public double getAltitud() { return altitud; }
    public void setAltitud(double altitud) { this.altitud = altitud; }
    public EquipoSolar getEquipo() { return equipo; }
    public void setEquipo(EquipoSolar equipo) { this.equipo = equipo; }

    // Métodos propios
    public String obtenerCoordenadas() {
        return "Lat: " + latitud + " | Lon: " + longitud;
    }

    public double calcularDistancia(Ubicacion otraUbicacion) {
        // Fórmula simplificada de distancia euclidiana
        double dLat = this.latitud - otraUbicacion.getLatitud();
        double dLon = this.longitud - otraUbicacion.getLongitud();
        return Math.sqrt(dLat*dLat + dLon*dLon) * 111; // Aprox a kilómetros
    }

    @Override
    public void mostrarDatos() {
        System.out.println("📍 UBICACIÓN ID: " + getId());
        System.out.println("Provincia: " + provincia);
        System.out.println("Dirección: " + direccion);
        System.out.println("Coordenadas: " + obtenerCoordenadas());
        if (equipo != null) {
            System.out.println("✅ Tiene equipo asociado");
        }
        System.out.println("──────────────────────────");
    }
}
