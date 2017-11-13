import edu.upc.dsa.*;
import org.junit.After;
import org.junit.Before;

import java.util.Vector;


public class AppTest
{

    //ProductManagerImpl p =ProductManagerImpl.getInstance();
    @Before
    public void setUp()
    {

    }

    @After
    public void tearDown()
    {

        ProductManagerImpl.getInstance().reiniciarSingleton();
    }

    @org.junit.Test
    public void añadirUsuario()
    {
        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

       ProductManagerImpl.getInstance().Hacerpedido("juan", comandas);
    }

    @org.junit.Test
    public void servirpedido()
    {
        Producto p1 = new Producto("bocata", (double)12);
        Producto p2 = new Producto("beguda", (double)13);

        Comanda c1 = new Comanda(p1, 10);
        Comanda c2 = new Comanda(p2, 20);
        Vector<Comanda> comandas = new Vector<Comanda>();
        comandas.add(c1);
        comandas.add(c2);

        ProductManagerImpl.getInstance().Hacerpedido("juan", comandas);
        ProductManagerImpl.getInstance().Servirpedido();
    }

}
