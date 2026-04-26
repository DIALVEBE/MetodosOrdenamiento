package sorting;

/**
 * Bubble Sort (Ordenamiento Burbuja)
 *
 * Algoritmo básico O(n²) que compara elementos adyacentes y los intercambia
 * si están en orden incorrecto. "Hace burbujear" el elemento más grande al
 * final.
 *
 * Complejidad:
 * - Peor caso: O(n²)
 * - Mejor caso: O(n) si está optimizado para detectar si ya está ordenado
 * - Estable: Sí
 * - In-place: Sí
 */
public class BubbleSort {

    /**
     * Ordena un array de enteros usando Bubble Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        // Optimización: si no hay intercambios en una pasada, ya está ordenado
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Compara elementos adyacentes
                if (arr[j] > arr[j + 1]) {
                    // Intercambia si están en orden incorrecto
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            // Si no hubo intercambios, el array ya está ordenado
            if (!swapped)
                break;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}