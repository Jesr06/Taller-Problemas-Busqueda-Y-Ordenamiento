package leercasos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Esta clase lee los 100 casos de prueba y los ejecuta con el algoritmo SortColors
 * @author Juan Esteban Serrano Rodelo - 1152033
 * @author Juan Esteban Hernández Álvarez - 1152122
 */
public class LeerCasos {

    /**
     * Método Main que lee los 100 casos de prueba y los ejecuta en el método SortColors
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = null;
        int i = 1;
        
        try {
            br = new BufferedReader(new FileReader("CasosDePrueba.csv"));
            String line = br.readLine();
            while (null != line) {
                String[] fields = line.split(";");
                String[] aux = line.split(",");

                System.out.println("Caso "+i);
                int x[] = datosAInt(aux);
                sortColors(x);
                System.out.println(imprimir(x));
                
                i++;
                line = br.readLine();
            }

        } catch (Exception e) {
            System.err.println("Error");
        } finally {
            if (null != br) {
                br.close();
            }
        }
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

    /**
     * Metodo que crea un Array de enteros a partir de un Array de Strings
     * @param intArray Un Array de enetos con los datos de cada uno de los casos de prueba
     * @return Un Array de String con los datos de los casos de prueba
     */
    public static int[] datosAInt(String array[]) {
        int intArray[] = new int [array.length];

        for (int i = 0; i < intArray.length; i++) {
            String x = array[i];
            String tmp = "";
            for(int j=1; j<x.length()-1; j++){
                tmp = tmp+x.charAt(j);
            }
            intArray[i] = Integer.parseInt(tmp);
        }

        return intArray;
    }

    /**
     * Metodo que imprime los datos de los casos de prueba
     * @param datos Arreglo de enteros con los datos de prueba
     * @return Un String con los datos de prueba
     */
    public static String imprimir(int datos[]) {
        String imp = "";
        for (int i = 0; i < datos.length; i++) {
            imp += datos[i] + " ";
        }
        return imp;
    }
}
