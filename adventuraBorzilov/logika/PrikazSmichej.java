/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;



/*******************************************************************************
 * Instance třídy PrikazSmichej představují ...
 *
 * @author   Ilya Borzilov
 * @version   
 */
public class PrikazSmichej implements IPrikaz
{
    private static final String NAZEV = "smichej";
    private HerniPlan plan;
    private Batoh batoh;
        /**
     * Konstruktor třidy
     * @param plan herní plán, ve kterém se ve hře prochází.
     */
    public PrikazSmichej(HerniPlan plan, Batoh batoh){
        this.plan = plan;
        this.batoh = plan.getBatoh();

    }
    
    @Override
    public String provedPrikaz(String... parametry) {
        
            if (batoh.obsahujeVec("lahev_X") && batoh.obsahujeVec("lahev_Y") )  {  //metoda zjišťuje má-li hráč lahvi v batohu  
          plan.getBatoh().vyberVecVBatohu("lahev_X");  //odebírá věci 
          plan.getBatoh().vyberVecVBatohu("lahev_Y");
          plan.getBatoh().vlozVec(new Vec("jed", true));
          return "Vytvořil si jed. Ale pozor, jed je smrtelný!";
         } else {
           return "Nemáš všechna komponenta pro smíchaní";  
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
