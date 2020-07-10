/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package adventuraZaklad_2019.logika;

/*******************************************************************************
 * Instance třídy PrikazPosun_a_otevri představují 
 *
 * @author    Ilya Borzilov
 * @version   
 */
public class PrikazPosun_a_otevri implements IPrikaz
{
    private static final String NAZEV = "posun_a_otevri";
    private HerniPlan plan;
    private Batoh batoh;

    //== Datové atributy (statické i instancí)======================================

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor ....
     */
    public PrikazPosun_a_otevri(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     *  Provádí příkaz "Posun_a_otevri". Posouvá regál a zároveň otvírá prostor.Pokud je zamčený,
     *  tak se dozví, zda v batohu je potřebný klíč. Pokud ano, odemkne
     *  místnost. 
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru,
     *                         do které se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo
            return "Musíš zadat prostor, který chceš otevřít, aby posunul regál a pak otevřel dveře";
        }
        String prostor = parametry[0];
        // hledám zadanou místnost mezi východy
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);

        if (sousedniProstor == null) {
            return " Nemužeš posunout regal a otevrit " +prostor;
        }
        else {
          if(plan.getBatoh().obsahujeVec("svítilna")){
               if (sousedniProstor.jeZamceno()&&sousedniProstor.getKlic()!=null)  {
                if (plan.getBatoh().obsahujeVec(sousedniProstor.getKlic().getJmeno())) {
                    sousedniProstor.zamknout(false);
                    return " Posunul jsi regal. Z důvodu, ze máš svítilnu tma není pro tebe strachem a můžeš vejit ve " + prostor;
                }
                else {
                    return "Musíš si najit něco, čím otevřeš dveře za regálem";
                }

              }   

              else {
                return " Prostor " + prostor + " otevřen.";
              }
            }
            else{
               return "Ve sklepu je tma, potřebuješ něco, aby vejit";
            }
        }
    }

    //== Soukromé metody (instancí i třídy) ========================================
    /**
     *  Metoda vrací název příkazu (slovo které používá hráč pro jeho vyvolání)
     *  
     *  @ return nazev prikazu
     */
    public String getNazev() {
        return NAZEV;
    }
}
