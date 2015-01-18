package PassGen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLine {

    public String read(){
        String text="";
        boolean a=true;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do try {
            text = br.readLine();
        } catch (IOException e) {
            System.out.println("Die Eingabe war nicht erfolgreich.");
            a = false;
        } while(a==false);
        return text;
    }
}