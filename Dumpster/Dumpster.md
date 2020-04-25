# Dumpster

I found a flag, but it was encrypted! Our systems have detected that someone has successfully decrypted this flag, and we stealthily took a heap dump of the program (in Java). Can you recover the flag for me? Here's the source code of the Java program and the heap dump: `https://mega.nz/#!rHYGlAQT!48DlH2pSZg10Ei3f-Ivm7RoNBbV16Qw0wN4cWxANUwY`

If we look at the source code:

```java
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decryptor {
    public static final String FLAG = "S+kUZtaHEYpFpv2ixuTnqBdORNzsdVJrAxWznyOljEo=";
    private static class Password {
        private byte[] passHash;

        public Password(char[] pass) throws Exception {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            this.passHash = Arrays.copyOf(digest.digest(new String(pass).getBytes("UTF-8")), 16);
        }

        public byte[] encrypt(byte[] msg) throws Exception {
            SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, spec);
            return cipher.doFinal(msg);
        }

        public byte[] decrypt(byte[] msg) throws Exception {
            SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, spec);
            return cipher.doFinal(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        Password pass = new Password(System.console().readPassword("Enter password to decrypt flag: "));
        System.out.println(new String(pass.decrypt(Base64.getDecoder().decode(FLAG.getBytes()))));
        Thread.sleep(5000); //We did a heap dump right here.
    }
}
```

Since we did a heap dump right at `Thread.sleep`, we can open the `heapdump.hprof` file with Java VisualVM and go to `Threads` on the top left corner of the main panel. Then, scroll down to find `at Decryptor.main`. In there, we can find a variable called `passHash` and we can use that to fill into the Decryptor.

```java
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Solve {
    public static final String FLAG = "S+kUZtaHEYpFpv2ixuTnqBdORNzsdVJrAxWznyOljEo=";
    private static class Password {
        private byte[] passHash;

        public Password() throws Exception {
            this.passHash = new byte[] {
                7, 95, -34, 16, -89, -86, 73, 108,
                -128, 71, 43, 41, 100, 40, 53, -24
            };
        }

        public byte[] encrypt(byte[] msg) throws Exception {
            SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, spec);
            return cipher.doFinal(msg);
        }

        public byte[] decrypt(byte[] msg) throws Exception {
            SecretKeySpec spec = new SecretKeySpec(passHash, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, spec);
            return cipher.doFinal(msg);
        }
    }

    public static void main(String[] args) throws Exception {
        Password pass = new Password();
        System.out.println(new String(pass.decrypt(Base64.getDecoder().decode(FLAG.getBytes()))));
        Thread.sleep(5000); //We did a heap dump right here.
    }
}
```

When we run the program, we get the flag `stCTF{h34p_6ump5_r_c00l!11!!}`
