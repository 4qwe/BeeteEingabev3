package beete;

public class Beet {

    protected String points; //für Form des Beets?
    protected int[] plants; //positionen der Pflanzen in plots, die dies tracken
    protected int beetnummer; //interner Bezeichner
    protected int wasserstand;
    protected int temperatur;
    protected String est; //datum angelegt

    public Beet(int n, String p, int[] pl, int w) {

        points = p;
        plants = pl;
        beetnummer = n;
        wasserstand = w;

    }

    public int getWasserstand() {
        return wasserstand;
    }

    public int getBeetnummer() {
        return beetnummer;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String s) {
        points = s;
    }


    public void setBeetnummer(int n) {
        beetnummer = n;
    }
public void setWasserstand(int n) {
        wasserstand = n;
    }


}