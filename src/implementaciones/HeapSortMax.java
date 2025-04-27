package implementaciones;

import interfaces.HeapSortTDA;

public class HeapSortMax implements HeapSortTDA{
    private int[] heap;  // Declara el heap.
    private int cantidad; //Declara cantidad.
    private int capacidad = 15; //Pone una capacidad al heap, es estatico.

    private int padre(int indice) {
        return (indice - 1) / 2; //Indice del heap padre. 
    }

    private int hijoIzq(int indice) {
        return 2 * indice + 1; //Indice del hijo izquierdo.
    }

    private int hijoDer(int indice) {
        return 2 * indice + 2; //Indice de hijo derech.
    }
    public void InicializarHeap() {
        heap = new int[capacidad]; //Inicializa el heap, con cantidad 0 de elementos.
        cantidad = 0;
    }

    public void insertar(int valor) { //Se insertan valores en el heap.
        if (cantidad == capacidad) { //En caso de que el heap (ESTATICO), haya llegado a su capacidad.
            System.out.println("El heap llegó a su límite de heap.");
        } else {
            heap[cantidad] = valor; //Se inserta el valor en el nodo.
            flotar(cantidad); //Organiza el heap.
            cantidad++; //Aumenta en uno la cantidad de elementos.
        }
    }

    private void flotar(int i) {
        while (i > 0 && heap[padre(i)] < heap[i]) { //En caso de que el valor del heap padre sea menor que el valor del heap hijo.
            swapHeap(padre(i), i); //Organiza el heap.
            i = padre(i); //Busca la posición del padre.
        }
    }

    private void swapHeap(int i, int j) { //La i es el valor de la posición del padre, la j es el valor de la posición del hijo
        int temporal = heap[i]; // Guarda el valor del padre, para no sobreescribirlo.
        heap[i] = heap[j]; //El hijo pasa a ser padre.
        heap[j] = temporal; //El padre pasa a ser hijo.
    }

    public void hundir(int[] arr, int cantidad, int i) {//Para ordenar el arreglo.
        int izquierdo = hijoIzq(i); //Indice de hijo izquierdo.
        int derecho = hijoDer(i); //Indice de hijo derecho.
        int mayor = i; //Indice de padre.


        if (izquierdo < cantidad && arr[izquierdo] > arr[mayor])//Hijo izquierdo menor que la cantidad, hijo izquierdo mayor que el padre.
            mayor = izquierdo;//Izquierdo pasa a ser el mayor.

        if (derecho < cantidad && arr[derecho] > arr[mayor]) //Hijo derecho menor que la cantidad, hijo derecho mayor que el padre.
            mayor = derecho;//Derecho pasa a ser el mayor.

        if (mayor != i) { //En caso que haya un cambio de valor en la raiz, ya sea el hijo derecho o el izquierdo.
            swapArr (arr, i, mayor); //Se intercambian el valor de la raiz por el ultimo valor del arreglo.

            hundir(arr, cantidad, mayor); //Se vuelve a ordenar el arreglo.
        }    }

    public void heapSort(int[] arr) {
        int cantidad = arr.length; //Cantidad = largo del arreglo.

        //Se copia la estructura del heap, en el arreglo.
        for (int i = cantidad / 2 - 1; i >= 0; i--)//Desde cantidad / 2 -1, hasta que el i sea mayor o igual que 0, y resta 1 en i.
            hundir(arr, cantidad, i); //Para que el arreglo tenga la misma estructura (valores y respectiva posicion) que el heap.


        //En cada iteración, extrae la raiz, la pone al final y hunde la nueva raíz en el heap reducido.
        for (int i = cantidad - 1; i > 0; i--) {
            // Mueve el máximo (arr[0]) al final.
            swapArr(arr, 0, i);
            // Se ordena el array nuevamente (sin incluir el final ya ordenado).
            hundir(arr, i, 0);
        }
    }
    private void swapArr (int arreglo[],int cant, int may){ //Se ordena el arreglo.
        int temp = arreglo[cant]; //Se guarda el valor de la raiz.
        arreglo[cant] = arreglo[may]; //Se cambia la raiz por el ultimo valor.
        arreglo[may] = temp; //Se cambia el valor de la raiz en la ultima posicion.
    }


    
    public int primero() {
        return heap[0]; //Devuelve el primer elemento del heap, en este caso el mayor.
    }

    public boolean heapVacio() {
        return (cantidad == 0); //Devuelve true, en caso que este vacio el heap.
    }

    public void mostrarComoArbol() { //Muestra el heap.
        int niveles = (int) Math.floor(Math.log(cantidad) / Math.log(2)) + 1;
        int index = 0;
    
        for (int nivel = 0; nivel < niveles; nivel++) {
            int cantidadEnNivel = (int) Math.pow(2, nivel);
            int espacioAntes = (int) Math.pow(2, niveles - nivel) - 1;
            int espacioEntre = (int) Math.pow(2, niveles - nivel + 1) - 1;
    
            imprimirEspacios(espacioAntes);
    
            for (int i = 0; i < cantidadEnNivel && index < cantidad; i++) {
                System.out.printf("%2d", heap[index++]);
                imprimirEspacios(espacioEntre);
            }
    
            System.out.println();
        }
    }
    
    private void imprimirEspacios(int cantidadEspacios) {
        for (int i = 0; i < cantidadEspacios; i++) {
            System.out.print("  "); 
        }
    }


}
