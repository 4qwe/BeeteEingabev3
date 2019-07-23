public class Menü {

    protected String ueberschrift;
    protected String eins;
    protected String zwei;
    protected String drei;
    protected String error;
    protected String success;
    protected String prompt;

    public void drawMenü() {
        System.out.println("");
        System.out.println(ueberschrift);
        System.out.println("");
        System.out.println(eins);
        System.out.println(zwei);
        System.out.println(drei);
        System.out.println("");
    }
}