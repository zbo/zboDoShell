// ****************************************************************************
// Copyright (c) 2010 SafeNet, Inc. All rights reserved.
//
// All rights reserved.  This file contains information that is
// proprietary to SafeNet, Inc. and may not be distributed
// or copied without written consent from SafeNet, Inc.
// ****************************************************************************
package safenet;

import com.google.common.io.ByteStreams;
import com.safenetinc.luna.LunaSlotManager;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.io.*;
import java.security.Key;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.Enumeration;

import static com.google.common.io.BaseEncoding.base64;
import static java.nio.charset.Charset.defaultCharset;

/**
 * This sample demonstrates RSA OAEP encryption
 */
public class RsaOAEPUsingExistKeyPair {
    private static final int BLOCK_SIZE = 4 * 1024;

    protected static void transform(InputStream inputStream, OutputStream outputStream, Cipher cipher) throws IOException, IllegalBlockSizeException, BadPaddingException {
        byte[] buf = new byte[BLOCK_SIZE];

        int len;
        while ((len = ByteStreams.read(inputStream, buf, 0, BLOCK_SIZE)) == BLOCK_SIZE) {
            outputStream.write(cipher.update(buf));
        }
        outputStream.write(cipher.doFinal(buf, 0, len));
    }

    public static void main(String args[]) throws Exception {
        LunaSlotManager manager;
        manager = LunaSlotManager.getInstance();
        System.out.println("[version] 1.3");
        try {
            manager.login("Welcome1"); // log in to the first slot
        } catch (Exception e) {
            System.out.println("Exception during login");
        }
        while (true) {
            Cipher cipher = null;
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING","LunaProvider");

                KeyStore keyStore;
                keyStore = KeyStore.getInstance("Luna", "LunaProvider");
                char[] password = "Welcome1".toCharArray();
                keyStore.load(null, password);
                System.out.println("[key store size] " + keyStore.size());
                Enumeration<String> aliases = keyStore.aliases();
                String a = "";
                while (aliases.hasMoreElements()) {
                    a = aliases.nextElement();
                    System.out.println("[alias] " + a);
                }
                System.out.println("[key alias] " + keyStore.aliases().nextElement());
                Key otherKey = keyStore.getKey("otherKey", "Welcome1".toCharArray());
                Key panKey = keyStore.getKey("PANKey", "Welcome1".toCharArray());
                Key fileKey = keyStore.getKey("fileKey", "Welcome1".toCharArray());
                System.out.println("[out] file key is:");
                System.out.println(otherKey.toString());

                cipher.init(1, otherKey);

                String originalText = "test for luna";
                InputStream inputStream = new ByteArrayInputStream(originalText.getBytes());
                final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                transform(inputStream, outputStream, cipher);
                final byte[] encryptedString = outputStream.toByteArray();
                System.out.println("[out] encrypted string is:");
                System.out.println(encryptedString.toString());

                System.out.println("[sleep] 2s");
                Thread.sleep(2000);


            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
