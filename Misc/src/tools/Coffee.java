
package tools;

public class Coffee {
    private int caffeine;
    private Roast roast;
    private String badRoast;

    public Coffee(int caffeine, Roast roast) {
        this.caffeine = caffeine;
        this.roast = roast;
        badRoast = "Lghti roast";
        
        if ( roast == Roast.LIGHT_ROAST ){
            caffeine += 10;
        }
    }

    public Roast getRoast() {
        return roast;
    }

    public void setRoast(Roast roast) {
        this.roast = roast;
    }



    public int getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(int caffeine) {
        this.caffeine = caffeine;
    }

   
    
}
