public class ListaDoblementeEnlazada {
    class Nodo {
        int valor;
        Nodo siguiente, anterior;
    }

    private Nodo raiz, fin; 
    private int tamaño;

    public ListaDoblementeEnlazada() {
        raiz = null;
        fin = null;
        tamaño = 0;
    }

    public boolean listaVacia() {
        return tamaño == 0;
    }

    public int cantidad() {
        return tamaño;
    }

    // Inserta un nodo en la posición indicada (comienza en 1)
    public void insertar(int posicion, int valor) {
        if (posicion < 1 || posicion > tamaño + 1) {
            System.out.println("Posición inválida.");
            return;
        }

        Nodo nuevo = new Nodo();
        nuevo.valor = valor;

        // Insertar al principio
        if (posicion == 1) {
            nuevo.siguiente = raiz;
            if (raiz != null) {
                raiz.anterior = nuevo;
            } else {
                fin = nuevo; // Si estaba vacía, el nuevo nodo es también el fin
            }
            raiz = nuevo;
        }
        // Insertar al final
        else if (posicion == tamaño + 1) {
            nuevo.anterior = fin;
            if (fin != null) {
                fin.siguiente = nuevo;
            } else {
                raiz = nuevo; // Si estaba vacía, el nuevo nodo es también la raíz
            }
            fin = nuevo;
        }
        // Insertar en el medio
        else {
            Nodo actual = raiz;
            for (int i = 1; i < posicion - 1; i++) actual = actual.siguiente;

            nuevo.siguiente = actual.siguiente;
            nuevo.anterior = actual;

            actual.siguiente.anterior = nuevo;
            actual.siguiente = nuevo;
        }

        tamaño++;
    }

    public int extraer(int posicion) {
        if (posicion < 1 || posicion > tamaño) {
            System.out.println("Posición inválida para extraer.");
            return Integer.MAX_VALUE;
        }

        Nodo actual;
        int valorExtraido;

        // Extraer el primero
        if (posicion == 1) {
            actual = raiz;
            valorExtraido = actual.valor;
            raiz = raiz.siguiente;
            if (raiz != null) {
                raiz.anterior = null;
            } else {
                fin = null; // Lista queda vacía
            }
        }
        // Extraer cualquier otro
        else {
            actual = raiz;
            for (int i = 1; i < posicion; i++) {
                actual = actual.siguiente;
            }

            valorExtraido = actual.valor;
            actual.anterior.siguiente = actual.siguiente;

            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual.anterior;
            } else {
                fin = actual.anterior; // Era el último
            }
        }

        tamaño--;
        return valorExtraido;
    }

    public void borrar(int posicion) {
        extraer(posicion); 
    }

    public void intercambiar(int pos1, int pos2) {
        if (pos1 < 1 || pos1 > tamaño || pos2 < 1 || pos2 > tamaño || pos1 == pos2) {
            return;
        }

        Nodo nodo1 = raiz, nodo2 = raiz;
        for (int i = 1; i < pos1; i++) nodo1 = nodo1.siguiente;
        for (int i = 1; i < pos2; i++) nodo2 = nodo2.siguiente;

        int temp = nodo1.valor;
        nodo1.valor = nodo2.valor;
        nodo2.valor = temp;
    }

    public int mayor() {
        if (listaVacia()) return Integer.MAX_VALUE;

        int may = raiz.valor;
        Nodo actual = raiz.siguiente;
        while (actual != null) {
            if (actual.valor > may) may = actual.valor;
            actual = actual.siguiente;
        }
        return may;
    }

    public int posMayor() {
        if (listaVacia()) return Integer.MAX_VALUE;

        int may = raiz.valor;
        int pos = 1, contador = 1;
        Nodo actual = raiz.siguiente;

        while (actual != null) {
            contador++;
            if (actual.valor > may) {
                may = actual.valor;
                pos = contador;
            }
            actual = actual.siguiente;
        }
        return pos;
    }

    public boolean ordenada() {
        if (tamaño < 2) return true;

        Nodo actual = raiz;
        while (actual.siguiente != null) {
            if (actual.valor > actual.siguiente.valor) {
                return false;
            }
            actual = actual.siguiente;
        }
        return true;
    }

    public boolean existe(int x) {
        Nodo actual = raiz;
        while (actual != null) {
            if (actual.valor == x) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    public void imprimir() {
        Nodo actual = raiz;
        while (actual != null) {
            System.out.print(actual.valor + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] ar) {
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();

        lista.insertar(1, 10);
        lista.insertar(2, 20);
        lista.insertar(3, 30);
        lista.insertar(2, 15);
        lista.insertar(1, 115);

        lista.imprimir();

        System.out.println("Luego de borrar el primero:");
        lista.borrar(1);
        lista.imprimir();

        System.out.println("Valor extraido: " + lista.extraer(2));
        System.out.println("Luego de extraer el segundo:");
        lista.imprimir();

        System.out.println("Luego de intercambiar el primero con el tercero:");
        lista.intercambiar(1, 3);
        lista.imprimir();

        if (lista.existe(10)) {
            System.out.println("Se encuentra el 10 en la lista\n");
        } else {
            System.out.println("No se encuentra el 10 en la lista\n");
        }

        System.out.println("El mayor es: " + lista.mayor());
        System.out.println("La posición del mayor es: " + lista.posMayor() + "\n");

        if (lista.ordenada()) {
            System.out.println("La lista está ordenada de menor a mayor");
        } else {
            System.out.println("La lista no está ordenada de menor a mayor");
        }
    }
}
