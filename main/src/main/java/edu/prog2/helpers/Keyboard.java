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

}
