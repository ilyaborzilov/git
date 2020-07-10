/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package adventuraZaklad_2019.logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída PostavaTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    Ilya Borzilov
 * @version   
 */
public class PostavaTest
{
    
    /***************************************************************************
     * Inicializace předcházející spuštění každého testu a připravující tzv.
     * přípravek (fixture), což je sada objektů, s nimiž budou testy pracovat.
     */
    @Before
    public void setUp()
    {
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestPostavy()
    {
        logika.Postava postava3 = new logika.Postava("Ilya", "Cau");
        assertEquals("Ilya", postava3.getJmeno());
        assertEquals("Cau", postava3.getProslov());
        assertEquals(false, postava3.jeZabity());
    }
}

