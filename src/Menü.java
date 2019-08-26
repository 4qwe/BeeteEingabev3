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

    public String wasserAusgabe(Beet beet) {
        int num = beet.beetnummer;
        int stand = beet.wasserstand;
        switch (language) {
            case "EN":
                return String.format(wasserstatus, stand, num);
            default:
                return String.format(wasserstatus, num, stand);
        }
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

