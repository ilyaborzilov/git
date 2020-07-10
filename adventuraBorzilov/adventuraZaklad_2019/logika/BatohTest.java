/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package adventuraZaklad_2019.logika;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída BatohTest slouží ke komplexnímu otestování třídy ... 
 *
 * @author    Ilya Borzilov
 * @version   
 */
public class BatohTest
{
    
    /**
     * Default constructor for test class BatohTest
     */
    public BatohTest()
    {
    }

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
    public void BatohTest()
    {
        logika.Batoh batoh1 = new logika.Batoh();
        logika.Vec vec1 = new logika.Vec("vec1", true);
        logika.Vec vec2 = new logika.Vec("vec2", true);
        logika.Vec vec3 = new logika.Vec("vec3", true);
        logika.Vec vec4 = new logika.Vec("vec4", true);
        assertEquals(true, batoh1.vlozVec(vec1));
        assertEquals(true, batoh1.vlozVec(vec2));
        assertEquals(false, batoh1.vlozVec(vec3));
        assertEquals(false, batoh1.vlozVec(vec4));  
        assertEquals(2, batoh1.getKapacitaBatohu());
    }
}
