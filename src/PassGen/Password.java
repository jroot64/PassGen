package PassGen;


public class Password {
    Menu menu = new Menu();
    private ReadLine r = new ReadLine();
    String passPhrase;
    String passForAplication;
    int length;
    boolean upperLetter;
    boolean lowerLetter;
    boolean spezialLetters;
    boolean numberLetter;

    public Password(String application, int length, boolean upperLetter, boolean lowerLetter, boolean spezialLetters, boolean numberLetter){
        setPassForAplication(application);

        setLength(length);

        setUpperLetter(upperLetter);

        setLowerLetter(lowerLetter);

        setSpezialLetters(spezialLetters);

        setNumberLetter(numberLetter);
    }
    public Password(){

        System.out.println("Wie lang soll das Password sein?");
        setLength(Integer.parseInt(r.read()));

        System.out.println("Für welches Programm ist das Passwort?");
        String name = r.read();
        setPassForAplication(name);

        setUpperLetter(menu.menu("Sollen Großbuchstaben in dem Passwort sein?"));
//        System.out.println("Sollen Großbuchstaben in dem Passwort sein\n ja oder nein?");
//        String upperLetter = r.read();
//        if(upperLetter.equals("ja") || upperLetter.equals("Ja")){
//            setUpperLetter(true);
//        }else{
//            setUpperLetter(false);
//        }
        setLowerLetter(menu.menu("Sollen Kleinbuchstaben in dem Passwort sein?"));
//        System.out.println("Sollen Kleinbuchstaben in dem Passwort sein\n ja oder nein?");
//        String lowerLetter = r.read();
//        if(lowerLetter.equals("ja") || lowerLetter.equals("Ja")){
//            setLowerLetter(true);
//        }else{
//            setLowerLetter(false);
//        }
        setSpezialLetters(menu.menu("Sollen Sonderzeichen in dem Passwort sein?"));
//        System.out.println("Sollen Sonderzeichen in dem Passwort sein\n ja oder nein?");
//        String spezialLetter = r.read();
//        if(spezialLetter.equals("ja") || spezialLetter.equals("Ja")){
//            setSpezialLetters(true);
//        }else{
//            setSpezialLetters(false);
//        }
        setNumberLetter(menu.menu("Sollen Zahlen in dem Passwort sein?"));
//        System.out.println("Sollen Zahlen in dem Passwort sein\n ja oder nein?");
//        String numberLetter = r.read();
//        if(numberLetter.equals("ja") || numberLetter.equals("Ja")){
//            setNumberLetter(true);
//        }else{
//            setNumberLetter(false);
//        }

    }

    protected void genNewPassPhrase(){
        String passPhrase;
        int a=0;
        boolean l,s,u,n,badRound;
//        if (isUpperLetter() == false) {System.out.println("1.1");}
//        if (isLowerLetter()==false) {System.out.println("2.1");}
//        if (isSpezialLetters()==false) {System.out.println("3.1");}
//        if (isNumerwLetter()==false) {System.out.println("4.1");}
        do {
//            badPassPhrase=false;
            passPhrase = "";
            //Initialising the booleans for testing the pass of it´s letters that it should contain
            l=false;
            s=false;
            u=false;
            n=false;
            for (int i = 0; i < length; i++) {      //Star generating the Pass letter by letter
                do {
                    badRound=false;
                    a = (int) (Math.random() * 95 + 32);
//                    System.out.println(a);
                    if(!isLowerLetter()){if(a > 96 && a < 123){badRound=true;}}       //Testing the randomletter for forbidden letter
                    if(!isUpperLetter()){if(a > 64 && a < 91){badRound=true;}}
                    if(!isNumerwLetter()){if(a > 47 && a < 58){badRound=true;}}
                    if(!isSpezialLetters()){if((a>32 && a<48)||(a>57 && a<65)||(a>90 && a<97)||(a>122)){badRound=true;}}
                } while (badRound);
                //System.out.println((char)a);      //line is just for checking the correct working of the code
                passPhrase = passPhrase + (char) a; //adding the random letter that is allowed to the pass
                if (a > 64 && a < 91) {             //setting booleans for testing whether oll letters are in the pass that should
                    u = true;
                } else if (a > 96 && a < 123) {
                    l = true;
                } else if (a > 47 && a < 58) {
                    n = true;
                } else {
                    s = true;
                }
            }
        } while (u != isUpperLetter() || l != isLowerLetter() || n != isNumerwLetter() || s != isSpezialLetters()); //testing whether the pass contains all allowed letters
        System.out.println("Das Passwort ist : " + passPhrase);
        setPassPhrese(passPhrase);
    }
    protected void changeApplication(){
//        ReadLine br = new ReadLine();
        System.out.println("Wie heißt die Aplikation zu der das Password gehört.");
        setPassForAplication(r.read());
    }

    public String getPassForApplication() {
        return passForAplication;
    }
    public String getPassPhrese() {
        return passPhrase;
    }
    public int getLength() {
        return length;
    }

    public void setPassForAplication(String passForAplication) {
        this.passForAplication = passForAplication;
    }
    private void setPassPhrese(String passPhrese) {
        this.passPhrase = passPhrese;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setNumberLetter(boolean numerwLetter) {
        this.numberLetter = numerwLetter;
    }
    public void setUpperLetter(boolean upperLetter) {
        this.upperLetter = upperLetter;
    }
    public void setLowerLetter(boolean lowerLetter) {
        this.lowerLetter = lowerLetter;
    }
    public void setSpezialLetters(boolean spezialLetters) {
        this.spezialLetters = spezialLetters;
    }

    public boolean isLowerLetter() {
        return lowerLetter;
    }
    public boolean isSpezialLetters() {
        return spezialLetters;
    }
    public boolean isNumerwLetter() {
        return numberLetter;
    }
    public boolean isUpperLetter() {
        return upperLetter;
    }


    //Convert IO to true and false for the specifications of the passwords
    public void setNumberLetter(int numerwLetter) {
        this.numberLetter = truefalse(numerwLetter);
    }
    public void setUpperLetter(int upperLetter) {
        this.upperLetter = truefalse(upperLetter);
    }
    public void setLowerLetter(int lowerLetter) {
        this.lowerLetter = truefalse(lowerLetter);
    }
    public void setSpezialLetters(int spezialLetters) {
        this.spezialLetters = truefalse(spezialLetters);
    }

    private boolean truefalse(int i){
        switch (i){
            case 0:
                return false;
            case 1:
                return true;
        }
        return true;
    }

}