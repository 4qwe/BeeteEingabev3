
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Programm zeigt ein Menü, nimmt Input vom User, und zeigt dann entweder Menü oder beendet.
        // v2 erzeugt noch Beete und zeigt ihren Status per Menüeintrag
        //v3 lagert das Hauptmenü in eigene Klasse aus und fügt eine englische Version hinzu

        Main Maino = new Main(); //Objekt für alle methods in Main, die ich aus main aus benutze - kann methods damit unten in diese datei mit reinschreiben

        Beet[] plots = new Beet[5]; //Das Beetearray hat Platz für max. 5 Beete/Pflanzplots

        for (int i = 0; i < plots.length; i++) {   //Ich erstelle 5 Beetobjekte und versehe sie mit random Wasserstand
            int rando = (int) (Math.random() * 100 + 1); //Hier habe ich gecastet!
            System.out.println(rando);
            plots[i] = new Beet("unnamed", -1, rando);
            System.out.println("Beet Nr. " + (i + 1) + " hat Wasserstand " + rando);
        }

        Menü m1 = new MenüD();
        Boolean EN = false;

        Scanner s1 = new Scanner(System.in); //Ich erstelle ein Objekt für den zukünftigen Input des Users

        while (true) {
            m1.drawMenü(); //Hauptmenü anzeigen
            System.out.println(m1.prompt);
            String txt1 = s1.next();    //txt1 speichert hier Input vom User
            int temp = txt1.indexOf('b');
            if (temp != -1) {
                System.out.println(m1.success);
                break;                          //wenn b beende Programm
            }
            else {
                temp = txt1.indexOf('s');
                if (temp != -1) {
                    for (int i = 0; i < plots.length;
                        i++)                 //i von oben benutzen und runterzählen? .length ist die größe des array objekts!
                        System.out.println("Beet " + (i + 1) + " mit Wasserstand "
                            + plots[i].wasserstand); //sonst, wenn s zeige alle Wasserstände
                }
            } else {
                    temp = txt1.indexOf('9');
                    if (temp != -1) {
                        if (EN = true)
                            System.out.println("Menu is English, let's switch to DE!");
                        else
                            System.out.println("Menü ist deutsch, wechsel zu EN...");
                    }      //sonst
                }

                else
                    System.out.println(m1.error);                              //gib Fehler aus
            }
        } //loopt zurück zum while oben - hauptmenü

    }
    //hier endet main und beginnt Main

}