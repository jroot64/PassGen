package PassGen;


import PassGen.Handler.AESHandler;

import java.io.*;

/**
 * Created by Jonas on 23.01.2015.
 */
public class FileIteraction {
    private FileIteraction objekt;
    private int i=0;

    public void savePassPhrases(List allPassPhrase){
        if (objekt==null){
            try{
                FileWriter fw = new FileWriter("save.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(AESHandler.encrypt(String.valueOf(allPassPhrase.getLength())));
                bw.newLine();
                for (int j = 0; j < allPassPhrase.getLength(); j++) {
                    bw.write(AESHandler.encrypt(allPassPhrase.getsave(j).getPassForApplication()));
                    bw.newLine();
                    bw.write(AESHandler.encrypt(allPassPhrase.getsave(j).getPassPhrese()));
                    bw.newLine();
                }
                bw.newLine();

                bw.close();
                i++;
            }catch (Exception e){

            }
        }


    }
    public List readPassPhrases() {
//        int i;
        List allPassPhrases = new List();
        try{
            FileReader fr = new FileReader("save.txt");
            BufferedReader br = new BufferedReader(fr);
            i = Integer.parseInt(AESHandler.decrypt(br.readLine()));
            for (int j = 0; j < i; j++) {
                Password pass = new Password(true);
                pass.setPassForAplication(AESHandler.decrypt(br.readLine()));
                pass.setPassPhrese(AESHandler.decrypt(br.readLine()));
                allPassPhrases.save(pass);
                pass.analyse();
            }
        }catch (Exception e){}
        return allPassPhrases;
    }
}
