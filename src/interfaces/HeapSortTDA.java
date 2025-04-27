package interfaces;

public interface HeapSortTDA {
    void InicializarHeap(); // Inicializa la estructura.

    void insertar(int valor);  //Agrega elementos al heapsort.

    void heapSort (int arreglo[]); //Ordena el arreglo.

    int primero();     // Devuelve el mayor o menor valor del elemento. 

    boolean heapVacio();        // Informa si el heap está vacío.
    
    void mostrarComoArbol(); //Muestra el heap de forma iterativa.
}
