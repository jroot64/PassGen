package PassGen;


import PassGen.Handler.AESHandler;

import java.io.File;

public class Main{
    public static void main(String[] args){
        AESHandler.key();
        List allPassPhrase = new List();
        FileIteraction fi = new FileIteraction();
        allPassPhrase= fi.readPassPhrases();
        ReadLine r = new ReadLine();
        Menu menu = new Menu();
        int decide=0; //t=0;
        System.out.println("Herzlich willkommen in Jonas Passwort generator");
        do{
            String[] menuEntry = {"Exit","neues Passwort generieren","alle Passwörter anzeigen","eintrag Löschen",
                    "autogen","eintrag ändern","test"};
            //MENU replaced by the Menu calss with an evaluation function
            //System.out.println("MENÜ \n 0)EXIT \n 1)neues Passwort generieren \n 2)alle Passwörter anzeigen \n 3)eintrag Löschen \n 4)autogen" +
            //          "\n 5)eintrag Bearbeitern");
            //decide=Integer.parseInt(r.read());
            decide = menu.menu("HAUPTMENÜ",menuEntry);
            switch (decide){
                case 0:
                    AESHandler.key();
                    fi.savePassPhrases(allPassPhrase);
                    return;
                case 1:
                    Password password1 = new Password();
                    password1.genNewPassPhrase();
                    allPassPhrase.save(password1);
//                    t++;
                    allPassPhrase.outLength();
                    break;
                case 2:
                    allPassPhrase.out();
                    break;
                case 3:
                    allPassPhrase.delet(allPassPhrase);
                    break;
                case 4:
                    Password password2 = new Password("Auto Gen",10,true,true,true,true);
                    password2.genNewPassPhrase();
                    allPassPhrase.save(password2);
//                    t++;
                    allPassPhrase.outLength();
                    break;
                case 5:
                    allPassPhrase.out();
                    System.out.println("Welcher eintrag soll geändert werden.");
                    Password passToChange = allPassPhrase.getsave(Integer.parseInt(r.read()));
                    passToChange.changeApplication();
                    break;
                }
        }while(true);
    }

}
