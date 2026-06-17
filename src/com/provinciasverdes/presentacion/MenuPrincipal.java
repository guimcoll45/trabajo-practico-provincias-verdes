import com.provinciasverdes.negocio.GestorUsuario;
import com.provinciasverdes.negocio.GestorEnergia;
import com.provinciasverdes.negocio.GestorReporte;
import com.provinciasverdes.modelo.Usuario;
import com.provinciasverdes.modelo.RegistroEnergia;
import java.util.Scanner;
import java.time.LocalDateTime;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);
    private GestorUsuario gestorUsuario = new GestorUsuario();
    private GestorEnergia gestorEnergia = new GestorEnergia();
    private GestorReporte gestorReporte = new GestorReporte();
    private boolean sesionActiva = true;

    public void iniciar() {
        // SIMULAMOS LOGIN (ya tenés esto)
        if (!login()) {
            System.out.println("❌ Acceso denegado.");
            return;
        }

        int opcion;
        do {
            // MENÚ PRINCIPAL (tal cual lo tenés)
            System.out.println("\n=====================================");
            System.out.println("     🟢 SISTEMA PROVINCIAS VERDES   ");
            System.out.println("=====================================");
            System.out.println("1. Gestión de Usuarios");
            System.out.println("2. Gestión de Ubicaciones");
            System.out.println("3. Gestión de Equipos Solares");
            System.out.println("4. Registro de Mediciones");
            System.out.println("5. Reportes y Estadísticas");
            System.out.println("6. ⚡ CALCULAR BALANCE ENERGÉTICO");
            System.out.println("0. Salir");
            System.out.print("Ingrese opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                // ==============================================
                // 🔹 OPCIÓN 1: GESTIÓN DE USUARIOS (AHORA SÍ FUNCIONA)
                // ==============================================
                case 1:
                    System.out.println("\n📂 Accediendo a Gestión de Usuarios...");
                    int opUsu;
                    do {
                        System.out.println("\n----- SUBMENÚ USUARIOS -----");
                        System.out.println("1. Agregar Usuario");
                        System.out.println("2. Buscar Usuario");
                        System.out.println("3. Modificar Usuario");
                        System.out.println("4. Eliminar / Cambiar Estado");
                        System.out.println("5. Listar Todos");
                        System.out.println("0. Volver al Menú Principal");
                        System.out.print("Elija: ");
                        opUsu = scanner.nextInt();
                        scanner.nextLine();

                        switch (opUsu) {
                            case 1:
                                System.out.println("➕ Nuevo Usuario:");
                                System.out.print("Nombre: ");
                                String nom = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Contraseña: ");
                                String pass = scanner.nextLine();
                                System.out.print("Tipo (1=ADMIN / 2=USUARIO): ");
                                int tipo = scanner.nextInt();
                                // Creamos y guardamos
                                Usuario u = new Usuario();
                                u.setNombre(nom);
                                u.setEmail(email);
                                u.setContrasenaHash(pass);
                                u.setTipo( (tipo==1) ? com.provinciasverdes.enumeraciones.TipoUsuario.ADMIN : com.provinciasverdes.enumeraciones.TipoUsuario.USUARIO );
                                u.setEstado(com.provinciasverdes.enumeraciones.EstadoUsuario.ACTIVO);
                                gestorUsuario.agregarUsuario(u);
                                System.out.println("✅ Usuario agregado.");
                                break;
                            case 2:
                                System.out.print("🔎 Buscar por ID: ");
                                long idBus = scanner.nextLong();
                                Usuario encontrado = gestorUsuario.buscarPorId(idBus);
                                if (encontrado != null) encontrado.mostrarDatos();
                                else System.out.println("❌ No encontrado.");
                                break;
                            case 5:
                                gestorUsuario.listarUsuarios();
                                break;
                            case 0:
                                System.out.println("🔙 Volviendo...");
                                break;
                            default:
                                System.out.println("❌ Opción inválida.");
                        }
                    } while (opUsu != 0);
                    break;

                // ==============================================
                // 🔹 OPCIÓN 4: REGISTRO Y BALANCE
                // ==============================================
                case 4:
                    System.out.println("\n📊 Registro de Nuevas Mediciones...");
                    System.out.print("Energía Generada (kWh): ");
                    double gen = scanner.nextDouble();
                    System.out.print("Energía Consumida (kWh): ");
                    double con = scanner.nextDouble();

                    RegistroEnergia reg = new RegistroEnergia();
                    reg.setFechaHora(LocalDateTime.now());
                    reg.setEnergiaGeneradaKwh(gen);
                    reg.setEnergiaConsumidaKwh(con);

                    gestorEnergia.agregarRegistro(reg);
                    gestorEnergia.mostrarBalance(reg); // <-- CALCULA AUTOMÁTICO
                    break;

                // ==============================================
                // 🔹 OPCIÓN 6: BALANCE (LA QUE AGREGAMOS ANTES)
                // ==============================================
                case 6:
                    System.out.println("\n--- CÁLCULO DE BALANCE ---");
                    System.out.print("Generado: ");
                    double g = scanner.nextDouble();
                    System.out.print("Consumido: ");
                    double c = scanner.nextDouble();
                    RegistroEnergia temp = new RegistroEnergia();
                    temp.setEnergiaGeneradaKwh(g);
                    temp.setEnergiaConsumidaKwh(c);
                    gestorEnergia.mostrarBalance(temp);
                    break;

                // ==============================================
                // 🔹 OTRAS OPCIONES (las dejamos con mensaje por ahora)
                // ==============================================
                case 2:
                    System.out.println("📍 Gestión de Ubicaciones - (Módulo en desarrollo)");
                    break;
                case 3:
                    System.out.println("🔌 Gestión de Equipos Solares - (Módulo en desarrollo)");
                    break;
                case 5:
                    System.out.println("📈 Reportes y Estadísticas - (Módulo en desarrollo)");
                    break;

                case 0:
                    System.out.println("👋 Saliendo del sistema...");
                    sesionActiva = false;
                    break;

                default:
                    System.out.println("❌ Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 0);
    }

    // METODO DE LOGIN (tu código original)
    private boolean login() {
        System.out.println("🔐 INICIO DE SESIÓN");
        System.out.print("Email: ");
        String e = scanner.nextLine();
        System.out.print("Contraseña: ");
        String p = scanner.nextLine();
        // Usuario de prueba que creamos en la BD
        return e.equals("g@ejemplo.com") && p.equals("1234");
    }
}
