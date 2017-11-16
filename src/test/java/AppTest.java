import edu.upc.dsa.*;
import org.junit.After;
import org.junit.Before;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.assertEquals;


public class AppTest
{


    @Before
    public void setUp()
    {

        ProductManagerImpl.getInstance();//empieza por defecto con un pedido en la pila
        Producto p1 = new Producto("jamoon", (double)19);
        Producto p2 = new Producto("bebidaa", (double)18);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 5);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

        Usuario u = new Usuario("juanaco");
        Pedido p = new Pedido(u,comandas);

        ProductManagerImpl.getInstance().Hacerpedido(p);
    }

    @After
    public void tearDown()
    {

        ProductManagerImpl.getInstance().reiniciarSingleton();

    }

    @org.junit.Test
    public void añadirPedido()
    {
        Producto p1 = new Producto("pernil", (double)19);
        Producto p2 = new Producto("beguda", (double)18);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 5);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

        Usuario u = new Usuario("juanito");
        Pedido p = new Pedido(u,comandas);

       ProductManagerImpl.getInstance().Hacerpedido(p);


    }

    @org.junit.Test
    public void servirpedido()
    {

        Pedido p =ProductManagerImpl.getInstance().Servirpedido();
        assertEquals(null,ProductManagerImpl.getInstance().Servirpedido());


    }

    @org.junit.Test
    public void listapedidosrealizadousuario()
    {

        Producto p1 = new Producto("pernil", (double)19);
        Producto p2 = new Producto("beguda", (double)18);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 5);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

        Usuario u = new Usuario("juan");
        Pedido producto = new Pedido(u,comandas);
        ProductManagerImpl.getInstance().Hacerpedido(producto);

        Producto p3 = new Producto("pelota", (double)19);
        Producto p4 = new Producto("jamooon", (double)18);

        Comanda c3 = new Comanda(p3, 8);
        Comanda c4 = new Comanda(p4, 3);
        comandas.clear();
        comandas.add(c3);
        comandas.add(c4);
        Pedido producto2 = new Pedido(u,comandas);
        ProductManagerImpl.getInstance().Hacerpedido(producto2);


        ProductManagerImpl.getInstance().listapedidosrealizadousuario("juan");



    }

}
