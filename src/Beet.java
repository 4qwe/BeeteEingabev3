public class Beet {

    protected String points; //für Form des Beets?
    protected int[] pos; //position der Form
    protected int beetnummer; //Bezeichner
    protected int wasserstand;

    public Beet(int n, String p, int[] po, int w) {

        points = p;
        pos  = po;
        beetnummer = n;
        wasserstand = w;

    }

    public int getWasserstand() {
        return wasserstand;
    }

    public int getBeetnummer() {
        return beetnummer;
    }
}