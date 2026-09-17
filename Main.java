public class Main {
    public static void main(String[] args) {

        System.out.println("===== PRUEBAS ArrayList<String> =====\n");

        MiListaEnlazada<String> nombres = new MiListaEnlazada();

        System.out.println(" Casos positivos:");
        nombres.agregar("Ana");
        nombres.agregar("Luis");
        nombres.agregar("Pedro");
        System.out.print("Después de agregar 3 nombres: ");
        nombres.mostrar();

        nombres.agregar("María");
        System.out.print("Después de agregar 'María': ");
        nombres.mostrar();

        System.out.println("Elemento en posición 1: " + nombres.obtener(1));
        System.out.println("Tamaño actual: " + nombres.tamanio());

        nombres.eliminar(0);
        System.out.print("Después de eliminar posición 0: ");
        nombres.mostrar();

        System.out.println("\n Casos de error:");
        try {
            nombres.obtener(99);
        } catch (RuntimeException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
        }

        try {
            nombres.eliminar(-1);
        } catch (RuntimeException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
        }


        System.out.println("\n\n===== PRUEBAS MiListaEnlazada<String> =====\n");

        MiListaEnlazada<String> enlazada = new MiListaEnlazada();

        System.out.println(" Casos positivos:");
        enlazada.agregar("Rojo");
        enlazada.agregar("Verde");
        enlazada.agregar("Azul");
        System.out.print("Después de agregar 3 colores: ");
        enlazada.mostrar();

        System.out.println("Elemento en posición 0: " + enlazada.obtener(0));
        System.out.println("Elemento en posición 2: " + enlazada.obtener(2));
        System.out.println("Tamaño actual: " + enlazada.tamanio());

        enlazada.eliminar(0);
        System.out.print("Después de eliminar posición 0: ");
        enlazada.mostrar();

        enlazada.eliminar(1);
        System.out.print("Después de eliminar posición 1: ");
        enlazada.mostrar();

        System.out.println("\n Casos de error:");
        try {
            enlazada.obtener(10);
        } catch (RuntimeException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
        }

        try {
            enlazada.eliminar(50);
        } catch (RuntimeException e) {
            System.out.println("ERROR capturado: " + e.getMessage());
        }
        System.out.println("\n===== FIN =====");
    }
}