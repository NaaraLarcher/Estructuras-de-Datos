public class Cola2 {
    
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    Cola2() {
        raiz = null;
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
        Nodo recorrer = raiz;

        if (colaVacia()) {
            raiz = nodoNuevo;
            raiz.siguiente = null;
        } else {
            while (recorrer.siguiente != null) {
                recorrer = recorrer.siguiente;
            }
            recorrer.siguiente = nodoNuevo;
        }
    }
    

    public int extraer() {
        if (!colaVacia()) {
            int informacion = raiz.info;
            if (raiz.siguiente == null) {
                raiz = null;
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

    public int retornar() {
        if (!colaVacia()) {
            int informacion = raiz.info;
            if (raiz.siguiente == null) {
                raiz = null;
            } 

            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }
    
    public static void main(String[] args) {
        Cola2 cola1 = new Cola2();

        for (int i = 1; i <= 5; i++) {
            int resultado = i * 10;
            cola1.insertar(resultado);
        }

        cola1.imprimir();
        System.out.println("El elemento extraido de la cola es: " + cola1.extraer() + "\n");
        cola1.imprimir();
        System.out.println("El elemento retornado de la cola es: " + cola1.retornar() + "\n");
        cola1.imprimir();
    }
}
