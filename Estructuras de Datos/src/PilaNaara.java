class Nodo {
    int info; 
    Nodo sig; 
}

private Nodo raiz; 

Pila() {
    raiz = null;
}

public void insertar(int x) {
    Nodo nuevo;
    nuevo = new Nodo();
    nuevo.info = x;
    if (raiz == null)
    {
        nuevo.sig = null;
        raiz = nuevo;
    }
    else
    {
        nuevo.sig = raiz;
        raiz = nuevo;
    }
}

// Para declarar un nodo debemos utilizar una clase. En este caso la info del nodo (info) es un entero y siempre el nodo tendra referencia de tipo Nodo, que le llamamos sig.
//El puntero sig apunta al siguiente nodo o a null en caso que no exista otro nodo. Este puntero es interno a la lista.
//Despues definimos un puntero de tipo Nodo llamado raiz. Este puntero tiene la direccion del primer nodo de la lista. En caso de estar vacia la lista, raiz apunta a null (es decir, no tiene direccion).
//El ppuntero raiz es fundamental porque al tener la direccion del primer nodo de la lista nos permite acceder a los demas nodos.
//El constructor de la clase hacemos que raiz guarde el valor null. Tengamos en cuenta que si raiz tiene almacenado null la lista esta vaciam en caso contrario tiene la direccion del primer nodo de la lista. 
//Uno de los metodos mas importantes que debemos entender en una pila es el de insertar un elemento en la pila.
//Al metodo llega la informacion a insertar, en este caso en particular es un valor entero.
