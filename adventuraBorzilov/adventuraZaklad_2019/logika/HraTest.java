package adventuraZaklad_2019.logika;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/*******************************************************************************
 * Testovací třída HraTest slouží ke komplexnímu otestování
 * třídy Hra
 *
 * @author    Ilya Borziov
 * @version  
 */
public class HraTest {
    private Hra hra1;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================
    //-- Testovací třída vystačí s prázdným implicitním konstruktorem ----------

    //== Příprava a úklid přípravku ================================================

    /***************************************************************************
     * Metoda se provede před spuštěním každé testovací metody. Používá se
     * k vytvoření tzv. přípravku (fixture), což jsou datové atributy (objekty),
     * s nimiž budou testovací metody pracovat.
     */
    @Before
    public void setUp() {
        hra1 = new Hra();
    }

    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každé testovací metody.
     */
    @After
    public void tearDown() {
    }

    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void TestPrubehuHry2()
    {
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber svítilna");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi kancelář_ředitele");
        assertEquals("kancelář_ředitele", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber sponka");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi hlavní_hala");
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi technická_místnost");
        assertEquals("technická_místnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("posun_a_otevri sklep");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi sklep");
        assertEquals("sklep", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odeber sponka");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber lahev_Y");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi technická_místnost");
        assertEquals("technická_místnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi hlavní_hala");
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odeber svítilna");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber lahev_X");
        assertEquals(false, hra1.konecHry());
        assertEquals("Vytvořil si jed. Ale pozor, jed je smrtelný!", hra1.zpracujPrikaz("smichej"));
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi bezpečnostní_místnost");
        assertEquals("bezpečnostní_místnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("uspi strážník");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber klič");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi hlavní_hala");
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi kancelář_ředitele");
        assertEquals("kancelář_ředitele", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("odemkni pokoj_se_sejfem");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi pokoj_se_sejfem");
        assertEquals("pokoj_se_sejfem", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(true, hra1.konecHry());
    }
    
    /***************************************************************************
     * Testuje průběh hry, po zavolání každěho příkazu testuje, zda hra končí
     * a v jaké aktuální místnosti se hráč nachází.
     * Při dalším rozšiřování hry doporučujeme testovat i jaké věci nebo osoby
     * jsou v místnosti a jaké věci jsou v batohu hráče.
     * 
     */
    @Test
    public void TestProhra()
    {
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber svítilna");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi kancelář_ředitele");
        assertEquals("kancelář_ředitele", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("seber sponka");
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi hlavní_hala");
        assertEquals("hlavní_hala", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(false, hra1.konecHry());
        hra1.zpracujPrikaz("jdi bezpečnostní_místnost");
        assertEquals("bezpečnostní_místnost", hra1.getHerniPlan().getAktualniProstor().getNazev());
        assertEquals(true, hra1.konecHry());        
    }
}

