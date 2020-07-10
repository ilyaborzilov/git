package adventuraZaklad_2019.logika;

import java.util.*;

/**
 * Trida Prostor - popisuje jednotlivé prostory (místnosti) hry
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * "Prostor" reprezentuje jedno místo (místnost, prostor, ..) ve scénáři hry.
 * Prostor může mít sousední prostory připojené přes východy. Pro každý východ
 * si prostor ukládá odkaz na sousedící prostor.
 *
 * @author Ilya Borzilov
 * 
 * @version 
 */
public class Prostor {

    private String nazev;
    private String popis;
    private Set<Prostor> vychody;   // obsahuje sousední místnosti
     private Map<String, Vec> seznamVeci;
    private Map<String, Postava> seznamPostav;
    private boolean zamceno = false;
    private Vec klic;
    /**
     * Vytvoření prostoru se zadaným popisem, např. "kancelář_ředitele", "technická_místnost"
     *
     * @param nazev nazev prostoru, jednoznačný identifikátor, jedno slovo nebo
     * víceslovný název bez mezer.
     * @param popis Popis prostoru.
     */
    public Prostor(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.zamceno = zamceno;
        vychody = new HashSet<Prostor>();
        seznamVeci = new HashMap<>();
        seznamPostav = new HashMap<>();
        }

    /**
     * Definuje východ z prostoru (sousední/vedlejsi prostor). Vzhledem k tomu,
     * že je použit Set pro uložení východů, může být sousední prostor uveden
     * pouze jednou (tj. nelze mít dvoje dveře do stejné sousední místnosti).
     * Druhé zadání stejného prostoru tiše přepíše předchozí zadání (neobjeví se
     * 
     * žádné chybové hlášení). Lze zadat též cestu ze do sebe sama.
     *
     * @param vedlejsi prostor, který sousedi s aktualnim prostorem.
     *
     */
    public void setVychod(Prostor vedlejsi) {
        vychody.add(vedlejsi);
    }

    /**
     * Metoda equals pro porovnání dvou prostorů. Překrývá se metoda equals ze
     * třídy Object. Dva prostory jsou shodné, pokud mají stejný název. Tato
     * metoda je důležitá z hlediska správného fungování seznamu východů (Set).
     *
     * Bližší popis metody equals je u třídy Object.
     *
     * @param o object, který se má porovnávat s aktuálním
     * @return hodnotu true, pokud má zadaný prostor stejný název, jinak false
     */  
      @Override
    public boolean equals(Object o) {
        // porovnáváme zda se nejedná o dva odkazy na stejnou instanci
        if (this == o) {
            return true;
        }
        // porovnáváme jakého typu je parametr 
        if (!(o instanceof Prostor)) {
            return false;    // pokud parametr není typu Prostor, vrátíme false
        }
        // přetypujeme parametr na typ Prostor 
        Prostor druhy = (Prostor) o;

        //metoda equals třídy java.util.Objects porovná hodnoty obou názvů. 
        //Vrátí true pro stejné názvy a i v případě, že jsou oba názvy null,
        //jinak vrátí false.

       return (java.util.Objects.equals(this.nazev, druhy.nazev));       
    }

    /**
     * metoda hashCode vraci ciselny identifikator instance, ktery se pouziva
     * pro optimalizaci ukladani v dynamickych datovych strukturach. Pri
     * prekryti metody equals je potreba prekryt i metodu hashCode. Podrobny
     * popis pravidel pro vytvareni metody hashCode je u metody hashCode ve
     * tride Object
     */
    @Override
    public int hashCode() {
        int vysledek = 3;
        int hashNazvu = java.util.Objects.hashCode(this.nazev);
        vysledek = 37 * vysledek + hashNazvu;
        return vysledek;
    }
      

    /**
     * Vrací název prostoru (byl zadán při vytváření prostoru jako parametr
     * konstruktoru)
     *
     * @return název prostoru
     */
    public String getNazev() {
        return nazev;       
    }

    /**
     * Vrací "dlouhý" popis prostoru, který může vypadat následovně: Jsi v
     * mistnosti/prostoru vstupni hala budovy VSE na Jiznim meste. vychody:
     * chodba bufet ucebna
     *
     * @return Dlouhý popis prostoru
     */
    public String dlouhyPopis() {
        return "Jsi v prostoru " + popis + ".\n"
                + popisVychodu() + "\n"
                + getSeznamVeci();
    }

    /**
     * Vrací textový řetězec, který popisuje sousední východy, například:
     * "vychody: hlavní_hala".
     *
     * @return Popis východů - názvů sousedních prostorů
     */
    private String popisVychodu() {
        String vracenyText = "východy:";
        for (Prostor sousedni : vychody) {
            vracenyText += " " + sousedni.getNazev();
        }
        return vracenyText;
    }

