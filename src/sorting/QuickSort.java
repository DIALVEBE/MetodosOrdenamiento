package sorting;

/**
 * QuickSort (Ordenamiento Rápido)
 *
 * Algoritmo eficiente O(n log n) en promedio que usa divide y conquista.
 * Selecciona un pivote y particiona el array en elementos menores e iguales al
 * pivote.
 *
 * Complejidad:
 * - Promedio: O(n log n)
 * - Peor caso: O(n²) - cuando el pivote es siempre el menor/mayor elemento
 * - Estable: No
 * - In-place: Sí
 */
public class QuickSort {

    /**
     * Ordena un array de enteros usando QuickSort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * Función recursiva de QuickSort
     * 
     * @param arr  Array a ordenar
     * @param low  Índice inferior
     * @param high Índice superior
     */
    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            // Encuentra el índice de partición
            int pi = partition(arr, low, high);

            // Ordena recursivamente las dos mitades
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    /**
     * Función de partición que toma el último elemento como pivote
     * 
     * @param arr  Array a particionar
     * @param low  Índice inferior
     * @param high Índice superior
     * @return Índice del pivote después de particionar
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivote
        int i = (low - 1); // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivot) {
                i++;
                // Intercambia arr[i] y arr[j]
                swap(arr, i, j);
            }
        }

        // Intercambia arr[i+1] y arr[high] (o pivote)
        swap(arr, i + 1, high);

        return i + 1;
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
        int[] arr = { 10, 7, 8, 9, 1, 5 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}