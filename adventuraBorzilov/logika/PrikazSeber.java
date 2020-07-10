package logika;


/**
 * Write a description of class PrikazSeber here.
 * 
 * @author Ilya Borzilov
 * @version 
 */
public class PrikazSeber implements IPrikaz
{
   private static final String NAZEV = "seber";
    private HerniPlan plan;
    private Batoh batoh;

    /***************************************************************************
     * Konstruktor třidy
     * @param plan herní plán, ve kterém se ve hře prochází
     * @param batoh, batoh, do kterého se vkládají věci
     */
    public PrikazSeber(HerniPlan plan, Batoh batoh){
        this.plan = plan;
        this.batoh = plan.getBatoh();

    }

    /**
     * Metoda provede přikaz "seber". 
     * Zkontroluje jestli věc se dá sebrat a je-li v aktualní místnosti
     * a vloží jí do batohu
     *
     * @param parametry nazev věci
     * @return zpáva
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo 
            return "Musis zadat jmeno věci, kterou chcete sebrat!";
        }

        String jmenoVeci = parametry[0];

        // zkoušíme přejít do sousedního prostoru
        Prostor aktualni = plan.getAktualniProstor();
        Vec vec = aktualni.odeberVec(jmenoVeci);

        if(vec == null){
            return "Zadana věc tady není";
        }else {
            if(vec.jePrenositelna()&&batoh.jeMisto()) // ověření, zda je v batoze místo a věc je přenositelná
            {
                batoh.vlozVec(vec);
                return " Věc " + jmenoVeci + "  uložená do batohu";

            }
            else // pokud není v batoze místo a věc není přenositelná
            {aktualni.vlozVec(vec);
                return " Nemůzes uložit věc " + jmenoVeci;
            }
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    @Override
    public String getNazev() {
        return NAZEV;
    }
}

