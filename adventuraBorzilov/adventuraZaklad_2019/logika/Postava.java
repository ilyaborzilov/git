package adventuraZaklad_2019.logika;
import java.util.*;

/**
 * Trida Postava - popisuje jednotlivé postavy hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Postava" reprezentuje jednu postavu ve scénáři hry.
 * S Postavou mozno mluvit, sebrat od ni veci.
 * @author    Ilya Borzilov  
 * @version   
 */
public class Postava
{
    private String jmeno;
    private String proslov;
    private boolean zabity;
     private Vec vec;
    /**
     *  Metoda vloží jmeno a slova postavě.
     */
    public Postava(String jmeno, String proslov){
        this.jmeno = jmeno;
        this.proslov = proslov;
    }

    /**
     * Metoda vrací jméno postavy.
     * 
     * @return   String jméno postavy.
     */
    public String getJmeno() {
        return jmeno; 
    }

    /**
     * Metoda vrací slova postavy.
     * 
     * @return   String slova postavy.
     */
    public String getProslov() {
        return proslov; 
    }
    
    /**
     * Metoda setMrtvy
     * zabije postavu
     *
     * @param mrtvy Parametr
     */
    public void setZabity(boolean zabity)
    {
        this.zabity = zabity;
    }

    /**
     * Metoda jeMrtvy
     * vrací je-li postava mrtvá
     *
     * @return Návratová hodnota
     */
    public boolean jeZabity()
    {
        return zabity;
    }

    /**
     * Metoda setVec
     * nastaví věc postavě, aby po smrtí jí mohla vložit do prostoru
     *
     * @param vec Parametr
     */
    public void setVec(Vec vec)
    {
        this.vec = vec;
    }

    /**
     * Metoda dropVec
     * vrací věc potřebnou pro "odeber"
     *
     * @return Návratová hodnota
     */
    public Vec odeberVec()
    {
        return vec;
    }

    
}

