import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Programm zeigt ein Menü, nimmt Input vom User, und zeigt dann entweder Menü oder beendet.
        // v2 erzeugt noch Beete und zeigt ihren Status per Menüeintrag
        //v3 lagert das Hauptmenü in eigene Klasse aus und fügt eine englische Version hinzu
        //v3.2 hat Simons Verbesserungen (außer switch statement) und ist wieder public in Github
        //v3.3 benutzt ein Interface zusätzlich zu den Subclasses für die lokalisierten Menüs, um Parameter in einem unspezifizierten Menüobjekt
        // benutzen zu können

        IMenü englischesMenu = new MenüEnglisch(); //Dies erstellt ein MenüInterface-Objekt und weist ihm die Referenz zu auf ein neu zu
        // erstellendes Objekts mittels des Konstruktors der Klasse

        IMenü deutschesMenu;
        deutschesMenu = new MenüGerman();

        IMenü aktuellesMenü = deutschesMenu; //Dies richtet die Referenz eines weiteren MenüInterface auf eines der beiden bereits erstelllten ein

        Beet[] plots = new Beet[5]; //Das Beetearray hat Platz für max. 5 Beete/Pflanzplots

        for (int i = 0; i < plots.length;
            i++) {   //Ich erstelle 5 Beetobjekte und versehe sie mit random Wasserstand
            int rando = (int) (Math.random() * 100 + 1); //Hier habe ich gecastet!
            System.out.println(rando);
            plots[i] = new Beet(i + 1, -1, rando);
            System.out.println("Beet Nr. " + (i + 1) + " hat Wasserstand " + rando);
        }

        Scanner s1; //Ich erstelle ein Objekt für den zukünftigen Input des Users
        s1 = new Scanner(System.in);

        while (true) {
            aktuellesMenü.drawMenü(); //Hauptmenü anzeigen
            aktuellesMenü.prompt();
            String txt1;
            txt1 = s1.next(); //txt1 speichert hier den Input vom User

            if (txt1.equals("b")) {
                aktuellesMenü.promptSuccess();
                break;
            }
            else if (txt1.equals("s")) {
                for (int i = 0; i < plots.length; i++) {
                    aktuellesMenü.wasserAusgabe(plots[i].wasserstand, plots[i].beetnummer);
                }
            }
            else if (txt1.equals("9")) {
                if (aktuellesMenü.gerCheck()) {
                    aktuellesMenü = englischesMenu;
                }
                else {
                    aktuellesMenü = deutschesMenu;

                }
            }
            else {
                aktuellesMenü.promptFail();
            }

        } //loopt zurück zum while-start

    } //ende main u anfang Main

}

