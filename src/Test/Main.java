package Test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args){
        do{
            String s="";
            try{
                s = read();
                System.out.println(s.toLowerCase());
            }catch (NumberFormatException NumberExeption){
                System.out.println(Float.parseFloat(s));
            }
        }while (true);
    }
    private static String read(){
        String text="";
        boolean a;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do try {
            text = br.readLine();
            a=true;
        } catch (IOException e) {
            System.out.println("Die Eingabe war nicht erfolgreich.");
            a = false;
        } while(!a);
        return text;
    }
}
