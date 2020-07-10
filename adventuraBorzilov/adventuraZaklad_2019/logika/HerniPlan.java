package adventuraZaklad_2019.logika;


/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Ilya Borzilov
 *@version    
 */
public class HerniPlan {
    
    private Prostor aktualniProstor;
    private Batoh batoh;
         /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
       zalozProstoryHry();
       batoh = new Batoh();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor hlavní_hala = new Prostor("hlavní_hala","hlavní_hala. Proniknul jsi v banku a nyní se nacházíš tu");
        Prostor kancelář_ředitele = new Prostor("kancelář_ředitele", "Jsou tady leží nějaké věci, které můžeš si vzít s sebou");
        Prostor technická_místnost = new Prostor("technická_místnost","Jsou tady několik regálů. Za jedním regálem jsou dveře ");
        Prostor sklep = new Prostor("sklep","Je temnota, ale s pomoci svítilny všechno vidíš");
        Prostor bezpečnostní_místnost = new Prostor("bezpečnostní_místnost","Na křesle spi strážník");
        Prostor pokoj_se_sejfem  = new Prostor("pokoj_se_sejfem", "Je zamcený prostor");
        
        // přiřazují se průchody mezi prostory (sousedící prostory)
        hlavní_hala.setVychod(kancelář_ředitele);
        hlavní_hala.setVychod(technická_místnost);
        hlavní_hala.setVychod(bezpečnostní_místnost);
        kancelář_ředitele.setVychod(hlavní_hala);
        kancelář_ředitele.setVychod(pokoj_se_sejfem);
        technická_místnost.setVychod(hlavní_hala);
        technická_místnost.setVychod(sklep);
        sklep.setVychod(technická_místnost);
        bezpečnostní_místnost.setVychod(hlavní_hala);
        
        
        // vytvářejí se jednotlivé věcí
        Vec klič = new Vec("klič",true);
        Vec provaz = new Vec("provaz",false);
        Vec svítilna = new Vec("svítilna",true);
        Vec lahev_X = new Vec("lahev_X",true);
        Vec propiska = new Vec("propiska",true);
        Vec razítko = new Vec("razítko",true);
        Vec sponka = new Vec("sponka",true);
        Vec lahev_Y = new Vec("lahev_Y",true);
        Vec jed = new Vec("jed",true);
                
        // vytvářejí se jednotlivé postavy
        Postava strážník = new Postava("strážník", "Strážník spi");
        bezpečnostní_místnost.vlozPostavu(strážník);
        
        // vkládaní věcí do jednotlivých prostoru
        hlavní_hala.vlozVec(provaz);
        hlavní_hala.vlozVec(lahev_X);
        kancelář_ředitele.vlozVec(propiska);
        kancelář_ředitele.vlozVec(razítko);
        sklep.vlozVec(lahev_Y);
        hlavní_hala.vlozVec(svítilna);
        
        //nastaveni zamčených prostorů a kliče k ním
        strážník.setVec(klič);
        pokoj_se_sejfem.nastavKlic(klič);
        pokoj_se_sejfem.zamknout(true); 
        
        kancelář_ředitele.vlozVec(sponka);
        sklep.nastavKlic(sponka);
        sklep.zamknout(true);  
                   
                
        aktualniProstor = hlavní_hala;  // hra začíná tady      
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }
    
    /**
     * Metoda vrací odkaz na aktuální batoh
     *
     * @return batoh
     */
    public Batoh getBatoh() { 
        return this.batoh;
    }
    
    public boolean jeVyhra()
    {
        return aktualniProstor.getNazev().equals("pokoj_se_sejfem");
    }
    
    /**
     *  Metoda pro zjištění, zda je aktuálním prostorem požadovaná místnost či prostor.
     */
    public boolean bezpec(){ 
        return aktualniProstor.getNazev().equals("bezpečnostní_místnost");        
        
    }
}
