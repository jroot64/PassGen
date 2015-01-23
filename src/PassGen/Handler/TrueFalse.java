package PassGen.Handler;

/**
 * Created by Jonas on 23.01.2015.
 */
public class TrueFalse {
    public static boolean[] analyse(String pass){
        boolean[] tf = new boolean[4];
        for (int i = 0; i < 4; i++) {tf[i]=false;}

        char[] toanalyse = pass.toCharArray();

        for (int i = 0; i < toanalyse.length; i++) {
            int itoanalyse=(int)toanalyse[i];
            if(itoanalyse<91 && itoanalyse > 64){tf[0]=true;}
            else if(itoanalyse<123 && itoanalyse > 96){tf[1]=true;}
            else if(itoanalyse<58 && itoanalyse >47){tf[2]=true;}
            else {tf[3]=true;}
        }
        return tf;
    }
}
