package sorting;

/**
 * Selection Sort (Ordenamiento por Selección)
 *
 * Algoritmo básico O(n²) que busca el elemento mínimo en la porción no ordenada
 * y lo intercambia con el primer elemento de esa porción.
 *
 * Complejidad:
 * - Siempre: O(n²)
 * - Estable: No (por defecto)
 * - In-place: Sí
 */
public class SelectionSort {

    /**
     * Ordena un array de enteros usando Selection Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Encuentra el índice del elemento mínimo en arr[i..n-1]
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Intercambia el elemento mínimo encontrado con el primer elemento
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
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
        int[] arr = { 64, 25, 12, 22, 11 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}