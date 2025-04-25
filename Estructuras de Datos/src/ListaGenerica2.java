public class ListaGenerica2 {
    class Nodo {
        int info;
        Nodo siguiente;
    }

    private Nodo raiz;

    ListaGenerica2() {
        raiz = null;
    }

    public boolean listaVacia() {
        return raiz == null;
    }

    public int getCantidad() {
        int cantidad = 0;
        Nodo recorrer = raiz;

        while (recorrer != null) {
            cantidad++;
            recorrer = recorrer.siguiente;
        }

        return cantidad;
    }

    public void insertar(int posicion, int valor) {
        if (posicion < 1 || posicion > getCantidad() + 1) {
            System.out.println("Posición inválida para insertar.");
            return;
        }

        Nodo nodoNuevo = new Nodo();
        nodoNuevo.info = valor;

        if (posicion == 1) {
            nodoNuevo.siguiente = raiz;
            raiz = nodoNuevo;

        } else if (posicion == getCantidad() + 1) {
            Nodo recorrer = raiz;
            
            while (recorrer.siguiente != null) {
                recorrer = recorrer.siguiente;
            }

            recorrer.siguiente = nodoNuevo;
            nodoNuevo.siguiente = null;
        } else {
            Nodo recorrer = raiz;
            for (int i = 1; i < posicion - 1; i++) {
                recorrer = recorrer.siguiente;
            }

            nodoNuevo.siguiente = recorrer.siguiente;
            recorrer.siguiente = nodoNuevo;
        }
    }

    public void imprimir() {
        if (listaVacia()) {
            System.out.println("No se puede imprimir. La lista está vacía.");
            return;
        }
        
        Nodo recorrer = raiz;
        System.out.println("Listado de elementos de la lista:");

        while (recorrer != null) {
            System.out.print(recorrer.info + " -> ");
            recorrer = recorrer.siguiente;
        }
        System.out.println("null\n");
    }

    public void insertarAlPrincipio(int valor) {
        insertar(1, valor);
    }

    public void insertarAlUltimo(int valor) {
        int posicion = getCantidad() + 1;
        insertar(posicion, valor);
    }

    public void insertarSegundaPosicion(int valor) {
        if (!listaVacia()) {
            insertar(2, valor);
        } else {
            System.out.println("Lista vacía. No se pudo insertar el nodo en la segunda posición.");
        }
    }
    
    public void insertarPenultimaPosicion(int valor) {
        if (getCantidad() < 2) {
            System.out.println("No se puede insertar en la penultima posicion");
        } else {
            int posicion = getCantidad();
            insertar(posicion, valor);
        }
    }

    public void borrar(int posicion) {
        if (posicion < 1 || posicion > getCantidad()) {
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

    public void borrarPrimerNodo() {
        if (listaVacia()) {
            System.out.print(" No hay primer elemento para borrar.");
        } else {
            borrar(1);
        }
    }

    public void borrarSegundoNodo() {
        if (getCantidad() < 2) {
            System.out.print(" No hay segundo nodo para borrar.");
        } else {
            borrar(2);
        }
    }

    public void borrarUltimoNodo() {
        if (listaVacia()) {
            System.out.print(" No hay elementos para borrar.");
        } else {
            int posicion = getCantidad();
            borrar(posicion);
        }
    }

    public void borrarMayor() {
        if (listaVacia()) {
            System.out.println("La lista está vacía. No se puede borrar el mayor");
            return;
        }

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

        borrar(pos);
    }

    public static void main(String[] args) {
        ListaGenerica2 listaGenerica2 = new ListaGenerica2();

        for (int i = 1; i <= 10; i++) {
            int resultado = i * 10;
            listaGenerica2.insertar(i, resultado);
        }

        listaGenerica2.imprimir();
        listaGenerica2.insertarAlPrincipio(333);
        listaGenerica2.imprimir();
        listaGenerica2.insertarAlUltimo(999);
        listaGenerica2.imprimir();
        listaGenerica2.insertarSegundaPosicion(666);
        listaGenerica2.imprimir();
        listaGenerica2.insertarPenultimaPosicion(555);
        listaGenerica2.imprimir();
        listaGenerica2.borrarPrimerNodo();
        listaGenerica2.imprimir();
        listaGenerica2.borrarSegundoNodo();
        listaGenerica2.imprimir();
        listaGenerica2.borrarUltimoNodo();
        listaGenerica2.imprimir();
        listaGenerica2.borrarMayor();
        listaGenerica2.imprimir();

        while (!listaGenerica2.listaVacia()) {
            listaGenerica2.borrar(1);
        }        

        listaGenerica2.imprimir();
        listaGenerica2.insertarSegundaPosicion(2);

    }
}
