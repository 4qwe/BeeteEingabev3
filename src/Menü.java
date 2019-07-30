public class Menü {

    protected String ueberschrift;
    protected String eins;
    protected String zwei;
    protected String drei;
    protected String error;
    protected String success;
    protected String prompt;
    protected String language;
    protected String wasserstatus;

    public void drawMenü() {
        System.out.println("");
        System.out.println(ueberschrift);
        System.out.println("");
        System.out.println(eins);
        System.out.println(zwei);
        System.out.println(drei);
        System.out.println("");
    }

    public String getLocaString(int a, int b) {
        String s = String.format(wasserstatus, a, b) ;
        return s;
    }

}