import es.upm.babel.cclib.Producto;
import es.upm.babel.cclib.Almacen;
import es.upm.babel.cclib.Semaphore;

// TODO: importar la clase de los semáforos.

/**
 * Implementación de la clase Almacen que permite el almacenamiento
 * de producto y el uso simultáneo del almacen por varios threads.
 */
class Almacen1 implements Almacen {
   // Producto a almacenar: null representa que no hay producto
   private Producto almacenado = null;

   // TODO: declaración e inicialización de los semáforos
   private static Semaphore producers = new Semaphore(1);
   private static Semaphore consumers = new Semaphore(1);

   public Almacen1() {
   }

   public void almacenar(Producto producto) {
      // TODO: protocolo de acceso a la sección crítica y código de
      // sincronización para poder almacenar.

       producers.await();

      // Sección crítica
      almacenado = producto;

      // TODO: protocolo de salida de la sección crítica y código de
      // sincronización para poder extraer.

       consumers.signal();
   }

   public Producto extraer() {
      Producto result;

      // TODO: protocolo de acceso a la sección crítica y código de
      // sincronización para poder extraer.

       consumers.await();

      // Sección crítica
      result = almacenado;
      almacenado = null;

      // TODO: protocolo de salida de la sección crítica y código de
      // sincronización para poder almacenar.

       producers.signal();

      return result;
   }
}
