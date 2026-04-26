package sorting;

/**
 * Counting Sort (Ordenamiento por Conteo)
 *
 * Algoritmo no comparativo que cuenta ocurrencias de cada elemento
 * y reconstruye el array ordenado usando esta información.
 *
 * Complejidad:
 * - O(n + k) donde k es el rango de los elementos
 * - Estable: Sí
 * - In-place: No
 *
 * Limitación: Requiere conocer el rango máximo de los elementos
 */
public class CountingSort {

    /**
     * Ordena un array de enteros usando Counting Sort
     * 
     * @param arr      Array a ordenar
     * @param maxValue Valor máximo en el array (rango 0-maxValue)
     */
    public static void sort(int[] arr, int maxValue) {
        int n = arr.length;
        int[] count = new int[maxValue + 1];
        int[] output = new int[n];

        // Cuenta ocurrencias de cada elemento
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Cambia count[i] para que contenga la posición actual de este elemento en
        // output
        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }

        // Construye el array output
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copia output al array original
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * Imprime un array
     */
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Ejemplo de uso
     */
    public static void main(String[] args) {
        int[] arr = { 4, 2, 2, 8, 3, 3, 1 };
        int maxValue = 8; // Valor máximo en el array

        System.out.println("Array original:");
        printArray(arr);

        sort(arr, maxValue);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}