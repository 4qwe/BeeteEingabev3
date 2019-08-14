public class Beet {

    protected int points; //für Form des Beets?
    protected int beetnummer; //Bezeichner
    protected int wasserstand;

    public Beet() {

        points = 0;
        beetnummer = 0;
        wasserstand = 0;

    }

    public Beet(int n, int p, int w) {

        points = p;
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


