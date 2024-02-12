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
    public static Scanner sc = new Scanner(con.reader()).useDelimiter("[\n]+|[\r\n]+");

    public static String readString(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

}
