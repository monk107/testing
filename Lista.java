public class App {
    public static void main(String[] args) {

        int x=100;
        int y=250;
        int z=x+y;
        // 2048
  
        System.out.println("Sum of x+y = " + z);
    }
}

abstract class Vendedor {
 String ciudad;
 Item[] inventario;
 int maxItems;
 double impuesto;
 abstract void agregarItem(Item item);
 abstract void venderItem(int index);
}
class Campesino extends Vendedor {
 Campesino() {
 this.maxItems = 5;
 this.impuesto = 0.02;
 this.inventario = new Item[this.maxItems];
 }
 @Override
 void agregarItem(Item item) {
 // Implementar lógica para agregar item
 item.desgaste += 0.15;
 }
 @Override
 void venderItem(int index) {
 // Implementar lógica para vender item
 }
}
class Ladron extends Vendedor {
 Ladron() {
 this.maxItems = 3;
 this.impuesto = 0;
 this.inventario = new Item[this.maxItems];
 }
 @Override
 void agregarItem(Item item) {
 // Implementar lógica para agregar item
 item.desgaste += 0.25;
 }
 @Override
 void venderItem(int index) {
 // Implementar lógica para vender item
 }
}
class Mercader extends Vendedor {
 Mercader() {
 this.maxItems = 7;
 this.impuesto = 0.04;
 this.inventario = new Item[this.maxItems];
 }
 @Override
 void agregarItem(Item item) {
 // Implementar lógica para agregar item
 }
 @Override
 void venderItem(int index) {
 // Implementar lógica para vender item
 }
}
class Item {
 String nombre;
 String tipo;
 double precio;
 double desgaste;
}



Primero, podrías crear una clase abstracta llamada Vendedor que represente a un personaje no jugable que
puede vender ítems. Esta clase tendría los siguientes atributos:
nombre: el nombre del vendedor.
ciudad: la ciudad donde se encuentra el vendedor.
inventario: un arreglo de ítems que el vendedor tiene para vender.
maxItems: el número máximo de ítems que el vendedor puede tener en su inventario.
impuesto: el porcentaje de impuesto que el vendedor cobra sobre el precio original de los ítems.
Además, esta clase tendría los siguientes métodos:
Vendedor(String nombre, String ciudad, int maxItems, double impuesto): el constructor de la clase,
que recibe los valores de los atributos como parámetros e inicializa el inventario como un arreglo vacío.
void agregarItem(Item item): un método abstracto que permite añadir un ítem al inventario del
vendedor, aplicando el desgaste correspondiente según el tipo de vendedor.
void mostrarInventario(): un método que imprime el nombre, el tipo, el precio y el desgaste de cada
ítem en el inventario del vendedor.
Item venderItem(int indice): un método que recibe el índice de un ítem en el inventario y lo devuelve,
eliminándolo del inventario. Si el índice es inválido, devuelve null.
Luego, podrías crear tres clases que hereden de la clase Vendedor: Campesino, Ladron y Mercader. Cada
una de estas clases tendría que implementar el método agregarItem(Item item) de forma diferente, según las
especificaciones del problema. Por ejemplo, el método agregarItem(Item item) de la clase Campesino podría
ser algo así:
public void agregarItem(Item item) {
 // Si el inventario está lleno, no se puede agregar el ítem
 if (inventario.length == maxItems) {
 System.out.println("No hay espacio para más ítems.");
 return;
 }
 // Se crea una copia del ítem para no modificar el original
 Item copia = new Item(item.getNombre(), item.getTipo(), item.getPrecio(), item.getDesgaste());
 // Se aplica el desgaste del 15% al ítem
 copia.setDesgaste(copia.getDesgaste() * 0.85);
 // Se agrega el ítem al inventario
 inventario[inventario.length] = copia;
 // Se imprime un mensaje de confirmación
 System.out.println("Se ha agregado el ítem " + copia.getNombre() + " al inventario.");
}
Finalmente, podrías crear una clase llamada Item que represente a un objeto que puede ser vendido por un
vendedor. Esta clase tendría los siguientes atributos:
nombre: el nombre del ítem.
tipo: el tipo del ítem, por ejemplo, arma, armadura, poción, etc.
precio: el precio original del ítem, sin impuestos.
desgaste: el porcentaje de desgaste del ítem, que afecta su calidad y valor.
Además, esta clase tendría los siguientes métodos:
Item(String nombre, String tipo, double precio, double desgaste): el constructor de la clase, que
recibe los valores de los atributos como parámetros.
getNombre(): un método que devuelve el nombre del ítem.
getTipo(): un método que devuelve el tipo del ítem.
getPrecio(): un método que devuelve el precio original del ítem.
getDesgaste(): un método que devuelve el porcentaje de desgaste del ítem.
setDesgaste(double desgaste): un método que recibe un nuevo valor de desgaste y lo asigna al atributo
desgaste del ítem.
getPrecioFinal(double impuesto): un método que recibe el impuesto de un vendedor y devuelve el
precio final del ítem, aplicando el desgaste y el impuesto. Por ejemplo, si el precio original es 100, el
desgaste es 0.8 y el impuesto es 0.04, el precio final sería 100 * 0.8 * 1.04 = 83.2.
Espero que estas ideas te sirvan de ayuda para empezar a programar los vendedores de tu juego de rol. Si
necesitas más ayuda, puedes consultar algunos recursos en línea como [este tutorial de Java] o [esta guía de
herencia y polimorfismo].




Nos piden que programemos los NPCs (Vendedores) de un juego de rol. Existen tres categorías de NPCs: Campesino, Ladrón y Mercader.
El campesino tiene hasta 5 ítems para vender y al precio original le agrega un impuesto del 2%. El ladrón, hasta 3 y no cobra impuestos. El mercader, hasta 7 y cobra un 4% de impuestos. Cada NPC está ubicado en una ciudad. Los ítems tienen un nombre, un tipo, un precio y porcentaje de desgaste. Cuando un ladrón agrega un ítem a su inventario este se deteriora un 25%. Cuando lo hace un campesino, un 15%. En cambio, un mercader conoce muy bien cómo guardar sus ítems para que no se estropeen.

La aplicación permite:

1 - Crear un vendedor.
2 - Añadir un item al inventario de un vendedor.
3 - Consultar los ítems de un vendedor.
4 - Realizar la venta de un ítem.

