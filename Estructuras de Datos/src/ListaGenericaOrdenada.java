public class ListaGenericaOrdenada {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    ListaGenericaOrdenada() {
        raiz = null;
    }

    public void insertar(int valor) {

        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        if (raiz == null) {
            raiz = nodoNuevo;
        } else if (valor < raiz.info) {
            nodoNuevo.siguiente = raiz;
            raiz = nodoNuevo;
        } else {
            Nodo recorrer = raiz;
            Nodo atras = raiz;

            while (valor >= recorrer.info && recorrer.siguiente != null) {
                atras = recorrer;
                recorrer = recorrer.siguiente;
            }

            if (valor >= recorrer.info) {
                recorrer.siguiente = nodoNuevo;
            } else {
                nodoNuevo.siguiente = recorrer;
                atras.siguiente = nodoNuevo;
            }
        }
    }

    public void imprimir() {
        Nodo recorrer = raiz;

        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        ListaGenericaOrdenada lista = new ListaGenericaOrdenada();

        for (int i = 0; i < 10; i++) {
            lista.insertar((int) (Math.random() * 100));
        }

        lista.imprimir();
    }
}