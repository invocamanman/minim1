import edu.upc.dsa.*;
import org.junit.After;
import org.junit.Before;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Vector;

import static org.junit.Assert.assertEquals;


public class AppTest
{

    //ProductManagerImpl p =ProductManagerImpl.getInstance();
    @Before
    public void setUp()
    {
        ProductManagerImpl.getInstance();//em``ieza por defecto con un pedido en la pila
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

       //comrpavar cosas
    }

    @org.junit.Test
    public void servirpedido()
    {

        Pedido p =ProductManagerImpl.getInstance().Servirpedido();
        assertEquals(null,ProductManagerImpl.getInstance().Servirpedido());

        //comrpavoar cosas
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
        Pedido p = new Pedido(u,comandas);
        ProductManagerImpl.getInstance().Hacerpedido(p);


        ArrayList<Pedido> a = ProductManagerImpl.getInstance().listapedidosrealizadousuario("juan");

        //comrpavoar cosas
    }

}
