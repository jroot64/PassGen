package PassGen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Menu {
    public short menu(String[] menuEntrence, Short numberOfEntrence){
        ReadLine r = new ReadLine();
        for (int i = 0; i < numberOfEntrence; i++) {
            System.out.println(i + ") " + menuEntrence[i] + "/n");
        }
        return Short.parseShort(r.read());
    }
}
