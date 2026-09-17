
public class MiListaEnlazada<T> {

    private Nodo<T> primero;
    private int cantidad;

    public MiListaEnlazada() {
        primero = null;
        cantidad = 0;
    }

    public void agregar(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (primero == null) {
            primero = nuevo;
        } else {

            Nodo<T> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new RuntimeException("Posición inválida: " + posicion);
        }
        Nodo<T> actual = primero;
        for (int i = 0; i < posicion; i++) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    
    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= cantidad) {
            throw new RuntimeException("Posición inválida: " + posicion);
        }

        if (posicion == 0) {
            primero = primero.siguiente;
        } else {
            
            Nodo<T> anterior = primero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.siguiente;
            }
            
            anterior.siguiente = anterior.siguiente.siguiente;
        }
        cantidad--;
    }

    public int tamanio() {
        return cantidad;
    }

    public void mostrar() {
        System.out.print("[");
        Nodo<T> actual = primero;
        while (actual != null) {
            System.out.print(actual.valor);
            if (actual.siguiente != null)
                System.out.print(" -> ");
            actual = actual.siguiente;
        }
        System.out.println("]");
    }
}