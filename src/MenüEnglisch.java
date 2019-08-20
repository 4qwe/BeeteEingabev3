import com.sun.xml.internal.ws.addressing.WsaActionUtil;

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
        wasserstatus = "Water is at %d for plot No %d";
    }

}
