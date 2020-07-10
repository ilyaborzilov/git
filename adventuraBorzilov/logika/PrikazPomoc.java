package logika;

/**
 *  Třída PrikazPomoc implementuje pro hru příkaz pomoc.
 *  Tato třída je součástí jednoduché textové hry.
 *  
 *@author     Ilya Borzilov
 *@version    
 *  
 */
class PrikazPomoc implements IPrikaz {
    
    private static final String NAZEV = "pomoc";
    private SeznamPrikazu platnePrikazy;
    
    
     /**
    *  Konstruktor třídy
    *  
    *  @param platnePrikazy seznam příkazů,
    *                       které je možné ve hře použít,
    *                       aby je pomoc mohla zobrazit uživateli. 
    */    
    public PrikazPomoc(SeznamPrikazu platnePrikazy) {
        this.platnePrikazy = platnePrikazy;
    }
    
    /**
     *  Vrací základní nápovědu po zadání příkazu "pomoc". Nyní se vypisuje
     *  vcelku primitivní zpráva a seznam dostupných příkazů.
     *  
     *  @return pomoc ve hre
     */
    @Override
    public String provedPrikaz(String... parametry) {
        return "Jsi lupič, který proniknul v banku pomoci provazu.\n" +         
        "Tvým úkolem je otevřít prostor se sejfem \n" +"Najdi klíč.\n"
        + "\n"
        + "Můžeš zadat tyto příkazy:\n"
        + platnePrikazy.vratNazvyPrikazu();
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