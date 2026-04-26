package sorting;

/**
 * Heap Sort (Ordenamiento por Montículo)
 *
 * Algoritmo eficiente O(n log n) que construye un heap máximo y
 * extrae el elemento máximo repetidamente para construir el array ordenado.
 *
 * Complejidad:
 * - Siempre: O(n log n)
 * - Estable: No
 * - In-place: Sí
 */
public class HeapSort {

    /**
     * Ordena un array de enteros usando Heap Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        int n = arr.length;

        // Construye heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrae elementos uno por uno del heap
        for (int i = n - 1; i > 0; i--) {
            // Mueve la raíz actual al final
            swap(arr, 0, i);

            // Llama heapify en el heap reducido
            heapify(arr, i, 0);
        }
    }

    /**
     * Función para convertir un subárbol en heap
     * 
     * @param arr Array
     * @param n   Tamaño del heap
     * @param i   Índice raíz del subárbol
     */
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Inicializa largest como raíz
        int left = 2 * i + 1; // izquierdo = 2*i + 1
        int right = 2 * i + 2; // derecho = 2*i + 2

        // Si el hijo izquierdo es más grande que la raíz
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Si el hijo derecho es más grande que largest hasta ahora
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Si largest no es la raíz
        if (largest != i) {
            swap(arr, i, largest);

            // Recursivamente heapify el subárbol afectado
            heapify(arr, n, largest);
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
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}