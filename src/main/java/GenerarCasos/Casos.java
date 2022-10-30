package GenerarCasos;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Esta clase genera 100 casos de prueba para el método de SortColors
 * @author Juan Esteban Serrano Rodelo - 1152033
 * @author Acer
 */
public class Casos {

    /**
     * Método Main que genera 96 datos de prueba con tamaño y datos aleatorios y los convierte en un archivo csv
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        List<String[]> datos = new ArrayList<>();

        //Genera 94 casos con tamaño y datos aleatorios y los guarda en una lista de array de Strings
        for (int i = 0; i < 94; i++) {

            int numDatos = (int) (Math.random() * (300 - 1));
            int datosarr[] = new int[numDatos];

            for (int j = 0; j < numDatos; j++) {
                datosarr[j] = (int) (Math.random() * (3 - 0));;
            }

            datos.add(datosAString(datosarr));
        }
        
        //Guarda en la misma lista los casos especiales
        datos.add(caso1());
        datos.add(caso2());
        datos.add(caso3());
        datos.add(caso4());
        datos.add(caso5());
        datos.add(caso6());
        
        //Genera el archivo csv con los casos de prueba
        String archCSV = "CasosDePrueba.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(archCSV));
        writer.writeAll(datos);
        writer.close();

        System.out.println("Se han generado los casos de prueba");

    }

    /**
     * Metodo que crea un Array de Strings con n datos, siendo todos los datos 0
     * Los datos están en el rango 0<=n<=2
     * @return un Array de String cuyos datos son todos 0
     */
    public static String[] caso1() {
        int numDatos = (int) (Math.random() * (300 - 1));
        int datos[] = new int[numDatos];
        for (int i = 0; i < numDatos; i++) {
            datos[i] = 0;
        }
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings con n datos, siendo todos los datos 1
     * Los datos están en el rango 0<=n<=2
     * @return Un Array de String cuyos datos son todos 1
     */
    public static String[] caso2() {
        int numDatos = (int) (Math.random() * (300 - 1));
        int datos[] = new int[numDatos];
        for (int i = 0; i < numDatos; i++) {
            datos[i] = 1;
        }
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings con n datos, siendo todos los datos 2
     * Los datos están en el rango 0<=n<=2
     * @return Un Array de String cuyos datos son todos 2
     */
    public static String[] caso3() {
        int numDatos = (int) (Math.random() * (300 - 1));
        int datos[] = new int[numDatos];
        for (int i = 0; i < numDatos; i++) {
            datos[i] = 2;
        }
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings con n datos, ordenados de la forma 0,1,2
     * Los datos están en el rango 0<=n<=2
     * @return Un Array de String con los datos ordenados de la forma 0,1,2
     */
    public static String[] caso4() {
        int numDatos = (int) (Math.random() * (300 - 1));
        int datos[] = new int[numDatos];
        for (int i = 0; i < numDatos; i++) {
            datos[i] = (int) (Math.random() * (3 - 0));;
        }
        sortColors(datos);
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings con n datos, invertidos de la forma 2,1,0
     * Los datos están en el rango 0<=n<=2
     * @return Un Array de String con los datos invertidos de la forma 2,1,0
     */
    public static String[] caso5() {
        int numDatos = (int) (Math.random() * (300 - 1));
        int datos[] = new int[numDatos];
        for (int i = 0; i < numDatos; i++) {
            datos[i] = (int) (Math.random() * (3 - 0));;
        }
        sortColors(datos);
        int aux;
        for (int i = 0; i < datos.length / 2; i++) {
            aux = datos[i];
            datos[i] = datos[datos.length - 1 - i];
            datos[datos.length - 1 - i] = aux;
        }
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings con 310 datos (más de los 300 que permite el algortimo)
     * Los datos están en el rango 0<=n<=2
     * @return Un Array de String con 310 datos
     */
    public static String[] caso6() {
        int datos[] = new int[310];
        for (int i = 0; i < 310; i++) {
            datos[i] = (int) (Math.random() * (3 - 0));;
        }
        return datosAString(datos);
    }

    /**
     * Metodo que crea un Array de Strings a partir de un Array de enteros
     * @param intArray Un Array de enetos con los datos de cada uno de los casos de prueba
     * @return Un Array de String con los datos de los casos de prueba
     */
    public static String[] datosAString(int intArray[]) {
        String strArray[] = new String[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            strArray[i] = String.valueOf(intArray[i]);
        }

        return strArray;
    }

    /**
     * Metodo que Ordena un arreglo de enteros a la forma 0,1,2
     * @param nums Un Array de enteros con los datos a ordenar
     */
    public static void sortColors(int[] nums) {
        int index = 0;
        int start = 0;
        int end = nums.length - 1;

        while (index <= end && start < end) {
            if (nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if (nums[index] == 2) {
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                index++;
            }
        }
    }
}
