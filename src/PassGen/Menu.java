package PassGen;

public class Menu {
    public int menu(String[] menuEntry, Short numberOfEntrence, short showNumbers, short yesNoOrNumber){
        ReadLine r = new ReadLine();
        System.out.println(menuEntry.length);
        switch (showNumbers){
            case 1:
                for (int i = 0; i < numberOfEntrence; i++) {
                    System.out.println(i + ") " + menuEntry[i]);
                }
                break;
            case 0:
                for (int i = 0; i < numberOfEntrence; i++) {
                    System.out.println(menuEntry[i]);
                }
                break;
        }
        //return  evaluate(r.read(),menuEntry,yesNoOrNumber);
        int a = evaluate(r.read(),menuEntry,yesNoOrNumber);
        System.out.println(a);
        return a;
    }


    private int evaluate(String answer, String[] menuEntry, short yesNoOrNumber){
        int result = 0;
        switch (yesNoOrNumber){
            case 0:
                if(answer.toLowerCase().equals("yes")||answer.toLowerCase().equals("y")){
                    result = 1;
                }if(answer.toLowerCase().equals("no")||answer.toLowerCase().equals("n")) {
                    result = 0;
                }else {
                    System.out.println("Fehler mit der Ja Nein erkennung");
                    return 99;
                }

            case 1:
                for (int i = 0; i < menuEntry.length ; i++) {
                    if(answer.toLowerCase().equals(menuEntry[i].toLowerCase())){
                        return i;
                    }if(Integer.parseInt(answer) == i){
                        return i;
                    }

                }
        }
        System.out.println("ganz eigentümlich");
        return 99;
    }
}
