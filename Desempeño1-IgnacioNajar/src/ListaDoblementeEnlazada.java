public class ListaDoblementeEnlazada {
    public class Nodo {
        int info;
        Nodo anterior, siguiente;
    }

    private Nodo raiz, fin;
    private int tamaño;

    public ListaDoblementeEnlazada() {
        raiz = null;
        fin = null;
        tamaño = 0;
    }

    public boolean esListaVacia() {
        return tamaño == 0;
    }

    public int obtenerCantidad() {
        return tamaño;
    }

    public void insertarNodos(int valor1, int valor2) {
        Nodo nuevo = new Nodo();
        nuevo.info = valor1;

        Nodo siguiente = new Nodo();
        siguiente.info = valor2;

        //Enlazamos los dos nodos nuevos
        nuevo.siguiente = siguiente;
        siguiente.anterior = nuevo;
        
        //Insertamos los nodos al ultimo
        if (tamaño == 4) {
            fin.siguiente = nuevo;
            nuevo.anterior = fin;
            fin = siguiente;
            siguiente.siguiente = null;
        } else {
            //Insertamos al principio
            if (raiz != null) {
                siguiente.siguiente = raiz;
                raiz.anterior = siguiente;
            } else {
                //Si la lista esta vacia
                fin = siguiente;
            }
            raiz = nuevo; //El primer nodo a ingresar siempre va a ser la nueva raiz
        }
        tamaño+=2;
    }

    public int sumarValoresEnPosicionesImpares() {
        if (esListaVacia()) {
            System.out.println("No hay nodos para sumar, la lista está vacía.");
            return Integer.MAX_VALUE;
        }

        Nodo recorrer = raiz;
        int suma = 0;
        int posicion = 1;

        while (recorrer != null) {
            if (posicion % 2 != 0) {
                suma += recorrer.info;
            }
            posicion++;
            recorrer = recorrer.siguiente;
        }

        return suma;
    }

    public void borrarPrimerYUltimoNodo() {
        if (esListaVacia()) {
            System.out.println("No hay nodos para borrar, la lista está vacía.");
            return;
        }

        if (tamaño <= 2) {
            raiz = null;
            fin = null;
            tamaño = 0;
        } else {
            raiz = raiz.siguiente;
            raiz.anterior = null;
            fin = fin.anterior;
            fin.siguiente = null;
            tamaño-=2;
        }
    }

    public void intercambiarPrimerYUltimoNodo() {
        if (tamaño == 1 || esListaVacia()) {
            System.out.println("No se puede realizar el intercambio, la lista está vacía o solo tiene un nodo");
            return;
        }

        Nodo raizAuxiliar = raiz;
        //Realizo el intercambio de punteros
        raiz = fin;
        fin = raizAuxiliar;

        //Actualizo los punteros de los nodos intermedios
        //Si la lista tiene dos nodos solamente
        if (tamaño == 2) {
            raiz.siguiente = fin;
            fin.anterior = raiz;
        } else {
            //Si tiene mas de dos punteros
            raiz.siguiente = fin.siguiente;
            fin.siguiente.anterior = raiz;
            fin.anterior = raiz.anterior;
            raiz.anterior.siguiente = fin;
        }

        //Actualizo los extremos de los punteros
        raiz.anterior = null;
        fin.siguiente = null;
    }

    public void borrarNodosConValorIgualAlPrimero() {
        if (esListaVacia()) {
            System.out.println("No hay nodos para borrar, la lista está vacía.");
            return;
        }

        Nodo recorrer = raiz.siguiente;

        while (recorrer != null) {
            Nodo siguiente = recorrer.siguiente;

            if (recorrer.info == raiz.info) {
                recorrer.anterior.siguiente = recorrer.siguiente;

                if (recorrer.siguiente != null) {
                    recorrer.siguiente.anterior = recorrer.anterior;
                } 
            }

            recorrer = siguiente;
        }
    }

    public void imprimirLista() {
        if (esListaVacia()) {
            System.out.println("No hay nodos para imprimir, la lista está vacía.");
            return;
        }

        Nodo recorrer = raiz;
        while (recorrer != null) {
            System.out.print(recorrer.info + " <-> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        ListaDoblementeEnlazada lg = new ListaDoblementeEnlazada();

        lg.insertarNodos(10, 20);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();

        lg.insertarNodos(5, 8);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();

        lg.insertarNodos(200, 4);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();

        lg.insertarNodos(1, 2);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();
        
        lg.insertarNodos(200, 99);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();

        lg.insertarNodos(500, 1000);
        System.out.println("Lista después de insertar nodos:");
        lg.imprimirLista();

        System.out.println("Suma de los nodos en posiciones impares: " + lg.sumarValoresEnPosicionesImpares() + "\n");

        lg.borrarPrimerYUltimoNodo();
        System.out.println("Lista después de borrar los nodos:");
        lg.imprimirLista();

        lg.intercambiarPrimerYUltimoNodo();
        System.out.println("Lista después de intercambiar el primer y el último nodo:");
        lg.imprimirLista();

        lg.borrarNodosConValorIgualAlPrimero();
        System.out.println("Lista después de borrar nodos con el mismo valor que el primero:");
        lg.imprimirLista();
    }
}
