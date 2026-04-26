# Métodos de Ordenamiento en Java

Este proyecto explica de manera clara los algoritmos de ordenamiento más importantes, desde conceptos básicos hasta implementaciones avanzadas en Java.

## 📚 1. Fundamentos que deben entender primero

### 🔹 Conceptos básicos

**¿Qué es ordenar?**

- **Ascendente**: De menor a mayor (1, 2, 3, 4...)
- **Descendente**: De mayor a menor (4, 3, 2, 1...)

**Tipos de datos**

- **Numéricos**: int, double, float
- **Strings**: Orden alfabético
- **Objetos con clave**: Clases que implementan Comparable o Comparator

**Comparación vs no comparación**

- **Comparativos**: Usan operadores <, >, == (Bubble, Quick, Merge, etc.)
- **No comparativos**: Usan propiedades específicas (Radix, Counting, Bucket)

**Ordenamiento interno vs externo**

- **Interno**: Todo en memoria RAM
- **Externo**: Usa archivos/disco para datos grandes

### 🔹 Propiedades importantes

- **Estabilidad**: Mantiene el orden relativo de elementos iguales
- **In-place**: Usa memoria adicional mínima (O(1) extra space)
- **Adaptativo**: Mejora rendimiento con datos parcialmente ordenados

### 🔹 Complejidad

**Notación Big-O:**

- **Mejor caso**: Rendimiento óptimo
- **Caso promedio**: Rendimiento típico
- **Peor caso**: Rendimiento peor escenario
- **Espacio**: Memoria adicional requerida

#### Entendiendo Big-O: Conceptos Fundamentales

**¿Qué es la notación Big-O?**

Big-O es una forma de describir cómo crece el tiempo de ejecución o el uso de memoria de un algoritmo a medida que aumenta el tamaño de la entrada (n). Nos ayuda a comparar algoritmos y entender su eficiencia sin depender de detalles específicos del hardware o implementación.

**Funciones comunes de complejidad:**

- **O(1) - Constante**: El tiempo no depende del tamaño de entrada. Ejemplo: acceder a un elemento en un array por índice.
- **O(log n) - Logarítmica**: Crece lentamente. Ejemplo: búsqueda binaria.
- **O(n) - Lineal**: Crece proporcionalmente al tamaño. Ejemplo: recorrer un array.
- **O(n log n) - Lineal logarítmica**: Más rápido que cuadrático. Ejemplo: algoritmos eficientes de ordenamiento.
- **O(n²) - Cuadrática**: Crece al cuadrado. Ejemplo: algoritmos básicos de ordenamiento.
- **O(2^n) - Exponencial**: Crece muy rápido. Ejemplo: problemas de combinatoria.

**Cómo calcular Big-O:**

1. **Identificar operaciones básicas**: Contar las operaciones que dependen de n (bucles, recursiones).
2. **Ignorar constantes**: O(2n) = O(n), O(n² + 3n + 1) = O(n²).
3. **Mantener el término dominante**: En O(n² + n), el n² domina para n grande.
4. **Considerar casos anidados**: Bucles anidados multiplican complejidades.

**Ejemplos de cálculo:**

```java
// Ejemplo 1: O(1)
int getFirst(int[] arr) {
    return arr[0];  // Una operación, independiente de n
}

// Ejemplo 2: O(n)
void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {  // Bucle que recorre n elementos
        System.out.print(arr[i] + " ");
    }
}

// Ejemplo 3: O(n²)
void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {      // n veces
        for (int j = 0; j < arr.length; j++) {  // n veces por cada i
            // comparación
        }
    }
}

// Ejemplo 4: O(n log n)
void mergeSort(int[] arr) {
    if (arr.length <= 1) return;
    // Divide en mitades: O(log n) niveles
    // Cada nivel procesa n elementos: O(n) por nivel
    // Total: O(n log n)
}
```

**Casos: Mejor, Promedio y Peor**

- **Mejor caso**: Cuando el algoritmo encuentra las condiciones más favorables.
  - Ejemplo: Bubble Sort en array ya ordenado → O(n)
- **Caso promedio**: Rendimiento típico esperado.
  - Ejemplo: QuickSort → O(n log n)
- **Peor caso**: Cuando el algoritmo enfrenta las condiciones más desfavorables.
  - Ejemplo: QuickSort con pivote siempre mínimo/máximo → O(n²)

**Visualización del crecimiento:**

Para n = 1000:

- O(1): 1 operación
- O(log n): ~10 operaciones
- O(n): 1000 operaciones
- O(n log n): ~10000 operaciones
- O(n²): 1000000 operaciones

