## Alejandro Martinez Gonzalez
## Proyecto: ArrayList y MiListaEnlazada con datos Genéricos



##  Contenido del proyecto

 Archivo  Descripción 

 `ArrayList.java`  Lista basada en un arreglo dinámico 
 `MiListaEnlazada.java`  Lista basada en nodos enlazados 
 `Main.java`  Punto de entrada con todas las pruebas 
 `README.md` Este documento 
 `Nodo.java`  La clase nodo 
---

##  `MiArrayList<T>` — Lista basada en arreglo


Usa un **arreglo** Object[] que **crece al doble** cuando se llena.
El acceso a cualquier posición es **directo**.

###  Métodos principales

`agregar(T valor)`  Añade un elemento al final 
`obtener(int posicion)`  Devuelve el elemento en esa posición 
`eliminar(int posicion)`  Quita el elemento y desplaza los siguientes 
`tamanio()`  Devuelve cuántos elementos hay 
`mostrar()` Imprime el contenido en consola 

##  `MiListaEnlazada<T>` — Lista de nodos enlazados

###  Métodos principales

 `agregar(T valor)`  Añade un nodo al final 
 `obtener(int posicion)` Recorre hasta esa posición y devuelve el valor 
 `eliminar(int posicion)`  Reconecta los nodos saltando el eliminado 
 `tamanio()`  Devuelve cuántos nodos hay 
 `mostrar()`  Imprime los nodos con flechas 


###  Casos positivos

Verifican que **la operación normal funcione**:

```java
lista.agregar(10);
lista.agregar(20);
System.out.println(lista.obtener(1));
```

###  Casos de error

Verifican que el código **rechace correctamente** usando try catch

```java
try {
    lista.obtener(99);                
} catch (RuntimeException e) {
    System.out.println("ERROR: " + e.getMessage());
}
```


### Casos de error cubiertos

 Prueba 

 `obtener(99)` en lista pequeña  `RuntimeException` 
 `obtener(-1)`  `RuntimeException` 
 `eliminar(50)`  `RuntimeException` 
 `obtener(10)` en lista vacía  `RuntimeException` 


##  Conclusión

- Se implementaron **dos estructuras de datos** desde cero.
- Se usaron **genéricos `<T>`** para que sirvan con cualquier tipo.
- Se probaron con **casos positivos** (todo bien) y **casos de error** (`try/catch`).
- Se entendió la diferencia real entre un **arreglo dinámico** y una **lista enlazada**.

## <3 GRACIAS POR LEER
