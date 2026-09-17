## Alejandro Martinez Gonzalez
## Proyecto: ArrayList y MiListaEnlazada con datos Genéricos



##  Contenido del proyecto

| Archivo | Descripción |
|---|---|
| `ArrayList.java` | Lista basada en un arreglo dinámico |
| `MiListaEnlazada.java` | Lista basada en nodos enlazados |
| `Main.java` | Punto de entrada con todas las pruebas |
| `README.md` | Este documento |
| `Nodo.java` | La clase nodo |
---

## Objetivo

Entender cómo funcionan por dentro dos de las estructuras más usadas
en Java (`ArrayList` y `LinkedList`), implementándolas desde cero
y probando su comportamiento con **casos positivos** y **casos de error**.


##  `MiListaEnlazada<T>` — Lista basada en arreglo


Usa un **arreglo** (`Object[]`) que **crece al doble** cuando se llena.
El acceso a cualquier posición es **directo** (rápido).

###  Métodos principales

| Método | ¿Qué hace? |
|---|---|
| `agregar(T valor)` | Añade un elemento al final |
| `obtener(int posicion)` | Devuelve el elemento en esa posición |
| `eliminar(int posicion)` | Quita el elemento y desplaza los siguientes |
| `tamanio()` | Devuelve cuántos elementos hay |
| `mostrar()` | Imprime el contenido en consola |

###  Representación visual

```
datos = [10, 20, 30, null, null, null]
cantidad = 3  solo los primeros 3 cuentan
```

Cuando `cantidad == datos.length`:

```
Antes:  [1, 2, 3]
         crece al doble
Después:[1, 2, 3, null, null, null]
```

###  Fragmento clave: crecimiento dinámico

```java
if (cantidad == datos.length) {
    Object[] nuevo = new Object[datos.length * 2];   
    for (int i = 0; i < datos.length; i++) {
        nuevo[i] = datos[i];                          
    }
    datos = nuevo;
}
```

###  Fragmento clave: eliminar con desplazamiento

```
Antes:  [10, 20, 30, 40]
eliminar(1)
Después:[10, 30, 40]      ← 30 y 40 se mueven a la izquierda
```

```java
for (int i = posicion; i < cantidad - 1; i++) {
    datos[i] = datos[i + 1];
}
cantidad--;
```

---

##  `MiListaEnlazada<T>` — Lista de nodos enlazados

###  Idea

Cada elemento es un **Nodo** que guarda:
- Un **valor** de tipo `T`.
- Una **referencia** al siguiente nodo.

No hay índices reales: para llegar a la posición 5 hay que
**recorrer** los nodos anteriores.

###  Métodos principales

| Método | ¿Qué hace? |
|---|---|
| `agregar(T valor)` | Añade un nodo al final |
| `obtener(int posicion)` | Recorre hasta esa posición y devuelve el valor |
| `eliminar(int posicion)` | Reconecta los nodos saltando el eliminado |
| `tamanio()` | Devuelve cuántos nodos hay |
| `mostrar()` | Imprime los nodos con flechas `->` |

###  Representación visual

```
primero
  ↓
[5] -> [15] -> [25] -> null
```

Cada nodo es como una cajita que sabe dónde está la siguiente:

```java
public class Nodo<T> {
    T valor;
    Nodo<T> siguiente;
}
```

###  Fragmento clave: agregar al final

```java
Nodo<T> actual = primero;
while (actual.siguiente != null) {
    actual = actual.siguiente;   
}
actual.siguiente = nuevo;         
```

###  Fragmento clave: eliminar saltando el nodo

```
Antes:  [5] -> [15] -> [25]
eliminar(1)          (el 15)
Después:[5] ---------> [25]      ← el 5 ahora apunta al 25
```

```java
Nodo<T> anterior = primero;
for (int i = 0; i < posicion - 1; i++) {
    anterior = anterior.siguiente;
}
```

##  Pruebas: casos positivos y de error

En `Main.java` se ejecutan dos tipos de pruebas:

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

| Prueba | ¿Qué se espera? |
|---|---|
| `obtener(99)` en lista pequeña | `RuntimeException` |
| `obtener(-1)` | `RuntimeException` |
| `eliminar(50)` | `RuntimeException` |
| `obtener(10)` en lista vacía | `RuntimeException` |


##  Conclusión

- Se implementaron **dos estructuras de datos** desde cero.
- Se usaron **genéricos `<T>`** para que sirvan con cualquier tipo.
- Se probaron con **casos positivos** (todo bien) y **casos de error** (`try/catch`).
- Se entendió la diferencia real entre un **arreglo dinámico** y una **lista enlazada**.


