package daw;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 */
public class Calendario {

    //ATRIBUTOS
    private int[][] calendario;
    private int mes;
    private int anio;

    //CONSTRUCTORES
    public Calendario() {
    }

    public Calendario(int mes, int anio) {
        this.mes = mes;
        this.anio = anio;
        this.calendario = new int[6][7];
        generarCalendario();
    }

    //MÉTODO PARA RELLENAR LA MATRIZ CALENDARIO CON LOS DÍAS DEL MES QUE SE INDÍCA
    public void generarCalendario() {

        int contador = 1;

        for (int i = 0; i < this.calendario.length; i++) {
            for (int j = 0; j < this.calendario[i].length; j++) {
                if (contador <= tamanioMes()) { //  filtro para evitar que se añadan días que no están en el mes
                    if (contador == 1) {
                        j = diaEmpiezaMes();
                    }
                    this.calendario[i][j] = contador;
                    contador++;
                }
            }
        }

    }

    //MÉTODO QUE INDICA EN QUE DÍA EMPIEZA EL MES
    public int diaEmpiezaMes() {
        LocalDate fecha = LocalDate.of(this.anio, this.mes, 1);
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int posicion = -1;

        //indica en que día empieza el mes
        Locale configLocal = Locale.getDefault();
        String diaSemana = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, configLocal);
        

        for (int i = 0; i < dias.length; i++) {
            if (dias[i].equalsIgnoreCase(diaSemana)) {
                posicion = i;
            }
        }
        return posicion;
    }

    //MÉTODO PARA MOSTRAR POR PANTALLA EL CALENDARIO ORDENADO POR LOS DÍAS DE LA SEMANA
    public void mostrarCalendario() {
        System.out.println("L       M       X       J       V       S       D");

        for (int i = 0; i < this.calendario.length; i++) {
            for (int j = 0; j < this.calendario[i].length; j++) {

                if (this.calendario[i][j] >= 1 || this.calendario[i][j] <= tamanioMes()) {
                    System.out.print(this.calendario[i][j] + "\t");
                }
            }
            System.out.println("");
        }

    }

    //MÉTODO PARA AVERIGUAR EN QUE DÍA DE LA SEMANA CAE UN DÍA DEL MES
    public String diaSemana(int diaMes, Calendario objeto) {

        int columna = -1;
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        String resultado = "";

        //Buscamos en el calendario el día introducido
        //Filtro para evitar que el día introducido no esté en el mes
        if (diaMes <= tamanioMes() && diaMes > 0) {
            for (int i = 0; i < this.calendario.length; i++) {
                for (int j = 0; j < this.calendario[i].length; j++) {
                    //Mientras recorre el bucle si el valor de una posición de la matriz es igual al día del mes
                    //introducido por el usuario nos guarda la columna en la que está, ya que la columna nos
                    //indica en que día de la semana está
                    if (this.calendario[i][j] == diaMes) {
                        columna = j;
                    }
                }
            }

            resultado = dias[columna];

        } else {
            throw new IllegalArgumentException("Día fuera de los parámetros");
        }

        return resultado;
    }

    //MÉTODO QUE DEVUELVE UN INT QUE NOS INDICA LA DURACIÓN DEL MES
    public int tamanioMes() {
        LocalDate fecha = LocalDate.of(this.anio, this.mes, 1);
        int numDias = fecha.lengthOfMonth();
        return numDias;
    }

    //MÉTODO QUE GENERA Y DEVUELVE UN ARRAY DE CALENDARIOS CON TODOS LOS MESES DEL AÑO
    //Y SUS DÍAS ORDENADOS
    public Calendario[] calendarioAnual(int anio) {

        Calendario[] array = new Calendario[12];
        int mes = 1;

        //bucle para que se creen calendarios de cada mes del año
        for (int i = 0; i < 12; i++) {
            Calendario aux = new Calendario(mes, anio);
            array[i] = aux; //se guarda el calendario creado en el array
            mes++;
        }

        return array;
    }
}
