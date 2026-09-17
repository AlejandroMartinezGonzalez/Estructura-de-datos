public class ArrayList<T> {
    private Object[] datos;
    private int cantidad;

    public ArrayList() {
        datos = new Object[3];
        cantidad = 0;
    }

    public void agregarElemento(T valor) {
        if (cantidad == datos.length) {
            Object[] nuevo = new Object[datos.length * 2];
            for (int i = 0; i < datos.length; i++) {
                nuevo[i] = datos[i];
            }
            datos = nuevo;
            System.out.println("El arreglo crecio a " + datos.length);

        }
        datos[cantidad] = valor;
        cantidad++;
    }

    public T obtenerValor(int posision) {
        if (posision < 0 || posision >= cantidad) {
            throw new RuntimeException("Posision invalida");
        }
        return (T) datos[posision];
    }

    public void eliminar(int posision) {

        if (posision < 0 || posision >= cantidad) {
            throw new RuntimeException("Posision invalida");
        }
        for (int i = posision; i < cantidad - 1; i++) {
            datos[i] = datos[i + 1];
        }
        cantidad--;
    }

    public int tamanio() {
        return cantidad;
    }

    public void mostrar() {
        System.out.println("[ ");
        for (int i = 0; i < cantidad; i++) {
            System.out.println(datos[i]);
            if (i < cantidad - 1)
                System.out.println(", ");

        }
        System.out.println(" ]");
    }

}