Big-O nos ayuda a elegir el algoritmo correcto según las restricciones de tiempo y espacio.

### 🫧 Bubble Sort (Burbuja)

Compara elementos adyacentes y los intercambia si están en orden incorrecto.

**Complejidad:**

- Peor: O(n²)
- Mejor: O(n) (optimizado)
- Estable: ✅
- In-place: ✅

**Ventajas:** Muy simple de entender
**Desventajas:** Poco eficiente para listas grandes

### 🔁 Selection Sort

Busca el elemento mínimo en la porción no ordenada y lo intercambia con el primer elemento.

**Complejidad:**

- Siempre: O(n²)
- Estable: ❌ (por defecto)
- In-place: ✅

**Ventajas:** Mínimo número de intercambios
**Desventajas:** Ineficiente en general

### 🧩 Insertion Sort

Toma cada elemento y lo inserta en la posición correcta en la porción ya ordenada.

**Complejidad:**

- Mejor: O(n)
- Peor: O(n²)
- Estable: ✅
- In-place: ✅

**Ventajas:** Excelente para listas pequeñas o casi ordenadas
**Desventajas:** Cuadrático en peor caso

## ⚡ 3. Algoritmos eficientes (O(n log n))

### ⚡ Quicksort

Algoritmo divide y conquista que usa un pivote para particionar el array.

**Complejidad:**

- Promedio: O(n log n)
- Peor: O(n²)
- Estable: ❌
- In-place: ✅

**Ventajas:** Muy rápido en práctica, usado en librerías estándar
**Desventajas:** Peor caso O(n²) con pivote malo

### 🧬 Merge Sort

Divide el array en mitades, ordena recursivamente y luego combina.

**Complejidad:**

- Siempre: O(n log n)
- Estable: ✅
- In-place: ❌

**Ventajas:** Estable, garantizado O(n log n)
**Desventajas:** Usa memoria extra O(n)

### 🌳 Heap Sort

Construye un heap máximo y extrae elementos uno por uno.

**Complejidad:**

- Siempre: O(n log n)
- Estable: ❌
- In-place: ✅

**Ventajas:** Garantizado O(n log n), buen para memoria limitada
**Desventajas:** No estable, más lento que quicksort en práctica

## 🔢 4. Algoritmos no comparativos

### 🔢 Radix Sort

Ordena números por dígitos individuales, de menos significativo a más.

**Complejidad:**

- O(n \* k) donde k es número de dígitos
- Estable: ✅
- In-place: ❌

**Ventajas:** Muy rápido para enteros
**Desventajas:** Solo para tipos con dígitos naturales

### 🔢 Counting Sort

Cuenta ocurrencias de cada elemento y reconstruye el array ordenado.

**Complejidad:**

- O(n + k) donde k es el rango
- Estable: ✅
- In-place: ❌

**Ventajas:** Lineal para rangos pequeños
**Desventajas:** Requiere conocer el rango máximo

### 🪣 Bucket Sort

Divide elementos en "cubetas" basadas en rangos, ordena cada cubeta.

**Complejidad:**

- Promedio: O(n + k)
- Depende de distribución de datos
- Estable: ✅ (dependiendo implementación)

**Ventajas:** Excelente para datos uniformemente distribuidos
**Desventajas:** Sensible a mala distribución

## 🧠 5. Comparaciones clave

| Algoritmo  | Tiempo promedio | Peor caso  | Estable | In-place |
| ---------- | --------------- | ---------- | ------- | -------- |
| Burbuja    | O(n²)           | O(n²)      | ✅      | ✅       |
| Inserción  | O(n²)           | O(n²)      | ✅      | ✅       |
| Selección  | O(n²)           | O(n²)      | ❌      | ✅       |
| Quicksort  | O(n log n)      | O(n²)      | ❌      | ✅       |
| Merge Sort | O(n log n)      | O(n log n) | ✅      | ❌       |
| Heap Sort  | O(n log n)      | O(n log n) | ❌      | ✅       |
| Radix Sort | O(nk)           | O(nk)      | ✅      | ❌       |

## 🚀 Cómo usar

Cada algoritmo está implementado en su propia clase Java en el paquete `sorting`.
Cada clase incluye:

- Método `sort()` para ordenar arrays
- Explicación del algoritmo en comentarios
- Ejemplo de uso en el método `main()`

Compila y ejecuta las clases individuales para ver los ejemplos.

### 🌐 Simuladores en línea

También puedes ver estos algoritmos funcionando paso a paso en simuladores gratuitos:

- https://www.sortvision.com/es/algorithms
- https://sortwizard.dev/?algo=Bubble+sort&speed=250

