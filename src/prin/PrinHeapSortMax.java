package prin;

import implementaciones.HeapSortMax;
import interfaces.HeapSortTDA;
import java.util.Arrays;

public class PrinHeapSortMax {
    public static void main(String[] args) {
        
        HeapSortTDA heap = new HeapSortMax(); //Se crea el heap.
        heap.InicializarHeap();  //Se inicializa.
        System.out.println("El heap está vacío?  "+heap.heapVacio());

        int[] arr = {10,1,5,23,12,14,7};  // Se crea un arreglo.
        for (int i = 0; i < arr.length; i++) {//Desde i = 0, mientras el i sea menor que la cantidad del arreglo, el i aumenta en 1.
            heap.insertar(arr[i]); //Se inserta en el heap cada elemento del arreglo.
        }        
        System.out.println("");
        System.out.println("El heap está vacío?  "+heap.heapVacio()); //Se verifica que el heap se haya llenado.

        System.out.println(""); //Espacio en blanco.
        heap.mostrarComoArbol(); //Se muestra el heap.
        System.out.println("Arreglo original: " + Arrays.toString(arr));

        heap.heapSort(arr); //Se ordena el arreglo, a traves de heapsort.

        System.out.println("Arreglo ordenado: " + Arrays.toString(arr));

    }
}
