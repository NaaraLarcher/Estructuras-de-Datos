public class Cola {
    
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz, fondo;

    Cola() {
        raiz = null;
        fondo = null;
    }

    public boolean colaVacia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(int valor) {
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        if (colaVacia()) {
            raiz = nodoNuevo;
            fondo = nodoNuevo;
        } else {
            fondo.siguiente = nodoNuevo;
            fondo = nodoNuevo;
        }
    }

    public int extraer() {
        if (!colaVacia()) {
            int informacion = raiz.info;
            if (raiz == fondo) {
                raiz = null;
                fondo = null;
            } else {
                raiz = raiz.siguiente;
            }

            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {
        Nodo recorrer = raiz;
        System.out.println("Listado de todos los elementos de la cola:");
        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        Cola cola1 = new Cola();

        for (int i = 1; i <= 5; i++) {
            int resultado = i * 10;
            cola1.insertar(resultado);
        }

        cola1.imprimir();
        System.out.println("El elemento extraido de la cola es: " + cola1.extraer());
        cola1.imprimir();
    }
}
