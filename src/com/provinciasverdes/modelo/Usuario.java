package com.provinciasverdes.modelo;

import com.provinciasverdes.enumeraciones.TipoUsuario;
import com.provinciasverdes.enumeraciones.EstadoUsuario;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends EntidadBase {
    // Atributos privados (Encapsulamiento)
    private String nombre;
    private String email;
    private String clave;
    private TipoUsuario tipo;
    private EstadoUsuario estado;
    
    // Relación: Un Usuario tiene muchas Ubicaciones (1..*)
    private List<Ubicacion> ubicaciones;

    // Constructores
    public Usuario() {
        super();
        this.ubicaciones = new ArrayList<>();
    }

    public Usuario(int id, String nombre, String email, String clave, TipoUsuario tipo, EstadoUsuario estado) {
        super(id);
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.tipo = tipo;
        this.estado = estado;
        this.ubicaciones = new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getClave() { return clave; }
    public void setClave(String clave) { this.clave = clave; }
    public TipoUsuario getTipo() { return tipo; }
    public void setTipo(TipoUsuario tipo) { this.tipo = tipo; }
    public EstadoUsuario getEstado() { return estado; }
    public void setEstado(EstadoUsuario estado) { this.estado = estado; }
    public List<Ubicacion> getUbicaciones() { return ubicaciones; }

    // Métodos propios de la lógica
    public void cambiarClave(String nuevaClave) {
        if (nuevaClave != null && nuevaClave.length() >= 4) {
            this.clave = nuevaClave;
            System.out.println("✅ Contraseña actualizada correctamente.");
        } else {
            System.out.println("❌ La contraseña debe tener al menos 4 caracteres.");
        }
    }

    public void activar() {
        this.estado = EstadoUsuario.ACTIVO;
    }

    public void desactivar() {
        this.estado = EstadoUsuario.INACTIVO;
    }

    // Polimorfismo: Redefinición del método abstracto
    @Override
    public void mostrarDatos() {
        System.out.println("════════════ DATOS USUARIO ════════════");
        System.out.println("ID: " + getId());
        System.out.println("Nombre: " + nombre);
        System.out.println("Email: " + email);
        System.out.println("Perfil: " + tipo);
        System.out.println("Estado: " + estado);
        System.out.println("───────────────────────────────────────");
    }
}
