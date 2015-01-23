package PassGen.FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jonas on 23.01.2015.
 */
public class FileIteraction {
    private FileIteraction objekt;
    private int i=0;

    public void FileIteraction(){
        if (objekt==null){
            try{
                FileWriter fw = new FileWriter("save.txt");
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("test,test,test " +i );
                bw.newLine();

                bw.close();
                i++;
            }catch (Exception e){

            }
        }


    }
}
