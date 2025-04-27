package prin;

import implementaciones.HeapSortMax;
import interfaces.HeapSortTDA;
import java.util.Arrays;

public class PrinHeapSortMax {
    public static void main(String[] args) {
        
        HeapSortTDA heap = new HeapSortMax();
        heap.InicializarHeap();

        int[] arr = {10,1,5,23,12,14,7};
        for (int i = 0; i < arr.length; i++) {
            heap.insertar(arr[i]);
        }        
        System.out.println("");
        heap.mostrarComoArbol();
        System.out.println("Arreglo original: " + Arrays.toString(arr));

        heap.heapSort(arr);

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));

    }
}
