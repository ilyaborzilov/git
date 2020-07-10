package adventuraZaklad_2019.logika;


/**
 * Write a description of class PrikazBatoh here.
 * 
 * @author Ilya Borzilov
 * @version 
 */
public class PrikazBatoh implements IPrikaz
{
    private static final String NAZEV = "batoh";
    private HerniPlan plan;
    private Batoh batoh;

    /**
     *  Konstruktor třídy
     *  @param batoh, batoh ve kterém jsou sebrané věci
     */
    public PrikazBatoh(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     *  Provádí příkaz "batoh". Vypíše všechny věci, které jsou v batohu.
     *
     *  @return     zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (plan.getBatoh().getSeznamVeci().isEmpty()) {
            return "Batoh je dosud prazdný";    // pokud batoh je prázdný
        }
        else {
            return plan.getBatoh().jmenoVeciVBatohu();
        }
    }

    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }
}
