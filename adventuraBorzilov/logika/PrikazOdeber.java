package logika;


/**
 * Write a description of class PrikazOdeber here.
 * 
 * @author Ilya Borzilov
 * @version 
 */
public class PrikazOdeber implements IPrikaz
{
     private static final String NAZEV = "odeber";
    private HerniPlan herniPlan;

    /**
     * Konstruktor třidy
     * @param plan herní plán, ve kterém se ve hře prochází.
     */
    public PrikazOdeber(HerniPlan herniPlan){
        this.herniPlan = herniPlan;
    }

    /**
     *  Provádí příkaz "odeber". Pokud v batohu věc není, tak vypíše chybovou hlášku.
     *  Jinak věc výhodí do aktuálního prostoru. Lze výhodit jen jednu věc
     *  najednou.
     *
     *  @param  parametry   -jako  parametr se zadává jméno odhazované věci
     *  @return             zpráva, kterou vypíše hra hráči
     */ 
    @Override
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            return "Musis zadat jmeno veci";
        }

        String jmenoVeci = parametry[0];
        Prostor aktualniProstor = herniPlan.getAktualniProstor();
        Batoh batoh = herniPlan.getBatoh();
        Vec nalezenaVec = batoh.getVec(jmenoVeci);

        if (nalezenaVec == null) {
            return "Vec v batohu neni";  // pokud mazana věc není v batohu.
        }       

        else {
            // pokud je věc smazána z batohu, přesune se do aktualního prostoru
            nalezenaVec = batoh.vyberVecVBatohu(jmenoVeci);
            aktualniProstor.vlozVec(nalezenaVec);
            return jmenoVeci + " odstranena. ";
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


