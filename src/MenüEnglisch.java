public class MenüEnglisch extends Menü implements MenüInterface {

    public MenüEnglisch() {

        ueberschrift = "--- MAIN MENU ---";
        eins = "s - Status";
        zwei = "b - Quit";
        drei = "t - Print plot shapes";
        vier = "9 - Change Language";
        error = "Try again.";
        success = "Thank you. Good bye!";
        prompt = "Select your choice ";
        language = "EN";
        wasserstatus = "Water is at %d for plot No %d";
        plots_printed = "Plots printed to %s%n";
        prompt_file = "Enter a filename ending in .svg";
    }


}