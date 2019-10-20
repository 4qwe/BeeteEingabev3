import beete.*;

public interface MenüInterface {
    // ALLE Ausgaben benötigen eine Methode hier
    //kein println(klasse.string) mehr - alle Ausgaben müssen von einem abstrakten Objekt/Interface von Menü verlangt werden können
/*Interface dient dazu Ausgabemethoden von einem Objekt in main verlangen zu können, ohne zu wissen ob es MenüGERMAN
  oder MenüENGLISCH ist*/

    void drawMenü(); //Interface erkennt dass die Subklasse die Methode ererbt!

    /* Methode gibt Wasserstand eines Beets aus*/
    String wasserAusgabe(Beet beet);

    /* Methode printet prompt String*/
    void prompt();

    /* Methode printet success String*/
    void promptSuccess();

    void promptFail();

    boolean gerCheck();

    void promptFile();

    void plotsPrinted(String o);
}