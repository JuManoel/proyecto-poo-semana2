package edu.prog2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
                        double promedioEdad=promediarEdades();
                        System.out.printf("El promedio de edades de los niños es de %.2f\n",promedioEdad);
                        break;
                    case 3:
                        String pasaTiempo=ingresarPasatiempos();
                        System.out.printf("Pasatiempos ingresados: %s\n",pasaTiempo);
                        break;
                    case 4:
                        double siglos=aSiglos();
                        System.out.printf("%.1f siglos\n",siglos);
                        break;
                    case 5:
                        double promedioPeso=promediarPesos();
                        System.out.printf("El promedio de pesos de las personas es de %.2f kilos\n",promedioPeso);
                        break;
                    case 6:
                        probarBoolean();
                        break;
                    case 7:
                        LocalDate date=probarFecha();
                        System.out.printf("Fecha de nascimiento valida: %s\n",date);
                        break;
                    case 8:
                        probarFechaHora();
                        break;
                    case 9:
                        Duration duration=probarDuracion();
                        System.out.printf("Duracion ingresada: %s,\n",duration);
                        break;
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
      "  1 - Serie de un rango              6 - Opciones de falso o verdadero\n" +
      "  2 - Promediar edades               7 - Ingreso de fechas\n" +
      "  3 - Ingresar pasatiempos           8 - Ingreso de fecha y hora\n" +
      "  4 - Convertir a siglos             9 - Ingreso de duración\n"+
      "  5 - Promediar pesos               10 - ...\n"+
      String.format("  %s0 - Salir%s\n", Utils.RED, Utils.RESET) +
      String.format("\nElija una opción (%s0 para salir%s) > ", Utils.RED, Utils.RESET);

    int opcion = Keyboard.readInt(0,10,opciones);
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
        mensage="Edad (Entre 5 y 10, 0 termina): ";
        mensage=String.format("%s%s%s", Utils.BLUE, mensage, Utils.RESET);
        edad=Keyboard.readInt(5, 10,0, mensage);
        soma+=edad;
        cont+=edad!=0?1:0;
    } while (edad!=0);
    promedio=soma/cont;
    return promedio;
  }



  static String ingresarPasatiempos(){
    String mensaje=String.format("%s Pasatiempos preferidos (entre 10 y 100 caracteres): %s",Utils.BLUE,Utils.RESET);
    mensaje+=String.format(" %s(pulsa intro para no ingresar datos)%s",Utils.GREEN,Utils.RESET);
    String pasaTiempo=Keyboard.readString(10, 100, mensaje);
    return pasaTiempo;
  }

  static double aSiglos(){
    String mensaje="Años (40000-999999, 0 termina): ";
    long anio=Keyboard.readLong(40000, 999999, 0, mensaje);
    double siglos=anio/100.0;
    System.out.printf("%d años equivalen a ",anio);
    return siglos;
  }

  static double promediarPesos(){
    double promedio=0.0;
    String mensaje=String.format("%sPeso(Entre 10.0 y 150.0, 0 termina): %s",Utils.BLUE,Utils.RESET);
    double peso=0.0;
    int cont=1;
    do {
        peso=Keyboard.readLong(10.0, 150.0, 0, mensaje);
        promedio+=peso;
        cont+=peso!=0?1:0;
    } while (peso!=0);
    promedio/=cont;
    return promedio;
  }

    private static void probarBoolean() {
        boolean ok = Keyboard.readBoolean("Indique si funciona o no: ");
        System.out.printf("Funciona: %s", ok ? "SI" : "NO");
        System.out.println();
    }

    private static LocalDate probarFecha(){
        LocalDate datahoy=LocalDate.now();
        System.out.printf("Fecha Actual: %s\n",datahoy);
        int anio=datahoy.getYear();
        int aniofrom=anio-40;
        int anioto=anio-18;
        String dataFrom=String.format("%d-01-01",aniofrom);
        String dataTo=String.format("%d-12-31",anioto);
        System.out.printf("Se aceptan nacidos entre %s y %s\n",dataFrom,dataTo);
        return Keyboard.readDate(dataFrom, dataTo, "Fecha de nascimiento (AAAA-MM-DD): ");
    }

    public static void probarFechaHora() {
        String mensaje="Fecha y hora de ingreso: ";
        LocalDateTime date=Keyboard.readDateTime(mensaje);
        System.out.printf("Fecha y hora: %s\n",date);
        mensaje="Nueva fecha y hora de ingreso: ";
        date=Keyboard.readDateTime(mensaje);
        System.out.println("Rango para el seguiente ingreso: 2000-01-01 00:00 - 2022-12-31 23:59");
        LocalDateTime datefrom=LocalDateTime.parse("2000-01-01T00:00");
        LocalDateTime dateto=LocalDateTime.parse("2022-12-31T23:59");
        mensaje="Ingreso (AAAA-MM-DD HH:MM): ";
        date=Keyboard.readDateTime(datefrom, dateto, mensaje);
        System.out.printf("Fecha y hora: %s\n",date);
        System.out.printf("Fecha y hora para humanos: %s\n",Utils.strDateTime(date));
    }

    public static Duration probarDuracion(){
        System.out.println("Se espera duracion entre 1:00 y 20:00 horas");
        Duration duracion=Keyboard.readDuration("1:00", "20:00", "Ingrese la Duracion (HH:MM): ");
        return duracion;
    }

}