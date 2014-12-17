package safenet;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import static com.google.common.io.BaseEncoding.base64;

public class BlowfishApp {
    public static void main(String args[]) {
        try {
            byte kbtye[] = "ildskey".getBytes();
            final String blowfish = "Blowfish";
            SecretKeySpec key = new SecretKeySpec(kbtye, blowfish);
            System.out.println(key);
            Cipher cipher = Cipher.getInstance(blowfish);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            cipher.update("hello".getBytes());
            byte[] result = cipher.doFinal();
            System.out.println(base64().encode(result));
            cipher.init(Cipher.DECRYPT_MODE, key);
            System.out.println(new String(cipher.doFinal(result)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
