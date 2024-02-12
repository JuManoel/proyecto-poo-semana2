package edu.prog2;

import java.util.Locale;

import main.java.edu.prog2.helpers.Keyboard;
import main.java.edu.prog2.helpers.Utils;

public class App {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("es_CO"));//hace con que sea . ao inves de ,
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
                        serie();
                        break;
                    case 2:
                        double promedio=promediarEdades();
                        System.out.printf("El promedio de edades de los niños es de %.2f\n",promedio);
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
      "  1 - Serie de un rango               Opción 4\n" +
      "  2 - Promediar edades               Opción 5\n" +
      "  3 - Opción 3               Opción 6\n" +
      String.format("  %s0 - Salir%s\n", Utils.RED, Utils.RESET) +
      String.format("\nElija una opción (%s0 para salir%s) > ", Utils.RED, Utils.RESET);

    int opcion = Keyboard.readInt(opciones);
    return opcion;
  }

  static void serie(){
    String mensage="Valor de Inicio: ";
    mensage=String.format("%s%s%s", Utils.BLUE, mensage, Utils.RESET);
    int valorInicio=Keyboard.readInt(mensage);
    mensage="Valor de finalizacion: ";
    mensage=String.format("%s%s%s", Utils.BLUE, mensage, Utils.RESET);
    int valorFinal=Keyboard.readInt(mensage);
    if(valorFinal<valorInicio){
        valorFinal+=valorInicio;
        valorInicio=valorFinal-valorInicio;
        valorFinal-=valorInicio;
    }
    for(int i=valorInicio;i<=valorFinal;i++){
        System.out.printf(" %d", i);
    }
    System.out.println("");
  }


  static double promediarEdades(){
    int edad=0;
    int soma=0;
    int cont=0;
    double promedio;
    String mensage;
    do {
        mensage="Edad (Entre 1 y 5, 0 termina): ";
        mensage=String.format("%s%s%s", Utils.BLUE, mensage, Utils.RESET);
        edad=Keyboard.readInt(0, 5, mensage);
        soma+=edad;
        cont+=edad!=0?1:0;
    } while (edad!=0);
    promedio=soma/cont;
    return promedio;
  }


}