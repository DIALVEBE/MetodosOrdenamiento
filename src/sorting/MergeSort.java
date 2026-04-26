package sorting;

/**
 * Merge Sort (Ordenamiento por Mezcla)
 *
 * Algoritmo eficiente O(n log n) que divide el array en mitades,
 * ordena recursivamente cada mitad y luego las combina ordenadamente.
 *
 * Complejidad:
 * - Siempre: O(n log n)
 * - Estable: Sí
 * - In-place: No (usa memoria extra O(n))
 */
public class MergeSort {

    /**
     * Ordena un array de enteros usando Merge Sort
     * 
     * @param arr Array a ordenar
     */
    public static void sort(int[] arr) {
        if (arr.length < 2)
            return;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Copia elementos a subarrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Ordena recursivamente las mitades
        sort(left);
        sort(right);

        // Combina las mitades ordenadas
        merge(arr, left, right);
    }

    /**
     * Función que combina dos subarrays ordenados en uno solo ordenado
     * 
     * @param arr   Array destino
     * @param left  Subarray izquierdo ordenado
     * @param right Subarray derecho ordenado
     */
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Combina mientras haya elementos en ambos subarrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copia elementos restantes del subarray izquierdo
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copia elementos restantes del subarray derecho
        while (j < right.length) {
            arr[k++] = right[j++];
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
        int[] arr = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Array original:");
        printArray(arr);

        sort(arr);

        System.out.println("Array ordenado:");
        printArray(arr);
    }
}