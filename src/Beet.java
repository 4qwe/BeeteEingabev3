public class Beet {

    protected int points; //für Form des Beets?
    protected String name;
    protected int wasserstand;

    public Beet() {

        points = 0;
        name = "unnamed";
        wasserstand = 0;

    }

    public Beet(String n, int p, int w) {

        points = p;
        name = n;
        wasserstand = w;

    }

}