    /**
     * Vrací prostor, který sousedí s aktuálním prostorem a jehož název je zadán
     * jako parametr. Pokud prostor s udaným jménem nesousedí s aktuálním
     * prostorem, vrací se hodnota null.
     *
     * @param nazevSouseda Jméno sousedního prostoru (východu)
     * @return Prostor, který se nachází za příslušným východem, nebo hodnota
     * null, pokud prostor zadaného jména není sousedem.
     */
    public Prostor vratSousedniProstor(String nazevSouseda) {
        if (nazevSouseda == null) {
            return null;
        }
        for (Prostor sousedni : vychody) {
            if (sousedni.getNazev().equals(nazevSouseda)) {
                return sousedni;
            }
        }
        return null;  // pokud prostor nenalezen
    }
    
    /**
     * Metoda vratPostavu
     *
     * @param jmeno vracené postavy
     * @return postavu
     */
    public Postava vratPostavu(String jmeno) {
        Postava hledana = null;
        for (Map.Entry<String, Postava> pair : seznamPostav.entrySet())
        {
            if(pair.getKey().equals(jmeno))
            {
                hledana = pair.getValue();
                break;
            }
        }
        return hledana;
    }

    /**
     * Vrací kolekci obsahující prostory, se kterými tento prostor sousedí.
     * Takto získaný seznam sousedních prostor nelze upravovat (přidávat,
     * odebírat východy) protože z hlediska správného návrhu je to plně
     * záležitostí třídy Prostor.
     *
     * @return Nemodifikovatelná kolekce prostorů (východů), se kterými tento
     * prostor sousedí.
     */
    public Collection<Prostor> getVychody() {
        return Collections.unmodifiableCollection(vychody);
    }
    
    
    /**
     * Metoda popisVeci
     *
     * @return popis věci v prostoru
     */
    public String popisVeci() {
        String vracenyText = "veci:";
        for (String nazev : seznamVeci.keySet()) {
            vracenyText += " " + nazev;
        }
        return vracenyText.equals("veci:")?"":vracenyText;
    }
    
    /**
     * Metoda popisPostavVMistnosti
     *
     * @return popis postav v prostoru
     */
    public String popisPostavVMistnosti() {
        String vracenyText = "postavy:";
        for (Map.Entry<String, Postava> pair : seznamPostav.entrySet())
        {

            vracenyText += " " + pair.getKey();
        }
        return vracenyText.equals("postavy:")?"":vracenyText;
    }
       
    /**
     * Metoda odeberVec
     * odebira věc z prostoru
     *
     * @param nazev věci
     * @return smazaná věc
     */
    public Vec odeberVec(String nazev) {
        return seznamVeci.remove(nazev);
    }
    
    /**
     * Nájde věci v prostoru.
     * 
     * @return vrátí vec z prostoru
     */

    public Vec najdiVecVProstoru(String jmeno) {
        return seznamVeci.get(jmeno);
    } 
    
    /**
     * Metoda vlozPostavu
     *
     * @param postava vkladaná postava
     */
    public void vlozVec(Vec vec) {
        seznamVeci.put(vec.getJmeno(), vec);
    }
    
    /**
     * Metoda vlozPostavu
     *
     * @param postava vkladaná postava
     */
    public void vlozPostavu(Postava postava) {
        seznamPostav.put(postava.getJmeno(), postava);
    }
       
    /**
     * Vraci seznam vecí, které se nacházejí v daném prostoru
     * 
     * return   seznam vecí
     */

    public String getSeznamVeci() {
        String nazvy = "V mistnosti je: ";
        for (String jmenoVeci : seznamVeci.keySet()){
            nazvy += jmenoVeci + ", ";
        }
        return nazvy;
    }
    
     /**
     * Metoda zamknout
     * zamyka a odemka prostory
     *
     * @param zamceno Parametr
     */
    public void zamknout(boolean zamceno) {
        this.zamceno = zamceno;
    }
    
    
    /**
     * Vrací seznam postav, které jsou v prostoru
     * 
     * return   seznam postav
     */

    public String getSeznamPostav() {
        String nazvy = "";
        for (String jmenoPostav : seznamPostav.keySet()){
            nazvy += jmenoPostav + ", ";
        }
        return nazvy;
    }
    /**
     * Metoda jeZamceno
     * vrací true je-li prostor zamčený
     *
     * @return Návratová hodnota
     */
    public boolean jeZamceno() {
        return zamceno;
    }
    
    /**
     * Metoda nastavKlic
     *
     * @param klic Parametr
     */
    public void nastavKlic(Vec klic) {
        this.klic = klic;
    }
    
    /**
     * Metoda getKlic
     *
     * @return Návratová hodnota
     */
    public Vec getKlic() {
        return klic;
    }
}
