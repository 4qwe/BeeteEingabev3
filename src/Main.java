import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
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

        IMenü englischesMenu = new MenüEnglisch(); //Dies erstellt ein MenüInterface-Objekt und weist ihm die Referenz zu auf ein neu zu
        // erstellendes Objekt mittels des Konstruktors der Klasse

        IMenü deutschesMenu;
        deutschesMenu = new MenüGerman();
        IMenü aktuellesMenü = deutschesMenu; //Dies richtet die Referenz eines weiteren MenüInterface auf eines der beiden bereits erstelllten ein

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
        Beet[] plots = new Beet[wievielBeete]; //Das Beetearray hat Platz für 'Anzahl' Beete/ bzw. Pflanzplots

        for (int i = 0; i < plots.length; i++) {   //Ich erstelle X Beetobjekte und versehe sie mit random Wasserstand
            int rando = (int) (Math.random() * 100 + 1); //Hier habe ich gecastet!
            System.out.println(rando);
            plots[i] = new Beet(i + 1, null, null, rando); /* Beispielpunkte für
            ALLE erstellten Beete */
            System.out.println("Beet Nr. " + (i + 1) + " hat Wasserstand " + rando);
        }

        plots[0].points = "19,54 5,30 19,5 48,5 62,30 48,54";
        plots[1].points = "89,54 75,30 89,5 118,5 132,30 118,54";

        Main maino = new Main(); /*todo ausgabemethoden zum test in Main*/

        VektorBeet vb = new VektorBeet(); /*Objekt für Methoden die Canvas betreffend*/

        Scanner s1; //Ich erstelle ein Objekt für den zukünftigen Input des Users
        s1 = new Scanner(System.in);

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
                Document doc = vb.buildVek(plots);
                String output = "plotshapes.svg";
                maino.stringToFile(maino.getStringFromDocument(doc),output);
                System.out.printf("Plots printed to %s%n", output);
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


    /* Methode schreibt String aus SVG Document */
    public String getStringFromDocument(Document doc) {
        try {
            DOMSource domSource = new DOMSource(doc);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        }
        catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /*Methode schreibt String in eine Dateil*/
    public void stringToFile(String s, String outFile) throws FileNotFoundException {
        PrintWriter prntWrtr = new PrintWriter(outFile); /*Exception kommt hier vor*/
        prntWrtr.println(s);
        prntWrtr.close();
    }


}/*ende Main. ende Glände*/

