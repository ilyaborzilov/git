package adventuraZaklad_2019.logika;

import java.util.*;

/**
 * Trida Batoh - popisuje batohu.
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Batoh" reprezentuje jedno pojeti ve scénáři hry.
 * Batoh slouzi pro ukladani veci a prenosu veci mezi prostory.
 *
* @author    Ilya Borzilov 
 * @version   
 */
public class Batoh  
{
    private Map< String, Vec> seznamVeci;
    private static final int KAPACITA = 2 ; // zadává kapacitů batohu

    /***************************************************************************
     * Konstruktor seznam věci v batohu
     */
    public Batoh(){
        seznamVeci = new HashMap<>();
    }

    /**
     * Metoda najde věc, kterou chceme získat
     * @return věc
     */
    public Vec getVec(String jmeno) {
        return seznamVeci.get(jmeno);
    }

    /**
     * Metoda najde věc, kterou chceme získat
     * @return věc
     */
    public Map getSeznamVeci() {
        return seznamVeci;
    }

    /**
     * Zjišťuje, zda je v batohu ještě místo.
     * 
     * @return  true   -pokud místo je.
     */
    public boolean jeMisto() {
        if (seznamVeci.size() < KAPACITA) {
            return true;   
        }        
        return false; //pokud v batohu už není volné místo 
    }

    /**
     * Metoda pro vložení věci.
     * 
     * @param   vec    vkládaná věc
     * @return  Vec    vrátí tu samou věc, pokud se ji podaří přidat do batohu.
     *                 Null, pokud ne.
     */
    public boolean  vlozVec(Vec vec) {
        if ((vec.jePrenositelna()&&(seznamVeci.size() < KAPACITA))) {
            seznamVeci.put(vec.getJmeno(), vec);
            return true;
        }
        return false;// pokud není výplněná nějaká podminka
    }
    
    public void vlozJed(Vec vec)
    {
        seznamVeci.put("jed",vec);
    }
    
    /**
     * Vypíše kapacitu batohu
     */
    public int getKapacitaBatohu() {
        return KAPACITA;
    }

    /**
     *  Metoda zjišťuje, zda se daná věc vyskytuje v batohu.
     *  
     *  @param  vec  Parametrem je věc, na kterou se ptáme.
     */   
    public boolean obsahujeVec (String jmeno) {
        if (this.seznamVeci.containsKey(jmeno)) {
            return true;
        }
        return false;
    }    

    /**
     * Vypíše věci, které jsou v batohu
     */
    public String jmenoVeciVBatohu() {
        String jmeno = "Věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()){
            jmeno += jmenoVeci + " ";
        }
        return jmeno;

    }
    
   
    /**
     * Metoda najde věc, na kterou chceme odkázat.
     * 
     * @param nazev      -název věci, kterou chceme najít
     * @return hledana
     * Odstrani veci z inventare
     * 
     * @param   mazana      odstraňovaná věc
     * @return  smazana     odstraněná věc. Je null, pokud věc nebyla v batohu nalezena
     */
    public Vec vyberVecVBatohu (String jmenoVeci) {
        Vec nalezenaVec= null;
        if (seznamVeci.containsKey(jmenoVeci)) {
            nalezenaVec = seznamVeci.get(jmenoVeci);
            seznamVeci.remove(jmenoVeci);
            return nalezenaVec;
        }
        return null;
    }
 
}
