package by.aghmi.utils;

import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class CryptoUtils {
     
        private static final String UNICODE_FORMAT;
        private static final String DESEDE_ENCRYPTION_SCHEME;
        private  static final String MY_ENCRYPT_KEY;
        
        static {
            UNICODE_FORMAT = AppSettings.getSettings().getProp("UNICODE_FORMAT");
            DESEDE_ENCRYPTION_SCHEME = AppSettings.getSettings().getProp("DESEDE_ENCRYPTION_SCHEME");
            MY_ENCRYPT_KEY = AppSettings.getSettings().getProp("MY_ENCRYPT_KEY");
        }
        
        private KeySpec ks;
        private SecretKeyFactory skf;
        private Cipher cipher;
        byte[] arrayBytes;
        
        private String myEncryptionScheme;
        SecretKey key;

        public CryptoUtils() throws Exception {
            myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
            arrayBytes = MY_ENCRYPT_KEY.getBytes(UNICODE_FORMAT);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = skf.generateSecret(ks);
        }


        public String encrypt(String unencryptedString) {
            String encryptedString = null;
            try {
                cipher.init(Cipher.ENCRYPT_MODE, key);
                byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
                byte[] encryptedText = cipher.doFinal(plainText);
                encryptedString = new String(Base64.encodeBase64(encryptedText));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encryptedString;
        }


        public String decrypt(String encryptedString) {
            String decryptedText=null;
            try {
                cipher.init(Cipher.DECRYPT_MODE, key);
                byte[] encryptedText = Base64.decodeBase64(encryptedString);
                byte[] plainText = cipher.doFinal(encryptedText);
                decryptedText= new String(plainText);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return decryptedText;
        }


        public static void main(String args []) throws Exception
        {
            CryptoUtils td= new CryptoUtils();

            String target="dovkiranpidor";
           // String decrypted_test=td.decrypt(target);
            String encrypted=td.encrypt(target);
            String decrypted=td.decrypt(encrypted);
            System.out.println("String To Encrypt: "+ target);
            System.out.println("Encrypted String:" + encrypted);
            System.out.println("Decrypted String:" + decrypted);

        }
}
