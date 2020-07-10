package adventuraZaklad_2019.logika;


/**
 * Write a description of class PrikazOdemkni here.
 * 
 * @author Ilya Borzilov
 * @version 
 */
public class PrikazOdemkni implements IPrikaz
{
     private static final String NAZEV = "odemkni";
    private Batoh batoh;
    private HerniPlan plan;

     /**
     * Konstruktor třidy
     * @param plan herní plán, ve kterém se ve hře prochází
     * @param batoh, batoh,který má kliče
     */
    public PrikazOdemkni(HerniPlan plan, Batoh batoh) {
        this.plan = plan;
        this.batoh = batoh;
    }

    /**
     *  Provádí příkaz "odemkni" pro prostotry s kličem. Pokud prostor existuje a je zamčený,
     *  tak se dozví, zda v batohu je potřebný klíč. Pokud ano, odemkne
     *  místnost. 
     *
     *@param parametry - jako  parametr obsahuje jméno prostoru,
     *                         do které se má jít.
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String provedPrikaz(String... parametry) {
        if (parametry.length == 0) {
            // pokud chybí druhé slovo (sousední místnost), tak ....
            return "Co chcete odemknout? Napište prosím nazev prostoru";
        }
        String prostor = parametry[0];
        // hledám zadanou místnost mezi východy
        Prostor sousedniProstor = plan.getAktualniProstor().vratSousedniProstor(prostor);
        
        
          if (sousedniProstor == null) {
            return " Nemužeš otevrit prostor " +prostor;
          }
          else {
            if(plan.getBatoh().obsahujeVec("klič")){  
              if (sousedniProstor.jeZamceno()&&sousedniProstor.getKlic()!=null)  {
                if (plan.getBatoh().obsahujeVec(sousedniProstor.getKlic().getJmeno())) {
                    sousedniProstor.zamknout(false);
                    return " Otevřil jsi " + prostor;
                }
                else {
                    return " Musís najit klič do prostoru " + prostor;
                }

            }   

            else {
                return " Prostor " + prostor + " otevřen.";
             }
           }
           else{
            return "Nemůžeš tady nic odemykat, jen posouvat";
           }
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
