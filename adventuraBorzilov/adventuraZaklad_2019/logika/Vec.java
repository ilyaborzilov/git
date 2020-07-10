package adventuraZaklad_2019.logika;

import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Instance třídy {@code Vec} představují ... 
 *
 * @author    Ilya Borzilov
 * @version   
 */
public class Vec
{
    private String jmeno;
    private boolean prenositelna;
    private Map<String,Vec>seznamVeci;  
    

    /***************************************************************************
     * Konstruktor
     */
    public Vec (String jmeno, boolean prenositelna )  {
        this.jmeno = jmeno;
        this.prenositelna = prenositelna;
        this.seznamVeci = new HashMap<String,Vec>();

    }

    /**
     * Vrací jméno věci
     * 
     * @return jmeno věcí
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * Metoda jePrenositelna
     *
     * @return Návratová hodnota
     */
    public boolean jePrenositelna() {
        return prenositelna;

    }
}
