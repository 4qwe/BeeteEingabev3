public class MenüEnglisch extends Menü implements IMenü {

    public MenüEnglisch() {

        ueberschrift = "--- MAIN MENU ---";
        eins = "s - Status";
        zwei = "b - Quit";
        drei = "9 - Change Language";
        error = "Try again.";
        success = "Thank you. Good bye!";
        prompt = "Select your choice ";
        language = "EN";
    }

    public void wasserAusgabe(int wasserStatus, int beetNummer) {
        wasserstatus = String.format("Plot No. %d has %d %% water", beetNummer, wasserStatus);
        System.out.println(wasserstatus);
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
