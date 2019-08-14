public interface IMenü {
    // ALLE Ausgaben benötigen eine Methode hier
    //kein println(klasse.string) mehr - alle Ausgaben müssen von einem abstrakten Objekt/Interface von Menü verlangt werden können


    void drawMenü(); //Interface erkennt dass die Subklasse die Methode ererbt!

    void wasserAusgabe(Beet beet);

    void prompt();

    void promptSuccess();

    void promptFail();

    boolean gerCheck();


}