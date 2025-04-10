public class Pila {
    
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    Pila() {
        raiz = null;
    }

    public void insertar(int valor) {
        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        if (raiz == null) {
            nodoNuevo.siguiente = null;
            raiz = nodoNuevo;
        }
        else {
            nodoNuevo.siguiente = raiz;
            raiz = nodoNuevo;
        }
    }
        
    public int extraer() {
        if (raiz != null) {
            int informacion = raiz.info;
            raiz = raiz.siguiente;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public int retornar() {
        if (raiz != null) {
            int informacion = raiz.info;
            return informacion;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void imprimir() {

        Nodo recorrer = raiz;
        System.out.println("Listado de todos los elementos de la pila:");

        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public int cantidadNodos() {
        int cantidad = 0;
        Nodo recorrer = raiz;

        while(recorrer != null) {
            cantidad ++;
            recorrer = recorrer.siguiente;
        }

        return cantidad;
    }

    public void inicializarEnCero() {
        Nodo recorrer = raiz;

        while (recorrer != null) {
            recorrer.info = 0;
            recorrer = recorrer.siguiente;
        }
    }

    public int getLastNode() {
        Nodo recorrer = raiz;
        int valorNodo = Integer.MAX_VALUE;
        while (recorrer != null) {
            if (recorrer.siguiente == null) {
                valorNodo = recorrer.info;
            }

            recorrer = recorrer.siguiente;
        }
        return valorNodo;
    }

    public static void main(String[] args) {
        Pila pila1 = new Pila();

        for (int i = 1; i <= 5; i++) {
            int resultado = i * 10;
            pila1.insertar(resultado);
        }

        pila1.imprimir();
        System.out.println("La cantidad de nodos que contiene la lista es: " + pila1.cantidadNodos() + "\n");
        System.out.println("El elemento extraido de la pila es: " + pila1.extraer() + "\n");
        pila1.imprimir();
        System.out.println("El elemento retornado de la pila es: " + pila1.retornar() + "\n");
        pila1.imprimir();  
        System.out.println("La cantidad de nodos que contiene la lista es: " + pila1.cantidadNodos() + "\n");
        System.out.println("El ultimo nodo de la pila es: " + pila1.getLastNode() + "\n");
        pila1.inicializarEnCero();
        pila1.imprimir();
    }
}
