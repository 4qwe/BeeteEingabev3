import beete.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;


public class Main {

    public static void main(String[] args)
            throws java.io.IOException {  //IOException möglich aus Properties.load beim Bespielen des Hashtables mit dem FileReader-Objekt
// Programm zeigt ein Menü, nimmt Input vom User, und zeigt dann entweder Menü oder beendet.
        // v2 erzeugt noch Beete und zeigt ihren Status per Menüeintrag
        //v3 lagert das Hauptmenü in eigene Klasse aus und fügt eine englische Version hinzu
        //v3.2 hat Simons Verbesserungen (außer switch statement) und ist wieder public in Github
        //v3.3 benutzt ein Interface zusätzlich zu den Subclasses für die lokalisierten Menüs, um Parameter in einem unspezifizierten Menüobjekt
        // benutzen zu können
        //v3.4 arbeitet direkt mit dem beet-Objekt innerhalb der methode die den wasserstatus-string berechnet, beinhaltet switch statement
        //v3.5 Properties File
        //v3.6 mit exception handling (nur pro forma)

        MenüInterface englischesMenu = new MenüEnglisch(); //Dies erstellt ein MenüInterface-Objekt und weist ihm die Referenz zu auf ein neu zu
        // erstellendes Objekt mittels des Konstruktors der Klasse

        MenüInterface deutschesMenu;
        deutschesMenu = new MenüGerman();
        MenüInterface aktuellesMenü = deutschesMenu; //Dies richtet die Referenz eines weiteren MenüInterface auf eines der beiden bereits erstelllten ein

        FileReader fromFile = null;
        try {
            fromFile = new FileReader("db.properties"); //lädt Inhalt des property file in FileReader Objekt
        }
        catch (FileNotFoundException e) {
            System.out.println("FileReader kann mit dieser Datei kein Objekt initialisieren. StackTrace folgt ");
            e.printStackTrace();
        }

        Properties BeeteProperties = new Properties();
        BeeteProperties.load(fromFile); //benutzt Properties-Methode um Hashtable aus FileReader Objekt zu erstellen

        int wievielBeete = Integer.parseInt(BeeteProperties.getProperty("anzahl")); //hier "fehlt" exception handling für String ist kein Int

        Beet[] plots = new Beet[wievielBeete]; //Beet[] plots wird erstellt: X Beete in einem Array

        for (int i = 0; i < plots.length; i++) {   //Ich erstelle X Beetobjekte und todo Initialisiere random Wasserstand
            int rando = (int) (Math.random() * 100 + 1); //Hier habe ich gecastet!
            System.out.println(rando);
            plots[i] = new Beet(i + 1, null, null, rando); /* Jedes Element des Array wird initialisiert- nur Bezeichner mit eigentlichen Wert */
            System.out.println("beete.Beet Nr. " + (i + 1) + " hat Wasserstand " + rando);
        }

        plots[0].setPoints("19,54 5,30 19,5 48,5 62,30 48,54"); /*todo Initialisierung für Beetobjekte 1 und 2 des Plotarrays*/
        plots[1].setPoints("89,54 75,30 89,5 118,5 132,30 118,54");

        VektorBeet vb = new VektorBeet(); /*Objekt für Methoden die Canvas betreffend*/

        Scanner s1; //Ich erstelle ein Objekt für den zukünftigen Input des Users
        s1 = new Scanner(System.in);

        /* Hauptmenüloop*/
        while (true) {

            aktuellesMenü.drawMenü(); //Hauptmenü anzeigen
            aktuellesMenü.prompt();

            //txt1 speichert _hier_ den Input vom User
            String txt1 = s1.next();

            if (txt1.equals("b")) {
                aktuellesMenü.promptSuccess();
                break;
            }
            else if (txt1.equals("s")) {
                for (int i = 0; i < plots.length; i++) {
                    System.out.println(aktuellesMenü.wasserAusgabe(plots[i]));
                }
            }
            else if (txt1.equals("t")) {
                String svg_as_string = vb.getStringFromDocument(vb.buildVek(plots));
                aktuellesMenü.promptFile();
                String output = s1.next(); /*Scanner objekt von vorhin kann noch herhalten*/
                vb.stringToFile(svg_as_string, output);
                aktuellesMenü.plotsPrinted(output);
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


}/*ende Main. ende*/

