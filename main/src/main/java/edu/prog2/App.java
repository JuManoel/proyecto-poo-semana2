package edu.prog2;

import edu.prog2.helpers.Keyboard;
import edu.prog2.helpers.Utils;

public class App {

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {

        try {
            inicializar();
        } catch (Exception e) {
            e.printStackTrace();
        }

        do {
            try {
                int opcion = leerOpcion();
                switch (opcion) {
                    case 1:
                        // … 
                        break;
                    case 2:
                        // … 
                        break;
                    // … más casos … 
                    // …
                    case 0:
                        salir();
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    private static void inicializar() {
        System.out.print("\033[H\033[2J"); // limpiar la consola
    }

    private static void salir() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
        System.exit(0);
    }
  static int leerOpcion() {
    String opciones =
      String.format("\n%sMenú de opciones:%s\n", Utils.GREEN, Utils.RESET) +
      "  1 - Opción 1               Opción 4\n" +
      "  2 - Opción 2               Opción 5\n" +
      "  3 - Opción 3               Opción 6\n" +
      String.format("  %s0 - Salir%s\n", Utils.RED, Utils.RESET) +
      String.format("\nElija una opción (%s0 para salir%s) > ", Utils.RED, Utils.RESET);

    int opcion = Keyboard.readInt(opciones);
    return opcion;
  }

}