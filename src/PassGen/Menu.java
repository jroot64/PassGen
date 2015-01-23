package PassGen;

public class Menu {

    public int menu(String text){
        int result;
        boolean badAnswer;
        do{
            badAnswer = false;
            String[] yn = {"yes","no"};
            System.out.println(text);
            menuEntry(yn,0);
            result = evaluate(yn,1);
            if(result == 999) badAnswer=true;
        }while (badAnswer);
        return result;

    }
    public int menu(String text, int min, int max){
        int result;
        boolean badAnswer;
        String[] possibleAnswers = new String[]{String.valueOf(min), String.valueOf(max)};
        do{
            badAnswer = false;
            System.out.println(text);
            result = evaluate(possibleAnswers,3);
            if(result == 999) badAnswer=true;
        }while (badAnswer);
        return result;
    }
    public int menu(String text, String[] menuEntry){
        int result;
        boolean badAnswer;
        do{
            badAnswer = false;
            System.out.println(text);
            menuEntry(menuEntry,1);
            result = evaluate(menuEntry,2);
            if(result == 999) badAnswer=true;
        }while (badAnswer);
        return result;
    }
    public void menuEntry(String[] menuEntry,int showNumbers){

//        System.out.println(menuEntry.length);
        switch (showNumbers){
            case 1:
                for (int i = 0; i < menuEntry.length; i++) {
                    System.out.println(i + ") " + menuEntry[i]);
                }
                break;
            case 0:
                for (String aMenuEntry : menuEntry) {
                    System.out.println(aMenuEntry);
                }
                break;
        }
        //return  evaluate(r.read(),menuEntry,yesNoOrNumber);
    }


    private int evaluate(String[] menuEntry, int yesNoOrNumber){
//        int result = 0;
        ReadLine r = new ReadLine();
        String answer = r.read();
        int ianswer = 999;
        try {
            ianswer=Integer.parseInt(answer);
        }catch (Exception e){
            ianswer = menuEntry.length+1;
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("");
        }
        switch (yesNoOrNumber) {
            case 1:                             //Answer ist tested for yes or no in different ways
                if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("y") || ianswer == 1) {
                    return 1;
                }
                if (answer.toLowerCase().equals("no") || answer.toLowerCase().equals("n") || ianswer == 0) {
                    return 0;
                }
                System.out.println("Fehler in der Ja Nein erkennung");
                return 999;


            case 2:
                for (int i = 0; i < menuEntry.length; i++) {
                    if (answer.toLowerCase().equals(menuEntry[i].toLowerCase())) {
                        return i;
                    }
                    if (ianswer == i) {
                        return i;
                    }
                }
                System.out.println("Es ist ein Fehler aufgetaucht.");
                return 999;
            case 3:
                int i;
                try {
                    i = Integer.parseInt(answer);
                }catch (NumberFormatException Exeption){
                    System.out.println("Die Eingabe war entweder zu groß um sie zu verarbeiten oder es handelte sich nicht um eine Zahl.");
                    return 999;
                }
                if (i<=Integer.parseInt(menuEntry[1])&&i>=Integer.parseInt(menuEntry[0])) return i;
                System.out.println("Die eingegebene Zahl ist zu klein oder zu groß. Es sind nur Zahlen größer " + (Integer.parseInt(menuEntry[0])-1)+" und kleiner "
                + (Integer.parseInt(menuEntry[1])+1)+" erlaubt.");
                return 999;
        }
        System.out.println("Es wurde kein Menüeintrag mit Übereinstimmung zu ihrer Eingabe gefunden.");
        return 999;
    }
}
