/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Scanner;

/**
 *
 * @author alejandro
 */
public class Programa {
    public static void main(String[] args) {
        
        int anio = anio();
        int mes = mes();
        
        Calendario fecha = new Calendario(mes, anio);
        
        
        fecha.mostrarCalendario();
        
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("El 17 cae en el día: " + fecha.diaSemana(17, fecha));
        System.out.println("-----------------------------------------------------------------------");
        
        System.out.println("Generar un calendario con todos los meses del año");
        Calendario[] calendarioAnual = fecha.calendarioAnual(2020);
        for (int i = 0; i < calendarioAnual.length; i++) {
            System.out.println("Mes " + (i + 1));
            calendarioAnual[i].mostrarCalendario();
            System.out.println("-----------------------------------------------------------------------");
        }
    }
    public static Scanner teclado = new Scanner(System.in);
    
    public static int anio(){
        int anio;
        do {
            System.out.println("Escribe un año entre 1950 y 2050");
            anio = teclado.nextInt();
            if (anio < 1950 || anio > 2050) {
                System.out.println("Año fuera de los parámetros");
            }
        } while (anio < 1950 || anio > 2050);
        return anio;
    }
    
    public static int mes(){
        int mes;
        do {
            System.out.println("Escribe un mes del año");
            mes = teclado.nextInt();
            if (mes < 1 || mes > 12) {
                System.out.println("Mesfuera de los parámetros");
            }
        } while (mes < 1 || mes > 12);
        return mes;
    }
}
