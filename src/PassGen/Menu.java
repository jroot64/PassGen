package PassGen;

public class Menu {

    public int menu(String text){
        String[] yn = {"yes","no"};
        System.out.println(text);
        menuEntry(yn,Short.parseShort("0"));
        return evaluate(yn,Short.parseShort("1"));
    }
    public int menu(String text, String[] menuEntry){
        System.out.println(text);
        menuEntry(menuEntry,Short.parseShort("1"));
        return evaluate(menuEntry,Short.parseShort("2"));
    }
    public void menuEntry(String[] menuEntry,short showNumbers){

//        System.out.println(menuEntry.length);
        switch (showNumbers){
            case 1:
                for (int i = 0; i < menuEntry.length; i++) {
                    System.out.println(i + ") " + menuEntry[i]);
                }
                break;
            case 0:
                for (int i = 0; i < menuEntry.length; i++) {
                    System.out.println(menuEntry[i]);
                }
                break;
        }
        //return  evaluate(r.read(),menuEntry,yesNoOrNumber);
    }


    private int evaluate(String[] menuEntry, short yesNoOrNumber){
//        int result = 0;
        ReadLine r = new ReadLine();
        String answer = r.read();
        int ianswer = 999;
        try {
            ianswer=Integer.parseInt(answer);
        }catch (Exception e){
            ianswer = menuEntry.length+1;
        }
        switch (yesNoOrNumber){
            case 1:                             //Answer ist tested for yes or no in different ways
                if(answer.toLowerCase().equals("yes")||answer.toLowerCase().equals("y")|| ianswer==1){
                    return 1;
                }if(answer.toLowerCase().equals("no")||answer.toLowerCase().equals("n")||ianswer==0) {
                    return 0;
                }else {
//                    System.out.println("Fehler mit der Ja Nein erkennung");
                    return 99;
                }

            case 2:
                for (int i = 0; i < menuEntry.length ; i++) {
                    if(answer.toLowerCase().equals(menuEntry[i].toLowerCase())){
                        return i;
                    }if(ianswer == i){
                        return i;
                    }
                }
        }
//        System.out.println("ganz eigentümlich");
        return 99;
    }
}
