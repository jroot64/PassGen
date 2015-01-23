package PassGen.Handler;

import PassGen.ReadLine;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Jonas on 23.01.2015.
 */
public class AESHandler {
    private static SecretKeySpec secretKeySpec;

    public static void key() {
        ReadLine r = new ReadLine();
        System.out.println("Geben sie das Passwort ein.");
        try{
            // Das Passwort bzw der Schluesseltext
            String keyStr = r.read();
            // byte-Array erzeugen
            byte[] key = (keyStr).getBytes("UTF-8");
            // aus dem Array einen Hash-Wert erzeugen mit MD5 oder SHA
            MessageDigest sha = MessageDigest.getInstance("MD5");
            key = sha.digest(key);
            // nur die ersten 128 bit nutzen
            key = Arrays.copyOf(key, 16);
            // der fertige Schluessel
            secretKeySpec = new SecretKeySpec(key, "AES");
        }catch (Exception e){}
    }

    public static String encrypt(String text){
        String geheim = "";
//        key();
        try{
            // Verschluesseln
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            // bytes zu Base64-String konvertieren (dient der Lesbarkeit)
            BASE64Encoder myEncoder = new BASE64Encoder();
            geheim = myEncoder.encode(encrypted);
            // Ergebnis

        }catch (Exception e){}
        return geheim;
    }
    public static String decrypt(String geheim){
        String erg="";
//        key();
        try{
            // BASE64 String zu Byte-Array konvertieren
            BASE64Decoder myDecoder2 = new BASE64Decoder();
            byte[] crypted2 = myDecoder2.decodeBuffer(geheim);

            // Entschluesseln
            Cipher cipher2 = Cipher.getInstance("AES");
            cipher2.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] cipherData2 = cipher2.doFinal(crypted2);
            erg = new String(cipherData2);

        }catch (Exception e){}
        return erg;
    }
}
