
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Programm zeigt ein Menü, nimmt Input vom User, und zeigt dann entweder Menü oder beendet.
        // v2 erzeugt noch Beete und zeigt ihren Status per Menüeintrag
        //v3 lagert das Hauptmenü in eigene Klasse aus und fügt eine englische Version hinzu
        //v3.2 hat Simons Verbesserungen (außer switch statement) und ist wieder public in Github

        Menü menuEnglish = new MenüE();
        Menü menuGerman = new MenüD(); //Dies erstellt das Menü-Objekt menuGerman und weist ihm die Referenz zu auf ein neu zu erstellendes Objekt
        // mittels des Konstruktors von *MenüD*

        Beet[] plots = new Beet[5]; //Das Beetearray hat Platz für max. 5 Beete/Pflanzplots

        for (int i = 0; i < plots.length;
            i++) {   //Ich erstelle 5 Beetobjekte und versehe sie mit random Wasserstand
            int rando = (int) (Math.random() * 100 + 1); //Hier habe ich gecastet!
            System.out.println(rando);
            plots[i] = new Beet(i+1, -1, rando);
            System.out.println("Beet Nr. " + (i + 1) + " hat Wasserstand " + rando);
        }


        Menü m1 = menuGerman;   //Dies erstellt das aktuell zu verwendende Menü-Objekt m1 und richtet die Referenz auf das vormals erstellte deutsche
        //MenüD-Objekt ein

        Scanner s1; //Ich erstelle ein Objekt für den zukünftigen Input des Users
        s1 = new Scanner(System.in);

        while (true) {
            m1.drawMenü(); //Hauptmenü anzeigen
            System.out.println(m1.prompt);
            String txt1;
            txt1 = s1.next(); //txt1 speichert hier Input vom User

            if (txt1.equals("b")) {
                System.out.println(m1.success);
                break;
            }
            else if (txt1.equals("s")) {
                for (int i = 0; i < plots.length; i++) {
                    System.out.println(m1.getLocaString(plots[i].beetnummer, plots[i].wasserstand));
                }
            } else if (txt1.equals("9")) {
                if (m1.language.equals("DE")) {
                    m1 = menuEnglish;
                } else {
                    m1 = menuGerman;
                }
            } else {
                System.out.println(m1.error);
            }
        } //loopt zurück zum while
    } //ende main u anfang Main

}

