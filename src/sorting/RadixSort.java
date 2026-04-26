package sorting;

import java.util.Arrays;

/**
 * Radix Sort (Ordenamiento por Raíz/Base)
 *
 * Algoritmo no comparativo que ordena números procesando dígito por dígito,
 * comenzando desde el dígito menos significativo (LSD).
 *
 * Complejidad:
 * - O(n * k) donde k es el número de dígitos
 * - Estable: Sí
 * - In-place: No
 */
public class RadixSort {

    /**
     * Ordena un array de enteros usando Radix Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        // Encuentra el número máximo para determinar el número de dígitos
        int max = Arrays.stream(arr).max().orElse(0);

        // Hace counting sort para cada dígito
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    /**
     * Counting sort modificado para ordenar por un dígito específico
     * 
     * @param arr Array a ordenar
     * @param exp Exponente (1, 10, 100, etc.) para el dígito
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 10 dígitos (0-9)

        // Cuenta ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Cambia count[i] para que contenga la posición actual de este dígito en output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construye el array output
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
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
        int[] arr = { 170, 45, 75, 90, 802, 24, 2, 66 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}