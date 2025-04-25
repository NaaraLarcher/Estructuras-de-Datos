public class ListaDoblementeEnlazada2 {
    class Nodo {
        int valor;
        Nodo siguiente, anterior;
    }

    private Nodo raiz, fin;
    private int tamaño;

    public ListaDoblementeEnlazada2() {
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

    public void insertarAlPrincipio(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;

        nuevo.siguiente = raiz;

        if (raiz != null) {
            raiz.anterior = nuevo;
        } else {
            fin = nuevo;
        }

        raiz = nuevo;

        tamaño++;
    }

    public void insertarFinal(int valor) {
        Nodo nuevo = new Nodo();
        nuevo.valor = valor;
        nuevo.anterior = fin;

        if (fin != null) {
            fin.siguiente = nuevo;    
        } else {
            raiz = nuevo;
        }

        fin = nuevo;

        tamaño++;
    }

    public void insertarSegundaPosicion(int valor) {
        if (listaVacia()) {
            System.out.println("No se puede insertar el nodo");
            return;
        }

        Nodo nuevo = new Nodo();
        nuevo.valor = valor;

        if (tamaño == 1) {
            raiz.siguiente = nuevo;
            nuevo.anterior = raiz;
            nuevo.siguiente = null;
            fin = nuevo;
        } else {
            nuevo.siguiente = raiz.siguiente;
            nuevo.anterior = raiz;
            raiz.siguiente.anterior = nuevo;
            raiz.siguiente = nuevo;
        }

        tamaño++;
    }

    public void insertarPenultimaPosicion(int valor) {
        if (tamaño <= 1) {
            System.out.println("No se puede insertar el nodo");
            return;
        }

        Nodo nuevo = new Nodo();
        nuevo.valor = valor;

        Nodo penultimo = fin.anterior;

        penultimo.siguiente = nuevo;
        nuevo.anterior = penultimo;
        nuevo.siguiente = fin;
        fin.anterior = nuevo;

        tamaño++;
    }

    public void borrarPrimerNodo() {
        if (listaVacia()) {
            System.out.println("La lista está vacía");
            return;
        } 
        if (tamaño == 1) {
            raiz = null;
            fin = null;
        } else {
            raiz = raiz.siguiente;
            raiz.anterior = null;
        }

        tamaño--;
    }

    public void borrarSegundoNodo() {
        if (tamaño <= 1) {
            System.out.println("No existe un segundo nodo para borrar");
            return;
        }

        
        if (tamaño == 2) {
            raiz.siguiente = null;
            fin = raiz;
        } else {
            Nodo segundo = raiz.siguiente;
            Nodo tercero = segundo.siguiente;

            raiz.siguiente = tercero;
            tercero.anterior = raiz;
        }

        tamaño--;
    }

    public void borrarUltimoNodo() {
        if (listaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        if (tamaño == 1) {
            raiz = null;
            fin = null;
        } else {
            Nodo penultimo = fin.anterior;

            penultimo.siguiente = null;
            fin = penultimo;
        }

        tamaño--;
    }

    public void borrarNodoMayor() {
        if (listaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        int may = raiz.valor;
        Nodo actual = raiz.siguiente;

        while (actual != null) {
            if (actual.valor > may) {
                may = actual.valor;
            }
            actual = actual.siguiente;
        }

        Nodo recorrer = raiz;

        while (recorrer != null) {
            if (recorrer.valor == may) {
                // Si el nodo a borrar es el primero
                if (recorrer.anterior == null) {
                    raiz = raiz.siguiente;
                    if (raiz != null) {
                        raiz.anterior = null;
                    } else {
                        fin = null;
                    }
                }
                //Si no es el primero
                else {
                    recorrer.anterior.siguiente = recorrer.siguiente;
                }

                // Si el nodo a borrar es el último
                if (recorrer.siguiente == null) {
                    fin = fin.anterior;
                } else {
                    recorrer.siguiente.anterior = recorrer.anterior;
                }
                break;
            }
            recorrer = recorrer.siguiente;
        }
        
        tamaño--;
    }

    public void imprimir() {
        Nodo actual = raiz;
        while (actual != null) {
            System.out.print(actual.valor + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null\n");
    }

    public static void main(String[] args) {
        ListaDoblementeEnlazada2 lista = new ListaDoblementeEnlazada2();

        // Insertar al principio
        lista.insertarAlPrincipio(10);
        System.out.println("Lista luego de insertar al principio:");
        lista.imprimir();
        lista.insertarAlPrincipio(20);
        System.out.println("Lista luego de insertar al principio:");
        lista.imprimir();
        lista.insertarAlPrincipio(30);
        System.out.println("Lista luego de insertar al principio:");
        lista.imprimir();
        lista.insertarAlPrincipio(40);
        System.out.println("Lista luego de insertar al principio:");
        lista.imprimir();


        // Insertar al final
        lista.insertarFinal(5);
        System.out.println("Lista luego de insertar al final:");
        lista.imprimir();
        lista.insertarFinal(1);
        System.out.println("Lista luego de insertar al final:");
        lista.imprimir();

        // Insertar en segunda posición
        lista.insertarSegundaPosicion(15);
        System.out.println("Lista luego de insertar en la segunda posición:");
        lista.imprimir();

        // Insertar en penúltima posición
        lista.insertarPenultimaPosicion(7);
        System.out.println("Lista luego de insertar en la penúltima posición:");
        lista.imprimir();

        // Mostrar lista
        System.out.println("Lista después de inserciones:");
        lista.imprimir();

        // Borrar primer nodo
        lista.borrarPrimerNodo();
        System.out.println("Lista luego de borrar el primero:");
        lista.imprimir();


        // Borrar segundo nodo
        lista.borrarSegundoNodo();
        System.out.println("Lista luego de borrar el segundo:");
        lista.imprimir();

        // Borrar último nodo
        lista.borrarUltimoNodo();
        System.out.println("Lista luego de borrar el último:");
        lista.imprimir();

        // Borrar nodo mayor
        lista.borrarNodoMayor();
        System.out.println("Lista luego de borrar el mayor:");
        lista.imprimir();
    }
}
