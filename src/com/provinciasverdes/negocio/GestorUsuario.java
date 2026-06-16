package com.provinciasverdes.negocio;

import com.provinciasverdes.modelo.Usuario;
import com.provinciasverdes.enumeraciones.TipoUsuario;
import com.provinciasverdes.enumeraciones.EstadoUsuario;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuario {
    // Simulamos la base de datos con una lista en memoria
    private List<Usuario> listaUsuarios;

    public GestorUsuario() {
        this.listaUsuarios = new ArrayList<>();
        // Cargamos un usuario de prueba
        listaUsuarios.add(new Usuario(1, "Guillermo Colla", "g@ejemplo.com", "1234", TipoUsuario.ADMIN, EstadoUsuario.ACTIVO));
    }

    // Método para validar inicio de sesión
    public Usuario validarAcceso(String email, String clave) {
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getClave().equals(clave) && u.getEstado() == EstadoUsuario.ACTIVO) {
                return u;
            }
        }
        return null;
    }

    // Agregar nuevo usuario
    public boolean agregarUsuario(Usuario nuevo) {
        // Validación de email único
        for (Usuario u : listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(nuevo.getEmail())) {
                return false; // Ya existe
            }
        }
        listaUsuarios.add(nuevo);
        return true;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
}
