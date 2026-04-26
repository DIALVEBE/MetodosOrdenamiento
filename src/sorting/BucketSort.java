package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Bucket Sort (Ordenamiento por Cubetas)
 *
 * Algoritmo no comparativo que divide los elementos en "cubetas" basadas en
 * rangos,
 * ordena cada cubeta individualmente y luego combina los resultados.
 *
 * Complejidad:
 * - Promedio: O(n + k) donde k es el número de cubetas
 * - Depende de la distribución de los datos
 * - Estable: Sí (dependiendo de la implementación)
 * - In-place: No
 *
 * Mejor para datos uniformemente distribuidos
 */
public class BucketSort {

    /**
     * Ordena un array de doubles usando Bucket Sort
     * Asume que los elementos están en el rango [0, 1)
     * 
     * @param arr Array a ordenar
     */
    public static void sort(double[] arr) {
        int n = arr.length;

        // Crea cubetas vacías
        List<Double>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuye elementos en cubetas
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }

        // Ordena cada cubeta
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // Concatena todas las cubetas en el array original
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (double num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    /**
     * Imprime un array
     */
    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Ejemplo de uso
     */
    public static void main(String[] args) {
        double[] arr = { 0.897, 0.565, 0.656, 0.123, 0.665, 0.343 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}