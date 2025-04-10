public class ListaGenerica {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    ListaGenerica() {
        raiz = null;
    }

    public boolean listaVacia() {
        return raiz == null;
    }

    public int cantidad() {
        int cantidad = 0;
        Nodo recorrer = raiz;
        while (recorrer != null) {
            cantidad++;
            recorrer = recorrer.siguiente;
        }
        return cantidad;
    }

    public void insertar(int posicion, int valor) {
        if (posicion < 1 || posicion > cantidad() + 1) {
            System.out.println("Posición inválida para insertar.");
            return;
        }
    
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;
    
        if (posicion == 1) {
            // Caso 1: insertar al principio
            nodoNuevo.siguiente = raiz;
            raiz = nodoNuevo;
        } else if (posicion == cantidad() + 1) {
            // Caso 2: insertar al final
            Nodo recorrer = raiz;
            while (recorrer.siguiente != null) {
                recorrer = recorrer.siguiente;
            }
            recorrer.siguiente = nodoNuevo;
            nodoNuevo.siguiente = null;
        } else {
            // Caso 3: insertar en el medio
            Nodo recorrer = raiz;
            for (int i = 1; i < posicion - 1; i++) {
                recorrer = recorrer.siguiente;
            }
    
            nodoNuevo.siguiente = recorrer.siguiente;
            recorrer.siguiente = nodoNuevo;
        }
    }

    public int extraer(int posicion) {
        if (posicion < 1 || posicion > cantidad()) {
            System.out.println("Posición inválida para extraer.");
            return Integer.MAX_VALUE;
        }

        int informacion;
        if (posicion == 1) {
            informacion = raiz.info;
            raiz = raiz.siguiente;
        } else {
            Nodo recorrer = raiz;
            for (int i = 1; i < posicion - 1; i++) {
                recorrer = recorrer.siguiente;
            }
            Nodo proximo = recorrer.siguiente;
            informacion = proximo.info;
            recorrer.siguiente = proximo.siguiente;
        }
        return informacion;
    }

    public void borrar(int posicion) {
        if (posicion < 1 || posicion > cantidad()) {
            System.out.println("Posición inválida para borrar.");
            return;
        }

        if (posicion == 1) {
            raiz = raiz.siguiente;
        } else {
            Nodo recorrer = raiz;
            for (int i = 1; i < posicion - 1; i++) {
                recorrer = recorrer.siguiente;
            }
            recorrer.siguiente = recorrer.siguiente.siguiente;
        }
    }

    public void intercambiar(int posicion1, int posicion2) {
        if (posicion1 < 1 || posicion1 > cantidad() || posicion2 < 1 || posicion2 > cantidad()) {
            System.out.println("Posiciones inválidas para intercambiar.");
            return;
        }

        if (posicion1 == posicion2) return;

        Nodo recorrer1 = raiz;
        for (int i = 1; i < posicion1; i++) {
            recorrer1 = recorrer1.siguiente;
        }

        Nodo recorrer2 = raiz;
        for (int i = 1; i < posicion2; i++) {
            recorrer2 = recorrer2.siguiente;
        }

        int aux = recorrer1.info;
        recorrer1.info = recorrer2.info;
        recorrer2.info = aux;
    }

    public int mayor() {
        if (listaVacia()) return Integer.MAX_VALUE;

        int mayor = raiz.info;
        Nodo recorrer = raiz.siguiente;
        while (recorrer != null) {
            if (recorrer.info > mayor) {
                mayor = recorrer.info;
            }
            recorrer = recorrer.siguiente;
        }
        return mayor;
    }

    public int posMayor() {
        if (listaVacia()) return Integer.MAX_VALUE;

        int mayor = raiz.info;
        int pos = 1;
        int i = 1;
        Nodo recorrer = raiz;

        while (recorrer != null) {
            if (recorrer.info > mayor) {
                mayor = recorrer.info;
                pos = i;
            }
            recorrer = recorrer.siguiente;
            i++;
        }
        return pos;
    }

    public boolean ordenada() {
        if (cantidad() <= 1) return true;

        Nodo actual = raiz;
        while (actual.siguiente != null) {
            if (actual.info > actual.siguiente.info) {
                return false;
            }
            actual = actual.siguiente;
        }
        return true;
    }

    public boolean existe(int valor) {
        Nodo recorrer = raiz;
        while (recorrer != null) {
            if (recorrer.info == valor) return true;
            recorrer = recorrer.siguiente;
        }
        return false;
    }

    public void imprimir() {
        Nodo recorrer = raiz;
        System.out.println("Listado de todos los elementos de la lista:");
        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    static void imprimirMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void main(String[] args) {
        ListaGenerica lista = new ListaGenerica();

        for (int i = 1; i <= 5; i++) {
            lista.insertar(i, i * 10);
        }

        lista.imprimir();
        imprimirMensaje("Luego de borrar el primero:");
        lista.borrar(1);
        lista.imprimir();

        imprimirMensaje("El elemento extraido es: " + lista.extraer(2) + "\n");;
        lista.imprimir();

        imprimirMensaje("Luego de intercambiar el primero con el tercero:");
        lista.intercambiar(1, 3);
        lista.imprimir();

        int valor = 10;
        if (lista.existe(valor)) {
            System.out.println("Se encontró el valor " + valor + " en la lista.");
        } else {
            System.out.println("No se encontró el valor " + valor + " en la lista.");
        }

        System.out.println("La posición del mayor elemento es: " + lista.posMayor());

        if (lista.ordenada()) {
            System.out.println("La lista está ordenada.");
        } else {
            System.out.println("La lista no está ordenada.");
        }
    }
}
