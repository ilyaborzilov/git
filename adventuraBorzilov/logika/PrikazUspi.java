package logika;


/**
 * Write a description of class PrikazUspi here.
 * 
 * @author Ilya Borzilov
 * @version 
 */
public class PrikazUspi implements IPrikaz
{
    //== Datové atributy (statické i instancí)======================================
    private static final String NAZEV = "uspi";
    private HerniPlan plan;
    private Batoh batoh;
    private Hra hra;
    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor třidy
     *  @param plan
     *  @param hra
     */
    public PrikazUspi(HerniPlan plan, Hra hra)
    {
        this.plan = plan;
        this.batoh = plan.getBatoh();
        this.hra = hra;
    }

    /**
     * Provádí příkaz "uspi". Pokud v batohu je jed, příkaz se provede,
     * pokud není, vratí se zpráva že nemáte jed.
     * Pokud lahvi v batohu je, v parametru se předavá jmeno postavy, kterou chcete 
     * uspat a u postavy se nastaví hodnota jeMrtvy na true.
     *
     * @param parametry - jmeno postavy
     * @return zpráva, kterou vypíše hra hráči
     */
    @Override
    public String provedPrikaz(String... parametry) {
        if(batoh.obsahujeVec("jed"))
        {
            if (parametry.length == 0) {
                // pokud chybí druhé slovo (sousední prostor), tak ....
                return "Koho chces zabit? Musis napsat jmeno";
            }

            String jmeno = parametry[0];

            // zkoušíme přejít do sousedního prostoru
            Prostor aktualni = plan.getAktualniProstor();
            Postava postava = aktualni.vratPostavu(jmeno);

            if(postava == null)
            {
                return "Nemuzete tuto postavu zabit!";
            }
            else
            {
                if(postava.jeZabity())
                {
                    
                    return "Postava uz je zabita";
                }
                else
                {if(postava.odeberVec()!=null)
                    {
                        postava.setZabity(true);
                        aktualni.vlozVec(postava.odeberVec());
                        aktualni.vlozVec(new Vec("klič", true));
                        return postava.getJmeno()+" je mrtvý \n" + postava.odeberVec().getJmeno() + " je v prostoru";  
                    }
                    postava.setZabity(true);
                    return postava.getJmeno()+" byl zabit!!";
                }
            }
        }
        else
        {
            return "Nemate jed. Musite ho nekdy najit";
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
    //== Soukromé metody (instancí i třídy) ========================================

}

