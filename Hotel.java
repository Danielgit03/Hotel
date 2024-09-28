// Reservacion de un hotel 
import java.util.Scanner;


public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Número total de habitaciones
        int totalHabitaciones = 5;
        
        // Crear un array para cada habitación donde amacena nombre,noches reservadas, precio por noche y disponibilidad de la habitacion
        String[] clientes = new String[totalHabitaciones];
        int[] nochesReservadas = new int[totalHabitaciones];
        double[] precioPorNoche = new double[totalHabitaciones];
        boolean[] habitacionOcupada = new boolean[totalHabitaciones];
        
        // Inicializar el array
        for (int i = 0; i < totalHabitaciones; i++) {
            clientes[i] = "Vacío"; // Nombre de los clientes
            nochesReservadas[i] = 0; // Noches reservadas
            precioPorNoche[i] = 0.0; // Precio por noche
            habitacionOcupada[i] = false; // Indica si la habitación está ocupada (true) o disponible (false).
        }

        int opcion;
        // Usamos el ciclo do while para que se repita al menos una vez hasta de la opcion sea = 4 y salgamos del programa
        do {
            System.out.println("BIENVENIDO AL HOTEL ");
            System.out.println("------------------------------");
            System.out.println("Sistema de Gestión de Reservas del Hotel");
            System.out.println("1. Reservar habitación");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Habitaciones disponibles y facturacion");
            System.out.println("4. Salir");
System.out.println("");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            
            
            switch (opcion) {
                case 1:
                    // Reservar habitacion
                    System.out.print("Ingrese el número de la habitación (1 a " + totalHabitaciones + "): ");// Se pide al usuario que ingrese el número de la habitación que desea reservar. Se resta 1 para convertirlo a un índice de array (porque los arrays empiezan en 0).
                    int numeroHabitacion = scanner.nextInt() - 1; 
                    
                    if (numeroHabitacion >= 0 && numeroHabitacion < totalHabitaciones) {
                        if (!habitacionOcupada[numeroHabitacion]) {  // habitaciones disponibles
                            scanner.nextLine(); 
                            System.out.print("Ingrese el nombre del cliente: ");
                            clientes[numeroHabitacion] = scanner.nextLine();
                            System.out.print("Ingrese el número de noches: ");
                            nochesReservadas[numeroHabitacion] = scanner.nextInt();
                            System.out.print("Ingrese el precio por noche: ");
                            precioPorNoche[numeroHabitacion] = scanner.nextDouble();
                            
                            // Marcar la habitación como ocupada
                            habitacionOcupada[numeroHabitacion] = true;
                            
                            System.out.println("Reserva realizada con éxito.");

                            
                        } else {
                            System.out.println("La habitación ya está ocupada.");
                        }
                    } else {
                        System.out.println("");
                        System.out.println("Número de habitación inválido.");
                    }
                    break;

                case 2:
                    // Cancelar reserva
                    System.out.print("Ingrese el número de la habitación a cancelar (1 a " + totalHabitaciones + "): ");
                    numeroHabitacion = scanner.nextInt() - 1; // Convertir el índice del Arrays
                    
                    if (numeroHabitacion >= 0 && numeroHabitacion < totalHabitaciones) {

                        if (habitacionOcupada[numeroHabitacion]) {
                            // Cancelar la reservacion
                            clientes[numeroHabitacion] = "Vacío"; //el nombre del cliente esa vacio
                            // se restauran los valores a 0 como si pideiera la habitacion normalmente
                            nochesReservadas[numeroHabitacion] = 0;
                            precioPorNoche[numeroHabitacion] = 0.0;
                            habitacionOcupada[numeroHabitacion] = false;
                            // 
                            System.out.println("Reserva cancelada con éxito.");
                            System.out.println("");
                        } else {
                            System.out.println("La habitación ya está disponible.");
                            System.out.println("");
                        }
                    } else {
                        System.out.println("Número de habitación inválido.");
                        System.out.println("");
                    }
                    break;

                case 3:
                    // Generar reporte de las habitaciones disponibles y el recibo de los clientes del total a pagar
                    int habitacionesOcupadas = 0;
                    System.out.println("--- Reporte de habitaciones disponibles ---");
                    
                    for (int i = 0; i < totalHabitaciones; i++) {
                        
                        if (habitacionOcupada[i]) {
                            // Mostrar detalles de las habitaciones ocupadas y los clientes 
                            System.out.println("Habitación " + (i + 1) + " ocupada por: " + clientes[i]); // se le suma a i + 1 para que el array cuadre con el numero de habitaciones
                            System.out.println("Noches reservadas: " + nochesReservadas[i]);
                            System.out.println("Precio por noche: $" + precioPorNoche[i]);
                            double total = nochesReservadas[i] * precioPorNoche[i];
                            System.out.println("Total a pagar: $" + total);
                            habitacionesOcupadas++; // este mas es para que se repita el ciclo de las 5 habitaciones
                        } else {
                            System.out.println("Habitación " + (i + 1) + " disponible.");
                        }
                    }
                    
                    System.out.println("Total habitaciones ocupadas: " + habitacionesOcupadas);
                    System.out.println("Total habitaciones disponibles: " + (totalHabitaciones - habitacionesOcupadas));
                    break;

                case 4:
                    // Salir del sistema
                    System.out.println("Saliendo del sistema...");
                    opcion =4;
                    scanner.close();
                    break;

                default:
                    // Opción inválida
                    System.out.println("Opción no válida, por favor intente nuevamente.");
                    break;
            }
            
        } while (opcion !=4);
    }


}
