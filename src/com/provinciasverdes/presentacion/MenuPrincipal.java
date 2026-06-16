package com.provinciasverdes.presentacion;

import com.provinciasverdes.modelo.Usuario;
import com.provinciasverdes.enumeraciones.TipoUsuario;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner teclado;
    private Usuario usuarioActivo; // Control de acceso
    private boolean sistemaActivo;

    public MenuPrincipal() {
        this.teclado = new Scanner(System.in);
        this.sistemaActivo = true;
    }

    public void iniciar() {
        System.out.println("=============================================");
        System.out.println("    🟢 SISTEMA PROVINCIAS VERDES 🟢    ");
        System.out.println("=============================================");

        // SIMULACIÓN DE LOGIN (Aquí iría la consulta a BD real)
        this.usuarioActivo = new Usuario(1, "Guillermo Colla", "g@ejemplo.com", "1234", TipoUsuario.ADMIN, null);
        System.out.println("Bienvenido: " + usuarioActivo.getNombre() + " | Perfil: " + usuarioActivo.getTipo());

        // BUCLE PRINCIPAL: Estructura DO-WHILE
        do {
            try {
                mostrarOpciones();
                System.out.print("Ingrese opción: ");
                int opcion = teclado.nextInt();
                teclado.nextLine(); // Limpiar buffer

                procesarOpcion(opcion);

            } catch (InputMismatchException e) {
                // MANEJO DE EXCEPCIONES
                System.out.println("❌ ERROR: Debe ingresar un NÚMERO válido.");
                teclado.nextLine(); // Limpia el dato incorrecto
            } catch (Exception e) {
                System.out.println("⚠️ Error inesperado: " + e.getMessage());
            }

        } while (sistemaActivo);

        System.out.println("👋 Sistema finalizado. Gracias por usar Provincias Verdes.");
    }

    private void mostrarOpciones() {
        System.out.println("\n=============================================");
        System.out.println("            MENÚ PRINCIPAL");
        System.out.println("=============================================");
        System.out.println("1. Gestión de Usuarios");
        System.out.println("2. Gestión de Ubicaciones");
        System.out.println("3. Gestión de Equipos Solares");
        System.out.println("4. Registro de Mediciones");
        System.out.println("5. Reportes y Estadísticas");
        System.out.println("6. Ordenar / Buscar Datos");
        System.out.println("0. Salir");
        System.out.println("---------------------------------------------");
    }

    private void procesarOpcion(int opc) {
        switch (opc) {
            case 1:
                System.out.println("👉 Accediendo a Gestión de Usuarios...");
                break;
            case 2:
                System.out.println("👉 Accediendo a Gestión de Ubicaciones...");
                break;
            case 3:
                System.out.println("👉 Accediendo a Gestión de Equipos...");
                break;
            case 4:
                System.out.println("👉 Cargando nueva medición...");
                break;
            case 5:
                System.out.println("👉 Generando reportes...");
                break;
            case 6:
                System.out.println("👉 Herramientas de búsqueda y orden...");
                break;
            case 0:
                this.sistemaActivo = false;
                break;
            default:
                System.out.println("❌ Opción no válida. Intente nuevamente.");
        }
    }
}
