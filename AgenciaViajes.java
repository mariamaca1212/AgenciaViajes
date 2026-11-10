package AgenciaDeViajes;

import java.util.Scanner;

public class AgenciaViajes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        final String RESET = "\033[0m";
        final String CYAN = "\033[36m";
        final String VERDE = "\033[32m";
        final String AMARILLO = "\033[33m";
        final String ROJO = "\033[31m";
        final String AZUL = "\033[34m";
        final String NEGRITA = "\033[1m";

        // Variables para almacenar los gastos de cada uno de los 5 viajeros (-1 indica que no existe)
        float gastoV1 = -1;
        float gastoV2 = -1;
        float gastoV3 = -1;
        float gastoV4 = -1;
        float gastoV5 = -1;

        // Variables para los saldos finales (positivo = recibe dinero, negativo = debe pagar)
        float saldoV1 = 0;
        float saldoV2 = 0;
        float saldoV3 = 0;
        float saldoV4 = 0;
        float saldoV5 = 0;

        // boolean para controlar el orden obligatorio de ejecución del programa
        boolean datosIntroducidos = false;
        boolean repartoCalculado = false;

        // Variable para almacenar la opción seleccionada en el menú
        int opcion;

        // Bucle do-while para mantener el menú abierto hasta que el usuario decida salir
        do {
            System.out.println("\n" + CYAN + NEGRITA + "========================================" + RESET);
            System.out.println(CYAN + NEGRITA + "       ✈️ GESTIÓN DE GASTOS DE VIAJE 🌍       " + RESET);
            System.out.println(CYAN + NEGRITA + "========================================" + RESET);
            System.out.println("1. 📝 Introducir gastos de los viajeros");
            System.out.println("2. 🧮 Calcular reparto de gastos");
            System.out.println("3. 📊 Mostrar el reparto entre los viajeros");
            System.out.println("4. 🚪 Salir");
            System.out.println(CYAN + "----------------------------------------" + RESET);
            System.out.print(AMARILLO + "👉 Seleccione una opción (1-4): " + RESET);

            opcion = s.nextInt();

            // Estructura switch para gestionar las opciones del menú
            switch (opcion) {
                case 1:
                    System.out.println("\n" + AZUL + "--- 📝 INTRODUCCIÓN DE GASTOS ---" + RESET);
                    System.out.println("(💡 Introduce -1 si el viajero no existe)");

                    System.out.print("👤 Gasto del Viajero 1: ");
                    gastoV1 = s.nextFloat();

                    System.out.print("👤 Gasto del Viajero 2: ");
                    gastoV2 = s.nextFloat();

                    System.out.print("👤 Gasto del Viajero 3: ");
                    gastoV3 = s.nextFloat();

                    System.out.print("👤 Gasto del Viajero 4: ");
                    gastoV4 = s.nextFloat();

                    System.out.print("👤 Gasto del Viajero 5: ");
                    gastoV5 = s.nextFloat();

                    // Validar cuántos viajeros son válidos (distintos de -1)
                    int totalViajerosValidos = 0;
                    if (gastoV1 != -1) totalViajerosValidos++;
                    if (gastoV2 != -1) totalViajerosValidos++;
                    if (gastoV3 != -1) totalViajerosValidos++;
                    if (gastoV4 != -1) totalViajerosValidos++;
                    if (gastoV5 != -1) totalViajerosValidos++;

                    // Comprobación de que al menos hay un viajero válido registrado
                    if (totalViajerosValidos == 0) {
                        System.out.println("\n" + ROJO + "❌ [ERROR] Debes introducir al menos un viajero válido (distinto de -1)." + RESET);
                        datosIntroducidos = false;
                    } else {
                        datosIntroducidos = true;
                        repartoCalculado = false; // Si se modifican los datos, hay que recalcular obligatoriamente
                        System.out.println("\n" + VERDE + "✅ [OK] Gastos registrados correctamente." + RESET);
                    }
                    break;

                case 2:
                    // Validación de orden: no se puede calcular sin haber introducido datos antes
                    if (!datosIntroducidos) {
                        System.out.println("\n" + ROJO + "❌ [ERROR] Primero debes ejecutar la Opción 1 (Introducir gastos)." + RESET);
                    } else {
                        float sumaTotal = 0;
                        int numViajeros = 0;

                        // Sumamos los gastos y contamos los viajeros activos
                        if (gastoV1 != -1) { sumaTotal += gastoV1; numViajeros++; }
                        if (gastoV2 != -1) { sumaTotal += gastoV2; numViajeros++; }
                        if (gastoV3 != -1) { sumaTotal += gastoV3; numViajeros++; }
                        if (gastoV4 != -1) { sumaTotal += gastoV4; numViajeros++; }
                        if (gastoV5 != -1) { sumaTotal += gastoV5; numViajeros++; }

                        // Calculamos cuánto le toca pagar a cada uno en total
                        float cuotaPorPersona = sumaTotal / numViajeros;

                        // Calculamos la diferencia individual (gasto personal menos la cuota equitativa)
                        if (gastoV1 != -1) saldoV1 = gastoV1 - cuotaPorPersona;
                        if (gastoV2 != -1) saldoV2 = gastoV2 - cuotaPorPersona;
                        if (gastoV3 != -1) saldoV3 = gastoV3 - cuotaPorPersona;
                        if (gastoV4 != -1) saldoV4 = gastoV4 - cuotaPorPersona;
                        if (gastoV5 != -1) saldoV5 = gastoV5 - cuotaPorPersona;

                        repartoCalculado = true;
                        System.out.println("\n" + VERDE + "✅ [OK] Reparto calculado correctamente." + RESET);
                        System.out.printf("💰 Gasto total del viaje: %.2f €\n", sumaTotal);
                        System.out.printf("⚖️ Cuota individual (%d viajeros): %.2f € por persona\n", numViajeros, cuotaPorPersona);
                    }
                    break;

                case 3:
                    // Validación de orden: exige haber pasado por la opción 1 y la 2
                    if (!datosIntroducidos) {
                        System.out.println("\n" + ROJO + "❌ [ERROR] Primero debes ejecutar la Opción 1 (Introducir gastos)." + RESET);
                    } else if (!repartoCalculado) {
                        System.out.println("\n" + ROJO + "❌ [ERROR] Primero debes ejecutar la Opción 2 (Calcular reparto)." + RESET);
                    } else {
                        System.out.println("\n" + AZUL + NEGRITA + "--- 📊 RESULTADO DEL REPARTO ---" + RESET);

                        // Mostramos el estado financiero de cada viajero activo
                        if (gastoV1 != -1) {
                            if (saldoV1 > 0) {
                                System.out.printf("👤 Viajero 1: Debe " + VERDE + "RECIBIR %.2f €\n" + RESET, saldoV1);
                            } else if (saldoV1 < 0) {
                                System.out.printf("👤 Viajero 1: Debe " + ROJO + "PAGAR %.2f €\n" + RESET, -saldoV1);
                            } else {
                                System.out.println("👤 Viajero 1: Está al día (no paga ni recibe).");
                            }
                        }

                        if (gastoV2 != -1) {
                            if (saldoV2 > 0) {
                                System.out.printf("👤 Viajero 2: Debe " + VERDE + "RECIBIR %.2f €\n" + RESET, saldoV2);
                            } else if (saldoV2 < 0) {
                                System.out.printf("👤 Viajero 2: Debe " + ROJO + "PAGAR %.2f €\n" + RESET, -saldoV2);
                            } else {
                                System.out.println("👤 Viajero 2: Está al día (no paga ni recibe).");
                            }
                        }

                        if (gastoV3 != -1) {
                            if (saldoV3 > 0) {
                                System.out.printf("👤 Viajero 3: Debe " + VERDE + "RECIBIR %.2f €\n" + RESET, saldoV3);
                            } else if (saldoV3 < 0) {
                                System.out.printf("👤 Viajero 3: Debe " + ROJO + "PAGAR %.2f €\n" + RESET, -saldoV3);
                            } else {
                                System.out.println("👤 Viajero 3: Está al día (no paga ni recibe).");
                            }
                        }

                        if (gastoV4 != -1) {
                            if (saldoV4 > 0) {
                                System.out.printf("👤 Viajero 4: Debe " + VERDE + "RECIBIR %.2f €\n" + RESET, saldoV4);
                            } else if (saldoV4 < 0) {
                                System.out.printf("👤 Viajero 4: Debe " + ROJO + "PAGAR %.2f €\n" + RESET, -saldoV4);
                            } else {
                                System.out.println("👤 Viajero 4: Está al día (no paga ni recibe).");
                            }
                        }

                        if (gastoV5 != -1) {
                            if (saldoV5 > 0) {
                                System.out.printf("👤 Viajero 5: Debe " + VERDE + "RECIBIR %.2f €\n" + RESET, saldoV5);
                            } else if (saldoV5 < 0) {
                                System.out.printf("👤 Viajero 5: Debe " + ROJO + "PAGAR %.2f €\n" + RESET, -saldoV5);
                            } else {
                                System.out.println("👤 Viajero 5: Está al día (no paga ni recibe).");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n" + AMARILLO + "👋 ¡Gracias por utilizar la aplicación! Saliendo..." + RESET);
                    break;

                default:
                    System.out.println("\n" + ROJO + "❌ [ERROR] Opción no válida. Introduce un número del 1 al 4." + RESET);
                    break;
            }

        } while (opcion != 4);
    }
}