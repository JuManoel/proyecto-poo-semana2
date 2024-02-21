package main.java.edu.prog2.helpers;//Duda para el maestro-> pq en mi caso muestra todo ese package

import java.io.Console;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.EnumSet;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Keyboard {

    private static Console con = System.console();//objeto da clase console, serve para ler strings e SENHAS
    public static Scanner sc = new Scanner(con.reader()).useDelimiter("[\n]+|[\r\n]+");//con.reader y useDelimiter es los mismo que el System.in
    //"[\n]+[\r\n] entiende qualquier salto de linea. enter"

    public static String readString(String message) {
        //lee apenas Strings. muestra una mensage
        System.out.print(message);
        return sc.nextLine();
    }

    public static String readString(int from, int to, String message){
        String entrada;
        boolean ok;
        System.out.println(message);
        do {
            ok=true;
            entrada=sc.nextLine();
            if(entrada.length()<from && entrada.length()>to){
                    System.out.printf("%sEntrada Demasiado Grande%s\n", Utils.RED, Utils.RESET);
                    ok=false;
            }

        } while (!ok);

        return entrada;
    }

    public static int readInt(String message) {
        //leer ints
        boolean ok;//valida si el valor de la entrada es correcto
        int value = Integer.MIN_VALUE;//valor minimo del inteiro
        System.out.print(message);//imprime un mensage
    
        do {
            try {
                ok = true;//la entrada esta bien
                value = sc.nextInt(); //recibe el valor
            } catch (InputMismatchException e) {//caso tenga un error de input
                ok = false;//no esta ok
                System.out.print(">> Valor erróneo. " + message);//muestra que el valor ingresado es malo
            } finally {
                sc.nextLine();//salto de linea
            }
        } while (!ok);//si la entrada es ok. entonce termina el ciclo. si no. repite
    
        return value;//retorna el valor
    }

    public static int readInt(int from, int to, String mensaje) {
        //sobre carga del metodo readInt
        int value;
        int tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readInt(mensaje);
            if (value < from || value > to) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while (value < from || value > to);
        return value;
    }

    public static int readInt(int from, int to, int exit, String mensaje) {
        //sobre carga del metodo readInt
        int value;
        int tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readInt(mensaje);
            if ((value < from || value > to) && value!=exit ) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while ((value < from || value > to) && value!=exit);
        return value;
    }

    public static long readLong(String message) {
        //leer longs
        boolean ok;//valida si el valor de la entrada es correcto
        long value = Long.MIN_VALUE;//valor minimo del long
        System.out.print(message);//imprime un mensage
    
        do {
            try {
                ok = true;//la entrada esta bien
                value = sc.nextLong(); //recibe el valor
            } catch (InputMismatchException e) {//caso tenga un error de input
                ok = false;//no esta ok
                System.out.print(">> Valor erróneo. " + message);//muestra que el valor ingresado es malo
            } finally {
                sc.nextLine();//salto de linea
            }
        } while (!ok);//si la entrada es ok. entonce termina el ciclo. si no. repite
    
        return value;//retorna el valor
    }

    public static long readLong(long from, long to, String mensaje) {
        //sobre carga del metodo readLong
        long value;
        long tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readLong(mensaje);
            if (value < from || value > to) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while (value < from || value > to);
        return value;
    }
    
    public static long readLong(long from, long to, long exit, String mensaje) {
        //sobre carga del metodo readInt
        long value;
        long tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readLong(mensaje);
            if ((value < from || value > to) && value!=exit ) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while ((value < from || value > to) && value!=exit);
        return value;
    }


    public static double readDouble(String message) {
        //leer doubles
        boolean ok;//valida si el valor de la entrada es correcto
        double value = Double.NaN;//valor minimo del double
        System.out.print(message);//imprime un mensage
    
        do {
            try {
                ok = true;//la entrada esta bien
                value = sc.nextDouble(); //recibe el valor
            } catch (InputMismatchException e) {//caso tenga un error de input
                ok = false;//no esta ok
                System.out.print(">> Valor erróneo. " + message);//muestra que el valor ingresado es malo
            } finally {
                sc.nextLine();//salto de linea
            }
        } while (!ok);//si la entrada es ok. entonce termina el ciclo. si no. repite
    
        return value;//retorna el valor
    }

    public static double readDouble(double from, double to, String mensaje) {
        //sobre carga del metodo readInt
        double value;
        double tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readDouble(mensaje);
            if (value < from || value > to) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while (value < from || value > to);
        return value;
    }

    public static double readLong(double from, double to, double exit, String mensaje) {
        //sobre carga del metodo readInt
        double value;
        double tmp = Math.min(from, to);
        if (tmp == to) {
            to = from;
            from = tmp;
        }
    
        do {
            value = readDouble(mensaje);
            if ((value < from || value > to) && value!=exit ) {
                System.out.printf("%sRango inválido. %s", Utils.RED, Utils.RESET);
            }
        } while ((value < from || value > to) && value!=exit);
        return value;
    }

    
    public static boolean readBoolean(String message) {
        message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        boolean value = false;
        System.out.print(message);

        do {
            try {
                ok = true;
                String str = ' ' + sc.nextLine().toLowerCase().trim() + ' ';//recebe uma string, minuscula com um espaço ao final
                //si so aperto enter, escreve um espaço 
                if (" si s true t yes y ".contains(str)) {//valida si o usuario (si s true t yes y)
                    value = true;
                } else if (" no n false f not ".contains(str)) {//valida si o usuario digitou(no n false f not)
                    value = false;
                } else {
                    throw new InputMismatchException();//"lanza" un exeception
                }
            } catch (InputMismatchException e) {
                ok = false;
                System.out.printf(
                "%s>> Se esperaba [si|s|true|t|yes|y|no|not|n|false|f]%s %s", 
                Utils.RED, Utils.RESET, message
                );
            }
        } while (!ok);

        return value;
    }


    public static LocalDate readDate(String message) {
        //leer datas
        message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        LocalDate date = LocalDate.now();//pega a data de hoje
        System.out.print(message);

        do {
            try {
                ok = true;
                String strDate = sc.nextLine().trim().toLowerCase();//recibe un string data
                if (!"hoy|now".contains(strDate)) {//valida si no es la data de hoy
                    date = LocalDate.parse(strDate);//convierte la data ingresata en el tipo LocalDate
                }
            } catch (DateTimeParseException dtpe) {
                ok = false;
                System.out.printf(
                ">> %sFecha errónea%s. %s", Utils.RED, Utils.RESET, message
                );
            }

        } while (!ok);

        return date;
    }

    public static LocalDate readDate(String from, String to, String mensaje) {
        //leer datas dentro de un rango
        mensaje = String.format("%s%s%s", Utils.BLUE, mensaje, Utils.RESET);
        boolean ok;
        LocalDate date;//variable auxiliar
        //System.out.print(mensaje);
        LocalDate datefrom=LocalDate.parse(from);
        LocalDate dateto=LocalDate.parse(to);
        LocalDate inputDate;
        if(datefrom.isAfter(dateto)){
            date=datefrom;
            datefrom=dateto;
            dateto=date;
        }
        do {
            ok = true;
            inputDate = readDate(mensaje);//recibe un data
            if (inputDate.isBefore(datefrom) || inputDate.isAfter(dateto)) {//valida si no es la data de hoy
                ok = false;
                System.out.printf(
                ">> %sRango Invalido%s. %s", Utils.RED, Utils.RESET, mensaje
                );
            }

        } while (!ok);

        return inputDate;
    }

    public static LocalDateTime readDateTime(String message) {
        message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.print(message);
    
        do {
            try {
                ok = true;
                String strDateTime = sc.nextLine().trim().toLowerCase();
                if (!"ahora|now".contains(strDateTime)) {
                    dateTime = LocalDateTime.parse(strDateTime.replace(" ", "T"));
                }
            } catch (DateTimeParseException dtpe) {
                ok = false;
                System.out.printf(
                   ">> %sFecha y hora errónea%s. %s", Utils.RED, Utils.RESET, message
                );
            }
    
        } while (!ok);
    
        return dateTime;
    }

    public static LocalDateTime readDateTime(LocalDateTime from, LocalDateTime to, String mensaje) {
        //message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        LocalDateTime dateTime;//variable auxiliar
        LocalDateTime inputDateTime;
        if(from.isAfter(to)){
            dateTime=from;
            from=to;
            to=dateTime;
        }
        //System.out.print(message);
    
        do {
            ok = true;
            inputDateTime = readDateTime(mensaje);
            if (inputDateTime.isBefore(from) || inputDateTime.isAfter(to)) {
                ok = false;
                System.out.printf(
                ">> %sRango Invalido%s. %s", Utils.RED, Utils.RESET, mensaje
                );
            }
        } while (!ok);
    
        return inputDateTime;
    }

    private static Duration toDuration(String strDuration) {
        String[] aDuration = strDuration.trim().split(":");
        if (aDuration.length != 2) {
            throw new IllegalArgumentException("Se esperaba HH:MM");
        }
    
        return Duration.parse(
            String.format("PT%sH%sM", aDuration[0].trim(), aDuration[1].trim())
        );
    }

    public static Duration readDuration(String message) {
        message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        Duration duration = Duration.ZERO;
        System.out.print(message);
    
        do {
            try {
                ok = true;
                String strDuration = sc.nextLine();
                duration = toDuration(strDuration);
            } catch (Exception e) {
                ok = false;
                System.out.printf(
                    ">> %sDuración errónea%s. %s", Utils.RED, Utils.RESET, message
                );
            }
    
        } while (!ok);
    
        return duration;
    }

    public static Duration readDuration(String from, String to, String mensaje) {
        //message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        boolean ok;
        Duration duration;
        Duration duraFrom=toDuration(from);
        Duration duraTo=toDuration(to);
        if(duraFrom.compareTo(duraTo)>0){
            duration=duraFrom;
            duraFrom=duraTo;
            duraTo=duration;
        }
        //System.out.print(message);
        Duration strDuration;
        do {
            ok = true;
            strDuration = readDuration(mensaje);
            //duration = toDuration(strDuration);
            if((strDuration.compareTo(duraFrom)<0) || (strDuration.compareTo(duraTo)>0)){
                ok = false;
            System.out.printf(
                ">> %sRango Ivalido%s. %s", Utils.RED, Utils.RESET, mensaje
            );
            }
    
        } while (!ok);
    
        return strDuration;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Enum<T>> T readEnum(Class<T> c, String message) {
        message = String.format("%s%s%s", Utils.BLUE, message, Utils.RESET);
        Object[] allItems = (EnumSet.allOf(c)).toArray();

        int i;
        for (i = 0; i < allItems.length; i++) {
            message += String.format("%n%3d - %s", i + 1, allItems[i]);
        }
        
        message = String.format(
            "%s%nElija una opción entre 1 y %d: ", message, allItems.length
        );

        do {
            i = readInt(message);
            System.out.println();
        } while (i < 1 || i > allItems.length);

        return (T) allItems[i - 1];
    }

}
