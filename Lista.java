import java.util.ArrayList;
import java.util.List;

public class Lista {
    protected Nodo inicio, fin;

    public Lista() {
        inicio = null;
        fin = null;
    }

    public Lista(int[] elementos) {
        inicio = null;
        fin = null;
        for (int elemento : elementos) {
            insertarAlFinal(elemento);
        }
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertarAlFinal(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (vacia()) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
    }

    public List<Integer> obtenerListaInversa() {
        List<Integer> listaInversa = new ArrayList<>();
        Nodo actual = inicio;

        while (actual != null) {
            listaInversa.add(0, actual.dato); // Agregar al principio de la lista
            actual = actual.siguiente;
        }

        return listaInversa;
    }

    public List<Integer> encontrarElementosRepetidos() {
        List<Integer> elementosRepetidos = new ArrayList<>();
        List<Integer> elementosVistos = new ArrayList<>();

        Nodo actual = inicio;

        while (actual != null) {
            int dato = actual.dato;

            // Si ya hemos visto este elemento, y aún no lo hemos agregado a la lista de
            // repetidos, agrégalo.
            if (elementosVistos.contains(dato) && !elementosRepetidos.contains(dato)) {
                elementosRepetidos.add(dato);
            }

            elementosVistos.add(dato);
            actual = actual.siguiente;
        }

        return elementosRepetidos;
    }

    public boolean insertarDespuesDe(int elementoExistente, int elementoNuevo) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato == elementoExistente) {
                Nodo nuevoNodo = new Nodo(elementoNuevo, actual.siguiente);
                actual.siguiente = nuevoNodo;
                if (actual == fin) {
                    fin = nuevoNodo;
                }
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public double calcularPromedio() {
        if (vacia()) {
            return 0; // Lista vacía, promedio es 0.
        }

        Nodo actual = inicio;
        int suma = 0;
        int contador = 0;

        while (actual != null) {
            suma += actual.dato;
            contador++;
            actual = actual.siguiente;
        }

        return (double) suma / contador;
    }

    public void eliminarNodoMaximo() {
        if (vacia()) {
            System.out.println("La lista está vacía. No se puede eliminar ningún nodo.");
            return;
        }

        Nodo actual = inicio;
        Nodo anterior = null;
        int maxValor = inicio.dato;

        while (actual != null) {
            if (actual.dato > maxValor) {
                maxValor = actual.dato;
            }

            actual = actual.siguiente;
        }

        actual = inicio;

        while (actual != null) {
            if (actual.dato == maxValor) {
                if (anterior == null) {
                    eliminarInicio();
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual == fin) {
                        fin = anterior;
                    }
                }
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }

    public void eliminarElementosMayoresQue(int limite) {
        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.dato > limite) {
                if (anterior == null) {
                    eliminarInicio();
                    actual = inicio;
                } else {
                    anterior.siguiente = actual.siguiente;
                    if (actual == fin) {
                        fin = anterior;
                    }
                    actual = actual.siguiente;
                }
            } else {
                anterior = actual;
                actual = actual.siguiente;
            }
        }
    }

    public void mostrarLista() {
        Nodo recorrido = inicio;
        while (recorrido != null) {
            System.out.print("[" + recorrido.dato + "]-->");
            recorrido = recorrido.siguiente;
        }
        System.out.println("null");
    }

    public int eliminarInicio() {
        if (vacia()) {
            System.out.println("La lista está vacía. No se puede eliminar el nodo al inicio.");
            return -1;
        }

        int elementoEliminado = inicio.dato;

        if (inicio == fin) {
            inicio = fin = null;
        } else {
            inicio = inicio.siguiente;
        }

        return elementoEliminado;
    }

    public int eliminarFinal() {
        int e = fin.dato;
        if (inicio == fin) {
            inicio = fin = null;
        } else {
            Nodo recorrer = inicio;
            while (recorrer.siguiente != fin) {
                recorrer = recorrer.siguiente;
            }
            fin = recorrer;
            fin.siguiente = null;
        }
        return e;
    }
}
