public interface IMenü {
    // ALLE Ausgaben benötigen eine Methode hier


    void drawMenü();

    void wasserAusgabe(int wasserStatus, int beetNummer);

    void prompt();

    void promptSuccess();

    void promptFail();

    boolean gerCheck();


}