package sorting;

/**
 * Insertion Sort (Ordenamiento por Inserción)
 *
 * Algoritmo básico que toma cada elemento y lo inserta en la posición correcta
 * en la porción ya ordenada del array.
 *
 * Complejidad:
 * - Mejor caso: O(n) - cuando el array ya está casi ordenado
 * - Peor caso: O(n²)
 * - Estable: Sí
 * - In-place: Sí
 */
public class InsertionSort {

    /**
     * Ordena un array de enteros usando Insertion Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Mueve elementos mayores que key una posición adelante
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Inserta key en su posición correcta
            arr[j + 1] = key;
        }
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
        int[] arr = { 12, 11, 13, 5, 6 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}