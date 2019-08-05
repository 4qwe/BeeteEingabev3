public class MenüGerman extends Menü implements IMenü {

    public void wasserAusgabe(int wasserStatus, int beetNummer) {
        wasserstatus = String.format("Beetnummer %d mit Status %d", beetNummer, wasserStatus);
        System.out.println(wasserstatus);
    }

    public MenüGerman() {

        ueberschrift = "--- HAUPTMENÜ LOL ---";
        eins = "s - Status";
        zwei = "b - Beenden";
        drei = "9 - Sprache wechseln";
        error = "Weder s noch b, versuche es noch einmal.";
        success = "Danke, auf Wiedersehn!";
        prompt = "Triff eine Eingabe: ";
        language = "DE";
    }

    public void drawMenü() {

        System.out.println("");
        System.out.println(ueberschrift);
        System.out.println("");
        System.out.println(eins);
        System.out.println(zwei);
        System.out.println(drei);
        System.out.println("");

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
