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

    public void wasserAusgabe(int wasserStatus, int beetNummer) {
        System.out.println(String.format(wasserstatus, beetNummer, wasserStatus)); //wenn sich die Reihenfolge der Parameter ändern soll, muss die
        // lokalisierte Subklasse die Methode eben überschreiben :/
    }


    public void prompt() {
        System.out.println(prompt);
    }

    public void promptSuccess() {
        System.out.println(success);
    }


    public void promptFail() {
        System.out.println(error);
    }

    public boolean gerCheck() {
        boolean boo = language.equals("DE");
        return boo;
    }


}

